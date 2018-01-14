package br.com.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.model.Usuario;

public class UsuarioDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	public void criar(Usuario usuario) {
		try {

			this.manager.persist(usuario);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		System.out.println();
		return this.manager.createQuery("Select p from Usuario p").getResultList();

	}

	public void deletar(Usuario usuario) {
		Usuario tmp = this.manager.merge(usuario);
		this.manager.remove(tmp);
	}
	
	public void atualizar(Usuario usuario){
		this.manager.merge(usuario);
		this.manager.flush();
	}
	
	public Usuario buscar(Usuario usuario) {
		return this.manager.find(Usuario.class, usuario.getIdUsuario());
	}

}