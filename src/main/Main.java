package main;

import java.util.Scanner;

public class Main {

	Scanner sc = new Scanner(System.in);
	Usuario user1 = new Usuario();
	
	public static void main(String[] args) {
		
		Main sistema = new Main();
		
		System.out.println("Bem-Vindo ao sistema de músicas Orpheus!");
		
		sistema.cadastrar();
		sistema.logar();
		sistema.menuPrincipal();
		
		sistema.sc.close();
	}

	public void cadastrar() {
		System.out.println("Crie sua conta!");
		System.out.println();
			
		System.out.println("Digite o nome do usuário:");
		String nomeCadastro = sc.next();
		System.out.println();
			
		System.out.println("Digite a senha do usuário:");
		String senhaCadastro = sc.next();
		System.out.println();
			
		user1.createConta(nomeCadastro, senhaCadastro);
		System.out.println("Usuário cadastrado com sucesso!");
			
		System.out.println("Faça login com seu usuário!");
		System.out.println();
	}
	
	public void logar() {
		String nomeLogin, senhaLogin;
		boolean login;
		
		do {		
			System.out.println("Digite o nome do usuário:");
			nomeLogin = sc.next();
			System.out.println();
				
			System.out.println("Digite a senha do usuário:");
			senhaLogin = sc.next();
			System.out.println();
				
			login = user1.loginConta(nomeLogin, senhaLogin);
			
			if(!login) {
				System.out.println("Nome ou Senha incorretos! \nTente novamente!");
				System.out.println();
				
			}else {
				System.out.println("Logado com sucesso!");
				System.out.println();
			}
			
			}while(!login);
	}
	
	public void menuPrincipal() {
		int opcoesMenu;
		
		do {
			System.out.println("\nEscolha sua opção de interação:");
			System.out.println("1 - Opções de usuário");
			System.out.println("2 - Opções de música");
			System.out.println("0 - Encerrar programa");
			opcoesMenu = sc.nextInt();
			sc.nextLine();
			
			switch(opcoesMenu) {
				case 1:
					menuUsuario();
					break;
					
				case 2:
					
					break;
					
				case 0:
					System.out.println("Encerrando programa...");
					return;
					
				default:
					System.out.println("Opção inválida!");
			}
			
		}while(opcoesMenu != 0 && user1.isConta());
	}
	
	public void menuUsuario() {
		int opcoesMenuUsuario;
		char opcoesExclude;
		
		System.out.println("\nQual opção de usuário você deseja?");
		System.out.println("1 - Mostrar Status de Usuário");
		System.out.println("2 - Atualizar Informações de Usuário");
		System.out.println("3 - Excluir conta");
		System.out.println("0 - Retornar ao menu principal");
		opcoesMenuUsuario = sc.nextInt();
		sc.nextLine();
		
		switch(opcoesMenuUsuario) {
			case 1:
				user1.showStatusUsuario();
				break;
				
			case 2:
				System.out.println("\nDigite o novo nome de usuário:");
				String nomeUpdate = sc.next();
				System.out.println();
				
				System.out.println("Digite a nova senha de usuário:");
				String senhaUpdate = sc.next();
				
				user1.updateInformacoesConta(nomeUpdate, senhaUpdate);
				System.out.println("\nAlterações feitas com sucesso!");
				System.out.println();
				break;
				
			case 3:
				System.out.println("Você tem certeza que deseja excluir sua conta?");
				System.out.println("S - Sim");
				System.out.println("N - Não");
				opcoesExclude = sc.next().toLowerCase().charAt(0);
				
				if(opcoesExclude == 's') {
						System.out.println("\nDigite sua senha para excluir sua conta");
						String senhaExclude = sc.next();
						System.out.println();
					
					while(!senhaExclude.equals(user1.getSenha())) {
						System.out.println("Opção inválida! \nTente novamente\n");
						senhaExclude = sc.next();
					}
					
					user1.excludeConta();
					System.out.println("Usuário excluído com sucesso!");
					cadastrar();
					
				}else if(opcoesExclude == 'n') {
					break;
					
				}else {
					System.out.println("Opção inválida!");
					System.out.println();
					break;
					
				}
				break;
				
			case 0:
				System.out.println("\nRetornando ao menu principal!");
				System.out.println();
				return;
				
			default:
				System.out.println("\nOpção inválida!");
				System.out.println();
				return;
				
		}
	}
}
