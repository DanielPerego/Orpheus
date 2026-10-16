package main;

import java.util.ArrayList;

public class Usuario {
	protected boolean conta;
	private String nomeUsuario;
	protected String senha;
	private boolean logado;
	
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	
	public boolean createConta(String nomeUsuario, String senhaUsuario) {
		if(conta) {
			return false;
		}
		
		if (nomeUsuario == null || nomeUsuario.isBlank() || senhaUsuario == null || senhaUsuario.isBlank()) {
			return false;
		}
		
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getNomeUsuario().equalsIgnoreCase(nomeUsuario.trim()) && usuario.isConta()) {
				return false;
			}
		}
		
		setNomeUsuario(nomeUsuario.trim());
		setSenha(senhaUsuario);
		setConta(true);
		setLogado(false);
		
		listaUsuarios.add(this);
		
		return true;
	}

	public boolean excludeConta() {
		if(!conta) {
			return false;
		}
		
		listaUsuarios.remove(this);
		
		setSenha(null);
		setNomeUsuario(null);
		setConta(false);
		setLogado(false);
		
		return true;
	}
	
	public boolean updateInformacoesConta(String nomeUpdate, String senhaUpdate) {
		if(!conta || nomeUpdate == null || nomeUpdate.isBlank() || senhaUpdate == null || senhaUpdate.isBlank()) {
			return false;
		}
		
		nomeUpdate = nomeUpdate.trim();
		
		for(Usuario usuario : listaUsuarios) {
			if(usuario != this && usuario.isConta() && usuario.getNomeUsuario().equalsIgnoreCase(nomeUpdate)) {
				return false;
			}
		}
		
		setNomeUsuario(nomeUpdate);
		setSenha(senhaUpdate);
		
		return true;
	}
	
	public void showStatusUsuario() {
		System.out.println("Nome do Usuário: "+getNomeUsuario());
		System.out.println(isConta() ? "Status da Conta: Ativa" : "Status da Conta: Inativa");
	}
	
	public static Usuario buscarUsuario(String nome, String senha) {
		if(nome == null || senha == null) {
			return null;
		}
		
		for(Usuario usuario : listaUsuarios) {
			if(usuario.isConta() && nome.trim().equalsIgnoreCase(usuario.getNomeUsuario()) && senha.equals(usuario.getSenha())) {
				return usuario;
			}
		}
		return null;
	}
	
	public static boolean existeUsuario(String nome) {
	    if(nome == null) {
	        return false;
	    }

	    for(Usuario usuario : listaUsuarios) {
	        if(usuario.isConta() && nome.trim().equalsIgnoreCase(usuario.getNomeUsuario())) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public Usuario() {
		conta = false;
		nomeUsuario = null;
		senha = null;
		logado = false;
	}
	
	public boolean isConta() {
		return conta;
	}
	
	public void setConta(boolean conta) {
		this.conta = conta;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isLogado() {
		return logado;
	}
	
	public void setLogado(boolean logado) {
		this.logado = logado;
	}
}