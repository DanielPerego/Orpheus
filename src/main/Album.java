package main;

import java.util.ArrayList;

public class Album extends Musica{
	public Album(int id, String nome, String artista, String album, int duracao, String genero) {
		super(id, nome, artista, album, duracao, genero);
		
	}

	private String nome;
	private String artista;
	private int ano;
	private String genero;
	private ArrayList<Musica> musicas = new ArrayList<>();
	private boolean curtir = false;
	
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
	public void curtirAlb(){
		this.curtir = true;
	}
	public void listar() {
        if (musicas.isEmpty()) {
            System.out.println("Playlist vazia!");
            return;
        }

        for (int i = 0; i < musicas.size(); i++) {
            System.out.println(i + " - " + musicas.get(i).getNome());
        }
	}
	 public void verAlbum() {
	        listar();
	    }

}