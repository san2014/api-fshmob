package br.ba.ssa.fisio.security.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ba.ssa.fisio.model.ResponseApi;
import br.ba.ssa.fisio.security.JwtTokenUtil;
import br.ba.ssa.fisio.security.SenhaUtils;
import br.ba.ssa.fisio.security.dto.JwtAuthenticationDto;
import br.ba.ssa.fisio.security.dto.TokenDto;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="*")
public class AuthenticationController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	
	private static final String TOKEN_HEADER = "Authorization";

	private static final String BEARER_PREFIX = "Bearer";	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping
	public ResponseEntity<ResponseApi<TokenDto>> gerarTokenJwt(@Valid @RequestBody JwtAuthenticationDto authenticationDto,
			BindingResult result) throws AuthenticationException{
		
		ResponseApi<TokenDto> response​ = new ResponseApi<TokenDto>();
		
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response​);
		}		
		
		log.info("Gerando token para o email {}.", authenticationDto.getEmail());
		
		log.info(SenhaUtils.gerarBCrypt(authenticationDto.getSenha()));
		
		Authentication authentication = this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationDto.getEmail(), authenticationDto.getSenha()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDto.getEmail());
		
		String token = jwtTokenUtil.obterToken​(userDetails);
		
		response​.setData(this.getTokenDto(token));
		
		return ResponseEntity.ok(response​);
		
	}
	
	@PostMapping(value="/refresh")
	public ResponseEntity<ResponseApi<TokenDto>> gerarRefreshTokenJwt(HttpServletRequest request){
		
		log.info("Gerando refresh token JWT");
		
		ResponseApi<TokenDto> responseApi​ = new ResponseApi<TokenDto>();
		
		Optional<String> token = Optional.ofNullable(request.getHeader(TOKEN_HEADER));
		
		if(token.isPresent() && token.get().startsWith(BEARER_PREFIX)) {
			token = Optional.of(token.get().substring(7));
		}
		
		if(!token.isPresent()) {
			responseApi​.getErros().add("Acesso negado");
		}
		
		if(!responseApi​.getErros().isEmpty()) {
			return ResponseEntity.badRequest().body(responseApi​);
		}
		
		Optional<String> refreshdToken = Optional.ofNullable(jwtTokenUtil.refreshToken​(token.get()));
		
		if(!refreshdToken.isPresent()) {
			responseApi​.getErros().add("Token inválido ou expirado");
			return ResponseEntity.badRequest().body(responseApi​);			
		}
		
		responseApi​.setData(this.getTokenDto(refreshdToken.get()));
		
		return ResponseEntity.ok(responseApi​);
		
	}
	
	@GetMapping(value="checkAdmin/{nome}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String checkAdmin(@PathVariable("nome") String nome) {
		return "Olá" + nome;
	}
	
	private TokenDto getTokenDto(String token) {
		
		TokenDto tokenDto = new TokenDto();
		
		tokenDto.setToken(token);
		
		tokenDto.setDataExpiracao(jwtTokenUtil.getExpirationDateFromToken​(token));

		return tokenDto;
		
	}

}
