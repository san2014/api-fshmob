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
import br.ba.ssa.fisio.model.TipoAtendimento;
import br.ba.ssa.fisio.service.TipoAtendimentoService;

@RestController
@RequestMapping(value = "/tipoAtendimento")
public class TipoAtendimentoResource {

	@Autowired
	private TipoAtendimentoService tipoAtendimentoService;

	@GetMapping
	public ResponseEntity<ResponseApi<List<TipoAtendimento>>> listar() {

		List<TipoAtendimento> lista = this.tipoAtendimentoService.listar();

		return ResponseEntity.ok(new ResponseApi<List<TipoAtendimento>>(lista));

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseApi<TipoAtendimento>> obter(@PathVariable("id") String id) {

		TipoAtendimento tipoAtendimento = this.tipoAtendimentoService.obter(id);

		return ResponseEntity.ok(new ResponseApi<TipoAtendimento>(tipoAtendimento));

	}

	@PostMapping
	public ResponseEntity<ResponseApi<TipoAtendimento>> incluir(@Valid @RequestBody TipoAtendimento tipoAtendimento,
			BindingResult result) {

		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseApi<TipoAtendimento>(erros));
		}

		this.tipoAtendimentoService.incluir(tipoAtendimento);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tipoAtendimento.getId())
				.toUri();

		return ResponseEntity.created(uri).body(new ResponseApi<TipoAtendimento>(tipoAtendimento));

	}

	@PutMapping(value = "{id}")
	public ResponseEntity<ResponseApi<TipoAtendimento>> atualizar(@PathVariable("id") String id,
			@Valid @RequestBody TipoAtendimento tipoAtendimento, BindingResult result) {

		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseApi<TipoAtendimento>(erros));
		}

		tipoAtendimento.setId(id);

		this.tipoAtendimentoService.atualizar(tipoAtendimento);

		return ResponseEntity.ok(new ResponseApi<TipoAtendimento>(tipoAtendimento));

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseApi<Boolean>> deletar(@PathVariable("id") String id) {

		this.tipoAtendimentoService.excluir(id);

		return ResponseEntity.ok(new ResponseApi<Boolean>(true));

	}

}
