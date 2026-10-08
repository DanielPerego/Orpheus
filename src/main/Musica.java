package main;

public class Musica {
	
	private int id = 0;
	private String nome;
	private String artista;
	private String album;
	private int duracao = 0;
	private String genero;
	boolean curtir = false;
	
	
	
	public Musica(int id, String nome, String artista, String album, int duracao, String genero) {
		this.id = id;
		this.nome = nome;
		this.artista = artista;
		this.album = album;
		this.duracao = duracao;
		this.genero = genero;
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


    static Musica m1 = new Musica(1, "My Old Ways", "Tame Impala", "Deadbeat", 298, "Eletrônica");
    Musica m2 = new Musica(2, "No Reply", "Tame Impala", "Deadbeat", 215, "Eletrônica");
    Musica m3 = new Musica(3, "Dracula", "Tame Impala", "Deadbeat", 205, "Eletrônica");
    Musica m4 = new Musica(4, "Loser", "Tame Impala", "Deadbeat", 223, "Eletrônica");
    Musica m5 = new Musica(5, "Oblivion", "Tame Impala", "Deadbeat", 260, "Eletrônica");       
    Musica m6 = new Musica(6, "Not My World", "Tame Impala", "Deadbeat", 254, "Eletrônica");
    Musica m7 = new Musica(7, "Piece of Heaven", "Tame Impala", "Deadbeat", 270, "Eletrônica"); 
    Musica m8 = new Musica(8, "Obsolete", "Tame Impala", "Deadbeat", 280, "Eletrônica");        
    Musica m9 = new Musica(9, "Ethereal Connection", "Tame Impala", "Deadbeat", 470, "Eletrônica");
    Musica m10 = new Musica(10, "See You on Monday (You're Lost)", "Tame Impala", "Deadbeat", 300, "Eletrônica");
    Musica m11 = new Musica(11, "Afterthought", "Tame Impala", "Deadbeat", 280, "Eletrônica");  
    Musica m12 = new Musica(12, "End of Summer", "Tame Impala", "Deadbeat", 430, "Eletrônica");  


    Musica m13 = new Musica(13, "Speak to Me", "Pink Floyd", "The Dark Side of the Moon", 67, "Rock");
    Musica m14 = new Musica(14, "Breathe (In the Air)", "Pink Floyd", "The Dark Side of the Moon", 163, "Rock");
    Musica m15 = new Musica(15, "On the Run", "Pink Floyd", "The Dark Side of the Moon", 225, "Rock");
    Musica m16 = new Musica(16, "Time", "Pink Floyd", "The Dark Side of the Moon", 413, "Rock");
    Musica m17 = new Musica(17, "The Great Gig in the Sky", "Pink Floyd", "The Dark Side of the Moon", 276, "Rock");
    Musica m18 = new Musica(18, "Money", "Pink Floyd", "The Dark Side of the Moon", 383, "Rock");
    Musica m19 = new Musica(19, "Us and Them", "Pink Floyd", "The Dark Side of the Moon", 469, "Rock");
    Musica m20 = new Musica(20, "Any Colour You Like", "Pink Floyd", "The Dark Side of the Moon", 206, "Rock");
    Musica m21 = new Musica(21, "Brain Damage", "Pink Floyd", "The Dark Side of the Moon", 226, "Rock");
    Musica m22 = new Musica(22, "Eclipse", "Pink Floyd", "The Dark Side of the Moon", 123, "Rock");

 
    Musica m23 = new Musica(23, "Wanna Be Startin' Somethin'", "Michael Jackson", "Thriller", 363, "Pop");
    Musica m24 = new Musica(24, "Baby Be Mine", "Michael Jackson", "Thriller", 260, "Pop");
    Musica m25 = new Musica(25, "The Girl Is Mine", "Michael Jackson", "Thriller", 222, "Pop");
    Musica m26 = new Musica(26, "Thriller", "Michael Jackson", "Thriller", 357, "Pop");
    Musica m27 = new Musica(27, "Beat It", "Michael Jackson", "Thriller", 258, "Pop");
    Musica m28 = new Musica(28, "Billie Jean", "Michael Jackson", "Thriller", 294, "Pop");
    Musica m29 = new Musica(29, "Human Nature", "Michael Jackson", "Thriller", 245, "Pop");
    Musica m30 = new Musica(30, "P.Y.T. (Pretty Young Thing)", "Michael Jackson", "Thriller", 239, "Pop");
    Musica m31 = new Musica(31, "The Lady in My Life", "Michael Jackson", "Thriller", 297, "Pop");	
}


