package br.ba.ssa.fisio.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ba.ssa.fisio.model.Perfil;
import br.ba.ssa.fisio.model.ResponseApi;
import br.ba.ssa.fisio.service.PerfilService;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilResource {

	@Autowired
	private PerfilService perfilService;
	
	@GetMapping
	public ResponseEntity<ResponseApi<List<Perfil>>> listar(){
		
		List<Perfil> lista = this.perfilService.listar();
		
		return ResponseEntity.ok(new ResponseApi<List<Perfil>>(lista));
		
	}

	@PostMapping
	public ResponseEntity<ResponseApi<Perfil>> inserir(@Valid @RequestBody Perfil perfil, BindingResult result) {

		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseApi<Perfil>(erros));
		}

		perfilService.inserir(perfil);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(perfil.getId()).toUri();

		return ResponseEntity.created(uri).body(new ResponseApi<Perfil>(perfil));

	}

}
