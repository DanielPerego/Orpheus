package main;

import java.util.ArrayList;

public class Album {
	private String nome;
	private String artista;
	private int ano;
	private String genero;
	private ArrayList<Musica> musicas = new ArrayList<>();

	private static ArrayList<Album> albunsDisponiveis = new ArrayList<>();

	static {
		new Album("Deadbeat", "Tame Impala", 2025, "Eletrônica");
		new Album("The Dark Side of the Moon", "Pink Floyd", 1973, "Rock");
		new Album("Thriller", "Michael Jackson", 1982, "Pop");
	}

	public Album(String nome, String artista, int ano, String genero) {
		this.nome = nome;
		this.artista = artista;
		this.ano = ano;
		this.genero = genero;

		for (Musica m : Musica.musicas) {
			if (m.getAlbum().equalsIgnoreCase(nome)) {
				musicas.add(m);
			}
		}
		albunsDisponiveis.add(this);
	}

	public static void listarAlbuns() {
		if (albunsDisponiveis.isEmpty()) {
			System.out.println("Nenhum álbum disponível!");
			return;
		}
		System.out.println("\n=== Álbuns disponíveis ===");
		int i = 1;
		for (Album a : albunsDisponiveis) {
			System.out.println(i++ + " - " + a.nome + " (" + a.artista + ", " + a.ano + ") - " + a.genero);
		}
		System.out.println();
	}

	public void listarMusicas() {
		if (musicas.isEmpty()) {
			System.out.println("Este álbum não possui músicas!");
			return;
		}
		System.out.println("\n=== Músicas de " + nome + " ===");
		int i = 1;
		for (Musica m : musicas) {
			System.out.println(i++ + " - " + m.getNome());
		}
		System.out.println();
	}

	public void ouvir() {
		if (musicas.isEmpty()) {
			System.out.println("Este álbum não possui músicas!");
			return;
		}
		System.out.println("\nOuvindo o álbum " + nome + " - " + artista);
		for (Musica m : musicas) {
			System.out.println("  ♪ " + m.getNome());
		}
		System.out.println();
	}

	public static Album buscarPorNome(String nome) {
		if (nome == null) return null;
		for (Album a : albunsDisponiveis) {
			if (a.nome.equalsIgnoreCase(nome.trim())) {
				return a;
			}
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public ArrayList<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(ArrayList<Musica> musicas) {
		this.musicas = musicas;
	}

	public static ArrayList<Album> getAlbunsdisponiveis() {
		return albunsDisponiveis;
	}
	
	
}