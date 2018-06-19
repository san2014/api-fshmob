package br.ba.ssa.fisio.security.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.ba.ssa.fisio.model.Perfil;
import br.ba.ssa.fisio.model.PerfilEnum;
import br.ba.ssa.fisio.model.Usuario;
import br.ba.ssa.fisio.repository.PerfilRepository;
import br.ba.ssa.fisio.repository.UsuarioRepository;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {

        List<Usuario> usuarios = usuarioRepository.findAll();

        if (usuarios.isEmpty()) {
        	
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            Usuario usuario = new Usuario();
            
            usuario.setNome("Alesandro Carvalho");
            usuario.setEmail("carvalho.alesandro@gmal.com");
            usuario.setCpf(1692866575l);
            usuario.setRg("1118627873");
            usuario.setImgperfil("");
            usuario.setApelido("San");
            
            try {
				usuario.setNascimento(sdf.parse("27/12/1984"));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
            
            usuario.setCep(40430200l);
            usuario.setCidade("Salvador");
            usuario.setPerfil(PerfilEnum.ROLE_CLIENTE);
            usuario.setBairro("Vila Ruy Barbosa");
            usuario.setAtivo(true);
            usuario.setSexo(Byte.valueOf("1"));
            usuario.setOnesignalId("ca21b035-cf16-47d4-80e8-6c27210d1293");
            
            this.usuarioRepository.save(usuario);
            

            //usuarioRepository.save(new Usuario("ADMIN", "admin", "123", novosPerfis));

        }

    }

}