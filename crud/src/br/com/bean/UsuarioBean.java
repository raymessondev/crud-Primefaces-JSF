package br.com.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.model.Usuario;
import br.com.service.UsuarioService;

@ManagedBean
//@SessionScoped
@ViewScoped
// @RequestScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioService usuarioService;

	private Usuario usuario;
	private static Usuario usuarioaux;

	private List<Usuario> listUsuarios;

	@PostConstruct
	public void init() {
		if (usuarioaux == null || usuarioaux.getIdUsuario() == null) {
			usuario = new Usuario();
		} else {
			setUsuario(usuarioaux);
			usuarioaux = new Usuario();
		}
	}

	public void criar() {
		if (usuario.getIdUsuario() != null && usuarioService.buscar(usuario) != null) {

			usuarioService.atualizar(getUsuario());
		} else {
			usuarioService.criar(getUsuario());
		}

	}

	public String editar(Usuario usuario) {
		usuarioaux = new Usuario();
		usuarioaux = usuario;
		return "inserirUsuario.xhtml";
	}

	public List<Usuario> listar() {
		if (listUsuarios == null)
			listUsuarios = usuarioService.listar();
		return listUsuarios;
	}

	public void deletar(Usuario usuario) {
		listUsuarios.remove(usuario);
		usuarioService.deletar(usuario);
	}

	// GETS SETS

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListUsuario() {
		return listUsuarios;
	}

	public void setListUsuario(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}
}