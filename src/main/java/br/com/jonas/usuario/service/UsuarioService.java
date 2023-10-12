package br.com.jonas.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jonas.usuario.dto.UsuarioDTO;
import br.com.jonas.usuario.model.Usuario;
import br.com.jonas.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository ur; 
	
	public List<UsuarioDTO> listar (){
		List<Usuario> usuario = ur.findAll();
		return usuario.stream().map(UsuarioDTO::new).toList();
	}
	
	public void salvar (UsuarioDTO usuariodto) {
		Usuario usuario = new Usuario(usuariodto);
		ur.save(usuario);
		
	}
	
	public UsuarioDTO alterar (UsuarioDTO usuariodto) {
		Usuario usuario = new Usuario(usuariodto);
		return new UsuarioDTO(ur.save(usuario));
		
	}
	
	public void deletar (Long id) {
	Usuario usuario = ur.findById(id).get();
	ur.delete(usuario);
	}
	
	public UsuarioDTO buscarPorId (Long id) {
		return new UsuarioDTO(ur.findById(id).get());
	}
	

}
