package br.com.jonas.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonas.usuario.dto.UsuarioDTO;
import br.com.jonas.usuario.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService us;
	
	@GetMapping
	public List<UsuarioDTO> listar(){
		return us.listar();		
		
	}
	
	@PostMapping
	public void inserir(@RequestBody UsuarioDTO usuario) {
		 us.salvar(usuario);
		
	}
	
	@PutMapping
	public UsuarioDTO alterar(@RequestBody UsuarioDTO usuario) {
		return us.alterar(usuario);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
		us.deletar(id);
		return ResponseEntity.ok().build();
	}

}
