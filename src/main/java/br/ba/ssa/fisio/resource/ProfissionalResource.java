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

import br.ba.ssa.fisio.model.Profissional;
import br.ba.ssa.fisio.model.ResponseApi;
import br.ba.ssa.fisio.service.ProfissionalService;

@RestController
@RequestMapping(value = "profissional")
public class ProfissionalResource {

	@Autowired
	private ProfissionalService profissionalService;

	@GetMapping
	public ResponseEntity<ResponseApi<List<Profissional>>> listar() {
		return ResponseEntity.ok(new ResponseApi<List<Profissional>>(this.profissionalService.listar()));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseApi<Profissional>> obter(@PathVariable("id") Long id) {

		Profissional profissional = this.profissionalService.obter(id);

		return ResponseEntity.ok(new ResponseApi<Profissional>(profissional));

	}

	@PostMapping
	public ResponseEntity<ResponseApi<Profissional>> incluir(@Valid @RequestBody Profissional profissional,
			BindingResult result) {

		if (result.hasErrors()) {
			
			List<String> erros = new ArrayList<String>();
			
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(new ResponseApi<Profissional>(erros));
			
		}

		this.profissionalService.incluir(profissional);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(profissional.getId())
				.toUri();

		return ResponseEntity.created(uri).body(new ResponseApi<Profissional>(profissional));

	}

	@PutMapping(value = "{id}")
	public ResponseEntity<ResponseApi<Profissional>> atualizar(@PathVariable("id") Long id,
			@Valid @RequestBody Profissional profissional, BindingResult result) {

		if (result.hasErrors()) {
			
			List<String> erros = new ArrayList<String>();
			
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(new ResponseApi<Profissional>(erros));
			
		}

		profissional.setId(id);

		profissional = this.profissionalService.atualizar(profissional);

		return ResponseEntity.ok(new ResponseApi<Profissional>(profissional));

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseApi<Boolean>> deletar(@PathVariable("id") Long id) {

		this.profissionalService.excluir(id);

		return ResponseEntity.ok(new ResponseApi<Boolean>(true));

	}
	
	@GetMapping(value = "/disponiveisEspecialidade/{idEspecialidade}/{cidade}")
	public ResponseEntity<ResponseApi<List<Profissional>>> disponiveisEspecialidade(
			@PathVariable("idEspecialidade") Long idEspecialidade, @PathVariable("cidade") String cidade) {

		List<Profissional> profissionais = this.profissionalService.disponiveisEspecialidade(idEspecialidade, cidade);

		return ResponseEntity.ok(new ResponseApi<List<Profissional>>(profissionais));

	}	

}
