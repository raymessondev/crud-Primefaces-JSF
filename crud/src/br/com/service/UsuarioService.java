package br.com.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.repository.UsuarioDAO;
import br.com.model.Usuario;

@Stateless
public class UsuarioService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioDAO usuarioDAO;

	// CRIAR

	public void criar(Usuario usuario) {

		usuarioDAO.criar(usuario);

	}

	// LISTAR
	public List<Usuario> listar() {
		return usuarioDAO.listar();
	}
	// EDITAR

	// DELETAR
	public void deletar(Usuario usuario) {
		usuarioDAO.deletar(usuario);
	}

	public void atualizar(Usuario usuario) {
		usuarioDAO.atualizar(usuario);
		
	}

	// BUSCAR
	public Usuario buscar(Usuario usuario){
		return usuarioDAO.buscar(usuario);
	}

}
