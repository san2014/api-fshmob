package br.ba.ssa.fisio.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.ba.ssa.fisio.model.Perfil;
import br.ba.ssa.fisio.model.Usuario;

public class JwtUserFactory {
	
	private JwtUserFactory() {}
	
	public static JwtUser create(Usuario usuario) {
		return new JwtUser(usuario.getId(), usuario.getEmail(), usuario.getSenha(), 
				mapToGrantedAuthorities(usuario.getPerfil()));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(Perfil perfil){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfil.toString()));
		return authorities;
	}
	
}	
