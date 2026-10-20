package main;

import java.util.List;
import java.util.Scanner;

public class MenuPlaylistUI {
	    private final Scanner sc;
	    private final GerenciadorPlaylist gerenciador;

	    public MenuPlaylistUI(Scanner sc, GerenciadorPlaylist gerenciador) {
	        this.sc = sc;
	        this.gerenciador = gerenciador;
	    }

	    public void exibirMenu() {
	        int opcao;
	        limparConsole();
	        do {
	        	
	        	System.out.println("\n=== Gerenciamento de Playlists ===");
	            System.out.println("1 - Criar playlist");
	            System.out.println("2 - Excluir playlist");
	            System.out.println("3 - Ver todas as playlists");
	            System.out.println("4 - Adicionar música à playlist");
	            System.out.println("5 - Remover música da playlist");
	            System.out.println("6 - Ver músicas de uma playlist");
	            System.out.println("7 - Mostrar Músicas Disponíveis");
	            System.out.println("8 - Reproduzir playlist");
	            System.out.println("0 - Voltar ao menu anterior");
	            
	            
	            opcao = sc.nextInt();
	            
	            switch (opcao) {
	            case 1:
	                criarPlaylist();
	                break;
	                
	            case 2:
	                excluirPlaylist();
	                break;
	                
	            case 3:
	                gerenciador.mostrarPlaylists();
	                break;
	                
	            case 4:
	                adicionarMusicaPlaylist();
	                break;
	                
	            case 5:
	                removerMusicaPlaylist();
	                break;
	                
	            case 6:
	                verMusicasPlaylist();
	                break;

	            case 7:
	                mostrarMusicasDisponiveis();
	                break;
	            
	            case 8:
	            	reproduzirPlaylist();
	            	break;
	                
	            case 0:
	                System.out.println("Retornando ao Menu principal...");
	                break;
	                
	            default:
	                System.out.println("Opção inválida!");
	                break;
	                
	            }
	            
	        } while (opcao != 0);
	    }
	   
	    
//Métodddos auxliares

	 	private void criarPlaylist() {
	 	    System.out.println("Digite o nome da sua Playlist: ");
	 	    sc.nextLine(); //buffer
	 	    String nome = sc.nextLine();
	 	    gerenciador.criarPlaylist(nome);
	 	}


	 private void excluirPlaylist() {
	     Playlist playlist = selecionarPlaylist("excluir");
	     if (playlist == null) return;

	     System.out.println("Confirma a exclusão da playlist \"" + playlist.getNome() + "\"? (S/N): ");
	     String confirmacao = sc.nextLine().trim();
	     
	     if (confirmacao.equalsIgnoreCase("S")) {
	         int indice = gerenciador.getPlaylists().indexOf(playlist);
	         gerenciador.excluirPlaylist(indice);
	     } else {
	         System.out.println("Exclusão cancelada.");
	     }
	 }


	 private void verMusicasPlaylist() {
	     Playlist playlist = selecionarPlaylist("visualizar as músicas");
	     if (playlist != null) {
	         System.out.println("\n=== Playlist: " + playlist.getNome() + " ===");
	         playlist.listarDetalhado();
	     }
	 }

	 private void adicionarMusicaPlaylist() {
	     Playlist playlist = selecionarPlaylist("adicionar música");
	     if (playlist == null) return;

	     mostrarMusicasDisponiveis();
	     
	     System.out.println("\nDeseja buscar a música por:");
	     System.out.println("1 - ID / Índice");
	     System.out.println("2 - Nome");
	     System.out.print("Escolha: ");
	     int tipoBusca = sc.nextInt();
	     sc.nextLine();

	     Musica musicaSelecionada = null;

	     if (tipoBusca == 1) {
	         System.out.print("Digite o ID da música: ");
	         int id = sc.nextInt();
	         sc.nextLine();

	         // Lucas, preciso de um método na classe Musica para buscar por ID.
	         // Exemplo: Musica.buscarMusicaPorId(id);
	         
	         
	         musicaSelecionada = buscarMusicaPorId(id);

	     } else if (tipoBusca == 2) {
	         System.out.print("Digite o nome da música: ");
	         String nomeMusica = sc.nextLine();

	         // Lucas, preciso que você crie o método na classe Musica que recebe o nome da música e retorna uma Musica.
	         // Exemplo: Musica.buscarMusicaPorNome(nomeMusica);
	         
	         
	         musicaSelecionada = buscarMusicaPorNome(nomeMusica);
	     } else {
	         System.out.println("Opção de busca inválida!");
	         return;
	     }

	     if (musicaSelecionada == null) {
	         System.out.println("Música não encontrada!");
	         return;
	     }

	     int indicePlaylist = gerenciador.getPlaylists().indexOf(playlist);
	     gerenciador.adicionarMusica(indicePlaylist, musicaSelecionada);
	 }


