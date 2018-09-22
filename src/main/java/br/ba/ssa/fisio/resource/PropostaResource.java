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

import br.ba.ssa.fisio.model.Proposta;
import br.ba.ssa.fisio.model.ResponseApi;
import br.ba.ssa.fisio.service.PropostaService;

@RestController
@RequestMapping(value="/proposta")
public class PropostaResource {
	
	@Autowired
	private PropostaService propostaSevrice;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ResponseApi<Proposta>> obter(@PathVariable("id") Long id){
		
		Proposta proposta = this.propostaSevrice.obter(id);
		
		return ResponseEntity.ok(new ResponseApi<Proposta>(proposta));
		
	}	
	
	@PostMapping
	public ResponseEntity<ResponseApi<Proposta>> inserir(@Valid @RequestBody Proposta proposta, BindingResult result) {

		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseApi<Proposta>(erros));
		}

		this.propostaSevrice.inserir(proposta);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proposta.getId()).toUri();

		return ResponseEntity.created(uri).body(new ResponseApi<Proposta>(proposta));

	}	
	
	@PutMapping
	public ResponseEntity<ResponseApi<Proposta>> atualizar(@Valid @RequestBody Proposta proposta, BindingResult result) {

		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseApi<Proposta>(erros));
		}

		this.propostaSevrice.atualizar(proposta);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proposta.getId()).toUri();

		return ResponseEntity.created(uri).body(new ResponseApi<Proposta>(proposta));

	}	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseApi<Boolean>> deletar(@PathVariable("id") Long id) {

		this.propostaSevrice.deletar(id);

		return ResponseEntity.ok(new ResponseApi<Boolean>(true));

	}	
	

}
