package br.ba.ssa.fisio.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ba.ssa.fisio.model.Cliente;
import br.ba.ssa.fisio.model.ResponseApi;
import br.ba.ssa.fisio.service.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<ResponseApi<List<Cliente>>> listar(){
		
		List<Cliente> lista = this.clienteService.listar();
		
		return ResponseEntity.ok(new ResponseApi<List<Cliente>>(lista));
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ResponseApi<Cliente>> obter(@PathVariable("id") Long id){
		
		Cliente cliente = this.clienteService.obter(id);
		
		return ResponseEntity.ok(new ResponseApi<Cliente>(cliente));
		
	}	

	@PostMapping
	public ResponseEntity<ResponseApi<Cliente>> inserir(@Valid @RequestBody Cliente cliente, BindingResult result) {

		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseApi<Cliente>(erros));
		}

		clienteService.inserir(cliente);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();

		return ResponseEntity.created(uri).body(new ResponseApi<Cliente>(cliente));

	}	
	
	@PutMapping
	public ResponseEntity<ResponseApi<Cliente>> atualizar(@Valid @RequestBody Cliente cliente, BindingResult result) {

		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new ResponseApi<Cliente>(erros));
		}

		clienteService.atualizar(cliente);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();

		return ResponseEntity.created(uri).body(new ResponseApi<Cliente>(cliente));

	}	

}
