package main;

import java.util.Scanner;

public class Usuario {
	protected boolean conta;
	private String nomeUsuario;
	protected String senha;
	
	private Scanner sc = new Scanner(System.in);
	
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
	
	public void createConta() {
		System.out.println("Digite o nome do usuário:");
		setNomeUsuario(sc.nextLine());
		
		System.out.println();
		
		System.out.println("Digite sua senha:");
		setSenha(sc.next());
		
		setConta(true);
		System.out.println();
		System.out.println("Conta criada com sucesso!");
	}
	
	public void loginConta() {
		System.out.println();
		System.out.println("Digite o nome de cadastro do usuário:");
		String nomeCadastro = sc.next();
		
		while(!nomeCadastro.equals(getNomeUsuario())){
			System.out.println();
			System.out.println("Nome de usuário inválido! \nTente novamente");
			nomeCadastro = sc.next();
		}
		
		System.out.println();
		System.out.println("Digite a senha do usuário:");
		String senhaCadastro = sc.next();
		
		while(!senhaCadastro.equals(getSenha())) {
			System.out.println();
			System.out.println("Senha inválida! \nTente novamente");
			senhaCadastro = sc.next();
		}
	}
	
	public void excludeConta() {
		if(!isConta()) {
			System.out.println();
			System.out.println("Você não possui uma conta!");
			return;
		}else {
			System.out.println();
			System.out.println("Você deseja excluir sua conta? \nS - Sim \nN - Não");
			char option = sc.next().toUpperCase().charAt(0);
			
			if(option == 'S') {
				System.out.println();
				System.out.println("Digite sua senha para confirmar a exclusão:");
				String exclude = sc.next();
				
				while(!exclude.equals(getSenha())) {
					System.out.println();
					System.out.println("Senha inválida!");
					System.out.println("Tente novamente ou digite 0 para cancelar a operação");
					exclude = sc.next();
					
					if(exclude.equals("0")) {
						return;
					}
				}
				System.out.println();
				System.out.println("Conta excluída com sucesso!");
				
				setConta(false);
				setNomeUsuario(null);
				setSenha(null);
					
			}else if(option == 'N') {
				return;
				
			}else {
				System.out.println();
				System.out.println("Opção inválida!");
				return;
			}
		}
	}
	
	public void updateInformacoesConta() {
		System.out.println();
		System.out.println("Que informações você deseja alterar? \nNome - Alterar nome \nSenha - Alterar senha");
		String alterar = sc.next();
		
		if(alterar.equalsIgnoreCase("nome")) {
			System.out.println();
			System.out.println("Digite o novo nome de usuário:");
			setNomeUsuario(sc.next());
			
		}else if(alterar.equalsIgnoreCase("senha")) {
			System.out.println();
			System.out.println("Digite a nova senha de usuário:");
			setSenha(sc.next());
			
		}else {
			System.out.println();
			System.out.println("Opção inválida!");
			return;
		}
	}
	
	public void showStatusUsuario() {
		System.out.println();
		System.out.println("Nome do Usuário: "+getNomeUsuario());
		System.out.println(isConta() ? "Status da Conta: Ativa" : "Status da Conta: Inativa");
	}
}