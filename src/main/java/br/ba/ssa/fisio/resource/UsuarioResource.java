package br.ba.ssa.fisio.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ba.ssa.fisio.model.ResponseApi;
import br.ba.ssa.fisio.model.Usuario;
import br.ba.ssa.fisio.service.UsuarioService;

@RestController
@RequestMapping(value="usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<ResponseApi<List<Usuario>>> listar(){
		return ResponseEntity.ok(new ResponseApi<List<Usuario>>(usuarioService.listar())); 
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ResponseApi<Usuario>> obter(@PathVariable("id") String id){
		
		Usuario usuario = this.usuarioService.obter(id);
		
		return ResponseEntity.ok(new ResponseApi<Usuario>(usuario));
		
	}
	
	@PostMapping
	public ResponseEntity<ResponseApi<Usuario>> incluir(@Valid @RequestBody Usuario usuario, BindingResult result){
		
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseApi<Usuario>(erros));
		}
		
		this.usuarioService.incluir(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(usuario.getId()).toUri();

		return ResponseEntity.created(uri).body(new ResponseApi<Usuario>(usuario));
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ResponseApi<Usuario>> atualizar(@PathVariable("id") String id, @Valid @RequestBody Usuario usuario, BindingResult result){
		
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseApi<Usuario>(erros));
		}		
		
		usuario.setId(id);
		
		this.usuarioService.atualizar(usuario);
		
		return ResponseEntity.ok(new ResponseApi<Usuario>(usuario));
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<ResponseApi<Boolean>> deletar(@PathVariable("id") String id) {
		
		this.usuarioService.excluir(id);
		
		return ResponseEntity.ok(new ResponseApi<Boolean>(true));
		
	}

}
