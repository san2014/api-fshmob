package br.ba.ssa.fisio.security.config;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.ba.ssa.fisio.model.Cliente;
import br.ba.ssa.fisio.model.Especialidade;
import br.ba.ssa.fisio.model.Perfil;
import br.ba.ssa.fisio.model.TipoAtendimento;
import br.ba.ssa.fisio.model.Usuario;
import br.ba.ssa.fisio.repository.ClienteRepository;
import br.ba.ssa.fisio.repository.EspecialidadeRepository;
import br.ba.ssa.fisio.repository.PerfilRepository;
import br.ba.ssa.fisio.repository.TipoAtendimentoRepository;
import br.ba.ssa.fisio.repository.UsuarioRepository;
import br.ba.ssa.fisio.security.SenhaUtils;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	PerfilRepository perfilRepository;
	
	@Autowired
	EspecialidadeRepository especialidadeRepository;
	
	@Autowired
	TipoAtendimentoRepository tipoAtendimentoRepository;
	
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    ClienteRepository clienteRepository;
    

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
    	
    	this.cargaEspecialidades();
    	
    	this.cargaTipoAtendimentos();

    	this.cargaPerfis();

    	this.cargaUsuario();
    	
    	this.cargaCliente();

    }
    
    private void cargaPerfis() {
    	
    	List<Perfil> perfis = perfilRepository.findAll();
    	
    	if (perfis.isEmpty()) {
    		
    		Perfil perfil1 = new Perfil(1L, "Administrador", true);
    		
    		Perfil perfil2 = new Perfil(2L, "Cliente", true);
    		
    		Perfil perfil3 = new Perfil(3L, "Profissional", true);
    		
    		perfilRepository.save(perfil1);
    		
    		perfilRepository.save(perfil2);
    		
    		perfilRepository.save(perfil3);
    		
    	} 
    	
    }
    
    private void cargaEspecialidades() {
    	
    	List<Especialidade> especialidades = this.especialidadeRepository.findAll();
    	
    	if (especialidades.isEmpty()) {
    		
    		Especialidade especialidade1 = new Especialidade(1L, "Ortopedia", true);
    		Especialidade especialidade2 = new Especialidade(2L, "Pediatria", true);
    		Especialidade especialidade3 = new Especialidade(3L, "Geriatria", true);
    		Especialidade especialidade4 = new Especialidade(4L, "Neurologia", true);
    		
    		especialidadeRepository.save(especialidade1);
    		especialidadeRepository.save(especialidade2);
    		especialidadeRepository.save(especialidade3);
    		especialidadeRepository.save(especialidade4);
    		
    	}
    	
    }
    
    private void cargaTipoAtendimentos() {
    	
    	List<TipoAtendimento> tiposAtendimentos = this.tipoAtendimentoRepository.findAll();
    	
    	if (tiposAtendimentos.isEmpty()) {
    		
    		TipoAtendimento tipoAtendimento1 = new TipoAtendimento(1L);
    		tipoAtendimento1.setEspecialidade(new Especialidade(1L));
    		tipoAtendimento1.setImgUrl("assets/img/ortoped.png");
    		tipoAtendimento1.setValor(new BigDecimal("72.50"));
    		
    		TipoAtendimento tipoAtendimento2 = new TipoAtendimento(2L);
    		tipoAtendimento2.setEspecialidade(new Especialidade(2L));
    		tipoAtendimento2.setImgUrl("assets/img/pediatric.png");
    		tipoAtendimento2.setValor(new BigDecimal("76.80"));  

    		TipoAtendimento tipoAtendimento3 = new TipoAtendimento(3L);
    		tipoAtendimento3.setEspecialidade(new Especialidade(3L));
    		tipoAtendimento3.setImgUrl("assets/img/geriatric.png");
    		tipoAtendimento3.setValor(new BigDecimal("83.28"));  
    		
    		TipoAtendimento tipoAtendimento4 = new TipoAtendimento(4L);
    		tipoAtendimento4.setEspecialidade(new Especialidade(4L));
    		tipoAtendimento4.setImgUrl("assets/img/neuro.png");
    		tipoAtendimento4.setValor(new BigDecimal("87.36"));      		
    		
    		tipoAtendimentoRepository.save(tipoAtendimento1);
    		tipoAtendimentoRepository.save(tipoAtendimento2);
    		tipoAtendimentoRepository.save(tipoAtendimento3);
    		tipoAtendimentoRepository.save(tipoAtendimento4);
    		
    	}
    	
    }
    
	private void cargaUsuario() {

		List<Usuario> usuarios = usuarioRepository.findAll();

		if (usuarios.isEmpty()) {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			Usuario usuario = new Usuario();

			usuario.setNome("Alesandro Carvalho");
			usuario.setEmail("carvalho.alesandro@gmail.com");
			usuario.setCpf("01692866575");
			usuario.setRg("1118627873");
			usuario.setImgPerfil("");
			usuario.setApelido("San");
			usuario.setSenha(SenhaUtils.gerarBCrypt("123456"));

			try {
				usuario.setNascimento(sdf.parse("27/12/1984"));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			usuario.setCep(40430200l);
			usuario.setLogradouro("Rua Almirante Tamandaré");
			usuario.setPorta("59");
			usuario.setCidade("Salvador");
			usuario.setPerfil(new Perfil(1L));
			usuario.setBairro("Vila Ruy Barbosa");
			usuario.setAtivo(true);
			usuario.setSexo(Byte.valueOf("1"));
			usuario.setOnesignalId("ca21b035-cf16-47d4-80e8-6c27210d1293");

			this.usuarioRepository.save(usuario);

		}

	}
	
	private void cargaCliente() {
		
		List<Cliente> clientes = this.clienteRepository.findAll();
		
		if(clientes.isEmpty()) {
			
			Cliente cliente = new Cliente(null, new Usuario(2L), true);
			
			this.clienteRepository.save(cliente);
			
		}
	}
	

}