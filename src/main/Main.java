package main;

import java.util.Scanner;

public class Main {

	Scanner sc = new Scanner(System.in);
	Usuario usuarioLogado = null;
	
	public static void main(String[] args) {
		
		Main sistema = new Main();
		
		System.out.println("Bem-Vindo ao sistema de músicas Orpheus!");
		
		sistema.menuPrincipal();
		
		sistema.sc.close();
	}

	public void menuPrincipal() {
		while(true){
			if(usuarioLogado == null) {
				System.out.println("\nMenu Principal");
				System.out.println("1 - Criar conta");
				System.out.println("2 - Fazer login");
				System.out.println("0 - Encerrar programa");
				
				int opcoesMenu = sc.nextInt();
				sc.nextLine();
				
				switch(opcoesMenu) {
				case 1:
					cadastrar();
					break;
					
				case 2:
					logar();
					break;
					
				case 0:
					System.out.println("Encerrando programa...");
					return;
					
				default:
					System.out.println("Opção inválida!");
				}
			}else {
				System.out.println("Menu Principal");
				System.out.println("1 - Menu de Usuário");
				System.out.println("2 - Menu de Música");
				System.out.println("0 - Encerrar programa");
				
				int opcoesMenu = sc.nextInt();
				sc.nextLine();
				
				switch(opcoesMenu) {
				case 1:
					menuUsuario();
					break;
					
				case 2:
					menuMusica();
					break;
					
				case 0:
					System.out.println("Encerrando programa...");
					return;
					
				default:
					System.out.println("Opção inválida!");
				}
			}
		}
	}
	
	public void menuUsuario() {
		if(usuarioLogado == null) {
			System.out.println("Você precisa fazer login primeiro!");
			return;
		}
		
		System.out.println("\nQual opção de usuário você deseja?");
		System.out.println("1 - Mostrar Status de Usuário");
		System.out.println("2 - Atualizar Informações de Usuário");
		System.out.println("3 - Sair da Conta");
		System.out.println("4 - Excluir conta");
		System.out.println("0 - Retornar ao menu principal");
		int opcoesMenuUsuario = sc.nextInt();
		sc.nextLine();
		
		switch(opcoesMenuUsuario) {
			case 1:
				usuarioLogado.showStatusUsuario();
				break;
				
			case 2:
				atualizarUsuario();
				break;
				
			case 3:
				logoutConta();
				break;
				
			case 4:
				excluirUsuario();
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
	
	public void menuMusica() {
		
		int opcaomusica;
		
		System.out.println("\nQual opção deseja escolher?");
		System.out.println("1 - Ouvir música");
		System.out.println("2 - Curtir música");
		System.out.println("3 - Ouvir albúm");
		System.out.println("4 - Curtir albúm");
		System.out.println("5 - Criar playlist");
		System.out.println("6 - Ver músicas disponiveis");
		System.out.println("0 - Retornar para o Menu pricipal");
		opcaomusica = sc.nextInt();
		sc.nextLine();
		
		switch(opcaomusica) {
		
		case 1:
			;
			break;
		}
	}
	
	public void cadastrar() {
		System.out.println("Crie sua conta!\n");
			
		System.out.println("Digite o nome do usuário:");
		String nomeCadastro = sc.nextLine().trim();
			
		System.out.println("\nDigite a senha do usuário:");
		String senhaCadastro = sc.nextLine();
			
		Usuario novoUsuario = new Usuario();
		
		if(novoUsuario.createConta(nomeCadastro, senhaCadastro)) {
			System.out.println("\nUsuário cadastrado com sucesso!");
		}else {
			System.out.println("Cadastro inválido ou nome de usuário já utilizado!");
		}
	}
	
	public void logar() {
		String nomeLogin, senhaLogin;
		
		System.out.println("Faça login com seu usuário!\n");
		
		while (true){		
			System.out.println("Digite o nome do usuário:");
			nomeLogin = sc.nextLine().trim();
				
			System.out.println("\nDigite a senha do usuário:");
			senhaLogin = sc.nextLine();
			System.out.println();
				
			usuarioLogado = Usuario.buscarUsuario(nomeLogin, senhaLogin);
		
			if(usuarioLogado != null) {
				usuarioLogado.setLogado(true);
				System.out.println("Logado com sucesso!");
				System.out.println();
				return;
				}else if(!Usuario.existeUsuario(nomeLogin)) {
					System.out.println("Usuário não encontrado!");
                    System.out.println();
				}else {
					System.out.println("Senha incorreta!");
                    System.out.println();
				}
			
			System.out.println("1 - Tentar novamente \n2 - Retornar ao menu principal");
			int opcaoLogin = sc.nextInt();
			sc.nextLine();
			
			if (opcaoLogin == 2) {
				System.out.println("Retornando ao menu principal...");
				System.out.println();
				return;
			} else if (opcaoLogin != 1) {
				System.out.println("Opção inválida! Retornando ao menu principal...");
				return;
			}
		}
	}
	
	public void atualizarUsuario() {
		System.out.println("\nDigite o novo nome de usuário:");
	    String nomeUpdate = sc.nextLine().trim();

	    System.out.println("Digite a nova senha:");
	    String senhaUpdate = sc.nextLine();

	    if (usuarioLogado.updateInformacoesConta(nomeUpdate, senhaUpdate)) {
	        System.out.println("\nInformações atualizadas com sucesso!");
	        System.out.println();
	    } else {
	        System.out.println("\nNão foi possível atualizar. Verifique os dados ou se o nome já está em uso");
	        System.out.println();
	    }
	}
	
	public void excluirUsuario() {
		System.out.println("\nTem certeza de que deseja excluir sua conta?");
		    System.out.println("S - Sim");
		    System.out.println("N - Não");

		    String confirmacao = sc.nextLine().trim();

		    if (confirmacao.equalsIgnoreCase("S")) {
		        System.out.println("Digite sua senha para confirmar:");
		        String senhaExcluir = sc.nextLine();

		        if (senhaExcluir.equals(usuarioLogado.getSenha())) {
		            if (usuarioLogado.excludeConta()) {
		                usuarioLogado = null;
		                System.out.println("\nConta excluída com sucesso!\n");
		            }
		        } else {
		            System.out.println("\nSenha incorreta. Conta preservada.\n");
		        }

		    } else if (confirmacao.equalsIgnoreCase("N")) {
		        System.out.println("\nExclusão cancelada.\n");

		    } else {
		        System.out.println("\nOpção inválida. Exclusão cancelada.\n");
		    }
	}
	
	public void logoutConta() {
		System.out.println("Saindo da conta...");
		usuarioLogado.setLogado(false);
		usuarioLogado = null;
		System.out.println("Você saiu da conta com sucesso!");
	}
}