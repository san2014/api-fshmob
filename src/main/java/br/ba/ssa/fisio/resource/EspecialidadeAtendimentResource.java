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

import br.ba.ssa.fisio.model.EspecialidadeAtendimento;
import br.ba.ssa.fisio.model.ResponseApi;
import br.ba.ssa.fisio.service.EspecialidadeAtendimentoService;

@RestController
@RequestMapping(value="/especialidade")
public class EspecialidadeAtendimentResource {

	@Autowired
	private EspecialidadeAtendimentoService especialidadeAtendimentoService;
	
	@GetMapping
	public ResponseEntity<ResponseApi<List<EspecialidadeAtendimento>>> listar(){
		
		List<EspecialidadeAtendimento> lista = this.especialidadeAtendimentoService.listar();
		
		return ResponseEntity.ok(new ResponseApi<List<EspecialidadeAtendimento>>(lista));
		
	}
	
	@PostMapping
	public ResponseEntity<ResponseApi<EspecialidadeAtendimento>> incluir(
			@Valid @RequestBody EspecialidadeAtendimento especialidadeAtendimento, BindingResult result) {

		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseApi<EspecialidadeAtendimento>(erros));
		}

		this.especialidadeAtendimentoService.incluir(especialidadeAtendimento);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(especialidadeAtendimento.getId()).toUri();

		return ResponseEntity.created(uri).body(new ResponseApi<EspecialidadeAtendimento>(especialidadeAtendimento));

	}
}
