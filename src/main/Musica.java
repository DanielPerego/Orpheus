package main;

import java.util.ArrayList;
import java.util.List;

public class Musica {
	
	private int id = 0;
	private String nome;
	private String artista;
	private String album;
	private int duracao = 0;
	private String genero;	
	
	public Musica(int id, String nome, String artista, String album, int duracao, String genero) {
		this.id = id;
		this.nome = nome;
		this.artista = artista;
		this.album = album;
		this.duracao = duracao;
		this.genero = genero;
	}
	
	public static void ouvirMusica (String nome) {
		for (Musica m : musicas) {
			if (m.getNome().equalsIgnoreCase(nome)) {
	            System.out.println("\nOuvindo - " + m.getNome() + " (" + m.getArtista() + ") - " + m.getAlbum());
	            return;
	        }	
		}
		System.out.println("Música não encontrada");
	}
	
	public static void listarMusicas () {
		for (Musica m : musicas) {
			System.out.println("\n" + m.getId() + " - " + m.getNome() + " (" + m.getArtista() + ") - " +m.getAlbum() + " -  " + (m.getDuracao() / 60)+ " - " +m.getGenero() );
		}
	}
	
	public static Musica buscarPorId (int id) {
	     for (Musica m : musicas) {
	         if (m.getId() == id) 
	        	 return m;
	     }
	     return null;
	 }
	
	public static Musica buscarPorNome (String nome) {
		 for (Musica m : musicas) {
			 if (m.getNome().equalsIgnoreCase(nome.trim())) 
				 return m;
		 }
		 return null;
	 }
	
	public static final List<Musica> musicas = new ArrayList<>();


    static {
        
        musicas.add(new Musica(1, "My Old Ways", "Tame Impala", "Deadbeat", 298, "Eletrônica"));
        musicas.add(new Musica(2, "No Reply", "Tame Impala", "Deadbeat", 215, "Eletrônica"));
        musicas.add(new Musica(3, "Dracula", "Tame Impala", "Deadbeat", 205, "Eletrônica"));
        musicas.add(new Musica(4, "Loser", "Tame Impala", "Deadbeat", 223, "Eletrônica"));
        musicas.add(new Musica(5, "Oblivion", "Tame Impala", "Deadbeat", 260, "Eletrônica"));       
        musicas.add(new Musica(6, "Not My World", "Tame Impala", "Deadbeat", 254, "Eletrônica"));
        musicas.add(new Musica(7, "Piece of Heaven", "Tame Impala", "Deadbeat", 270, "Eletrônica"));
        musicas.add(new Musica(8, "Obsolete", "Tame Impala", "Deadbeat", 280, "Eletrônica"));        
        musicas.add(new Musica(9, "Ethereal Connection", "Tame Impala", "Deadbeat", 470, "Eletrônica")); 
        musicas.add(new Musica(10, "See You on Monday (You're Lost)", "Tame Impala", "Deadbeat", 300, "Eletrônica")); 
        musicas.add(new Musica(11, "Afterthought", "Tame Impala", "Deadbeat", 280, "Eletrônica"));   
        musicas.add(new Musica(12, "End of Summer", "Tame Impala", "Deadbeat", 430, "Eletrônica"));  

        
        musicas.add(new Musica(13, "Speak to Me", "Pink Floyd", "The Dark Side of the Moon", 67, "Rock"));
        musicas.add(new Musica(14, "Breathe (In the Air)", "Pink Floyd", "The Dark Side of the Moon", 163, "Rock"));
        musicas.add(new Musica(15, "On the Run", "Pink Floyd", "The Dark Side of the Moon", 225, "Rock"));
        musicas.add(new Musica(16, "Time", "Pink Floyd", "The Dark Side of the Moon", 413, "Rock"));
        musicas.add(new Musica(17, "The Great Gig in the Sky", "Pink Floyd", "The Dark Side of the Moon", 276, "Rock"));
        musicas.add(new Musica(18, "Money", "Pink Floyd", "The Dark Side of the Moon", 383, "Rock"));
        musicas.add(new Musica(19, "Us and Them", "Pink Floyd", "The Dark Side of the Moon", 469, "Rock"));
        musicas.add(new Musica(20, "Any Colour You Like", "Pink Floyd", "The Dark Side of the Moon", 206, "Rock"));
        musicas.add(new Musica(21, "Brain Damage", "Pink Floyd", "The Dark Side of the Moon", 226, "Rock"));
        musicas.add(new Musica(22, "Eclipse", "Pink Floyd", "The Dark Side of the Moon", 123, "Rock"));

        
        musicas.add(new Musica(23, "Wanna Be Startin' Somethin'", "Michael Jackson", "Thriller", 363, "Pop"));
        musicas.add(new Musica(24, "Baby Be Mine", "Michael Jackson", "Thriller", 260, "Pop"));
        musicas.add(new Musica(25, "The Girl Is Mine", "Michael Jackson", "Thriller", 222, "Pop"));
        musicas.add(new Musica(26, "Thriller", "Michael Jackson", "Thriller", 357, "Pop"));
        musicas.add(new Musica(27, "Beat It", "Michael Jackson", "Thriller", 258, "Pop"));
        musicas.add(new Musica(28, "Billie Jean", "Michael Jackson", "Thriller", 294, "Pop"));
        musicas.add(new Musica(29, "Human Nature", "Michael Jackson", "Thriller", 245, "Pop"));
        musicas.add(new Musica(30, "P.Y.T. (Pretty Young Thing)", "Michael Jackson", "Thriller", 239, "Pop"));
        musicas.add(new Musica(31, "The Lady in My Life", "Michael Jackson", "Thriller", 297, "Pop"));
    }
	
	
	 
	
	
	 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
}