	 private void removerMusicaPlaylist() {
	     Playlist playlist = selecionarPlaylist("remover música");
	     if (playlist == null) return;

	     if (playlist.quantidade() == 0) {
	         System.out.println("Essa playlist está vazia.");
	         return;
	     }

	     playlist.listarDetalhado();
	     
	     System.out.println("\nComo deseja remover a música?");
	     System.out.println("1 - Por Índice (número da lista)");
	     System.out.println("2 - Por Nome da música");
	     System.out.print("Escolha: ");
	     int escolha = sc.nextInt();
	     sc.nextLine();

	     if (escolha == 1) {
	         System.out.print("Digite o número (índice) da música: ");
	         int indice = sc.nextInt();
	         sc.nextLine();
	         
	         if (playlist.removerMusicaPorIndice(indice - 1)) {
	             System.out.println("Música removida com sucesso!");
	         } else {
	             System.out.println("Índice de música inválido.");
	         }
	     } else if (escolha == 2) {
	         System.out.print("Digite o nome da música: ");
	         String nomeMusica = sc.nextLine();
	         
	         playlist.removerMusica(nomeMusica);
	     } else {
	         System.out.println("Opção inválida!");
	     }
	 }

	 private Playlist selecionarPlaylist(String acao) {
	     if (gerenciador.quantidade() == 0) {
	         System.out.println("Você ainda não possui nenhuma playlist.");
	         return null;
	     }

	     gerenciador.mostrarPlaylists();
	     
	     System.out.println("\nComo deseja selecionar a playlist para " + acao + "?");
	     System.out.println("1 - Por Número/Índice");
	     System.out.println("2 - Por Nome");
	     System.out.print("Escolha: ");
	     int opcaoSelecao = sc.nextInt();
	     sc.nextLine();

	     Playlist playlist = null;

	     if (opcaoSelecao == 1) {
	         System.out.print("Digite o número da playlist (0 para cancelar): ");
	         int num = sc.nextInt();
	         sc.nextLine();
	         if (num == 0) return null;
	         
	         playlist = gerenciador.buscarPlaylist(num - 1);
	     } else if (opcaoSelecao == 2) {
	         System.out.print("Digite o nome da playlist: ");
	         String nome = sc.nextLine();
	         
	         playlist = gerenciador.buscarPlaylist(nome);
	     } else {
	         System.out.println("Opção inválida!");
	         return null;
	     }

	     if (playlist == null) {
	         System.out.println("Playlist não encontrada!");
	     }
	     
	     return playlist;
	 }

	 private void mostrarMusicasDisponiveis() {
	     System.out.println("\n=== Músicas disponíveis ===");
	     List<Musica> musicas = Musica.musicas;
	     if (musicas.isEmpty()) {
	         System.out.println("Nenhuma música cadastrada.");
	         return;
	     }

	     for (Musica musica : musicas) {
	         System.out.printf("%d - %s | %s | %s%n",
	                 musica.getId(), musica.getNome(), musica.getArtista(), musica.getAlbum());
	     }
	 }

	 // Métodos auxiliares temporários de busca no catálogo de músicas até o Lucas Implemetar
	 private Musica buscarMusicaPorId(int id) {
	     for (Musica m : Musica.musicas) {
	         if (m.getId() == id) return m;
	     }
	     return null;
	 }
	 
	 private Musica buscarMusicaPorNome(String nome) {
		 for (Musica m : Musica.musicas) {
			 if (m.getNome().equalsIgnoreCase(nome.trim())) return m;
		 }
		 return null;
	 }
	 
	 
	 
	 private void reproduzirPlaylist() {
		    Playlist playlist = selecionarPlaylist("reproduzir");
		    if (playlist == null) return;

		    if (playlist.quantidade() == 0) {
		        System.out.println("Esta playlist não possui músicas para reproduzir.");
		        return;
		    }

		    
		    playlist.reproduzir();

		    int opcaoPlayer;
		    do {
		        System.out.println("\n--- Controls do Player ---");
		        System.out.println("1 - Próxima música (Next)");
		        if (playlist.isTocando()) {
		            System.out.println("2 - Pausar");
		        } else {
		            System.out.println("2 - Continuar/Retomar");
		        }
		        System.out.println("0 - Encerrar reprodução e sair do Player");
		        
		        System.out.print("Escolha: ");
		        opcaoPlayer = sc.nextInt();
		        sc.nextLine();

		        switch (opcaoPlayer) {
		            case 1 -> playlist.nextMusic();
		            case 2 -> {
		                if (playlist.isTocando()) {
		                    playlist.pausar();
		                } else {
		                    playlist.reproduzir();
		                }
		            }
		            case 0 -> playlist.encerrarReproducao();
		            default -> System.out.println("Opção inválida!");
		        }
		    } while (opcaoPlayer != 0);
		}

	 
	 public static void limparConsole() {
		 for (int i = 0; i < 50; i++) {
			    System.out.println();
		}
	}
}
