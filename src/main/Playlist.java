package main;

import java.util.ArrayList;

//Mateus

public class Playlist {
	private String nome;
	
	
	ArrayList<Musica> musicas = new ArrayList<>();
	
	public void adicionarMusica(Musica musica) {
		musicas.add(musica);
	}
	
	private void removerMusica(int id) {
		musicas.remove(id);
	}
	
	private void verPLaylist() {
		for(Musica musica : this.musicas) {
//			System.out.println(musica.getNome());
		}		
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
