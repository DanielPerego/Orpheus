package main;

public class Usuario {
	protected boolean conta;
	private String nomeUsuario;
	protected String senha;
	
	public Usuario() {
		conta = false;
		nomeUsuario = null;
		senha = null;
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
	
	public void createConta(String nomeUsuario, String senhaUsuario) {
		setNomeUsuario(nomeUsuario);
		setSenha(senhaUsuario);
		setConta(true);
	}
	
	public boolean loginConta(String nomeLogin, String senhaLogin) {
		if(nomeLogin.equals(getNomeUsuario()) && senhaLogin.equals(getSenha())) {
			return true;
		}else {
			return false;
		}
	}
	
	public void excludeConta() {
		setSenha(null);
		setNomeUsuario(null);
		setConta(false);
	}
	
	public void updateInformacoesConta(String nomeUpdate, String senhaUpdate) {
		setNomeUsuario(nomeUpdate);
		setSenha(senhaUpdate);
	}
	
	public void showStatusUsuario() {
		System.out.println("Nome do Usuário: "+getNomeUsuario());
		System.out.println(isConta() ? "Status da Conta: Ativa" : "Status da Conta: Inativa");
	}
}