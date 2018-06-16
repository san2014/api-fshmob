package br.ba.ssa.fisio.security.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.ba.ssa.fisio.model.Usuario;
import br.ba.ssa.fisio.security.JwtUserFactory;
import br.ba.ssa.fisio.service.UsuarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuario = this.usuarioService.buscaPorEmail(username);
		
		if (usuario.isPresent()) {
			return JwtUserFactory.create(usuario.get());
		}
		
		throw new UsernameNotFoundException("E-mail não encontrado");
	}
	
	

}
