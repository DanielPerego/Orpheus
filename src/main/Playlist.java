package main;

import java.util.ArrayList;

public class Playlist {

    private String nome;
    private int musicaAtual = 0;
    private ArrayList<Musica> musicas = new ArrayList<>();

    public Playlist(String nome) {
        this.nome = nome;
    }

    public void adicionarMusica(Musica musica) {
        if (musica != null) {
            musicas.add(musica);
        }
    }
    
    

    public void removerMusica(String nome) {
        for (int i = 0; i < musicas.size(); i++) {
            if (musicas.get(i).getNome().equalsIgnoreCase(nome)) {
                musicas.remove(i);

                if (musicas.isEmpty()) {
                    musicaAtual = 0;
                } else if (i < musicaAtual) {
                    musicaAtual--;
                } else if (musicaAtual >= musicas.size()) {
                    musicaAtual = 0;
                }

                System.out.println("Música removida com sucesso!");
                return;
            }
        }

        System.out.println("Música não encontrada!");
    }

    public Musica buscarMusica(String nome) {
        for (Musica musica : musicas) {
            if (musica.getNome().equalsIgnoreCase(nome)) {
                return musica;
            }
        }

        return null;
    }

    public boolean possuiMusica(Musica m) {
        return musicas.contains(m);
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

    public void verPLaylist() {
        listar();
    }

    public int quantidade() {
        return musicas.size();
    }

    public void limpar() {
        musicas.clear();
        musicaAtual = 0;
    }

    public void reproduzir() {
        if (musicas.isEmpty()) {
            System.out.println("Playlist vazia!");
            return;
        }

        System.out.println("Reproduzindo: "
                + musicas.get(musicaAtual).getNome());
    }

    public void nextMusic() {
        if (musicas.isEmpty()) {
            System.out.println("Playlist vazia!");
            return;
        }

        musicaAtual = (musicaAtual + 1) % musicas.size();
        reproduzir();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retornar uma música pelo índice
    public Musica getMusica(int id) {
        if (id >= 0 && id < musicas.size()) {
            return musicas.get(id);
        }

        return null;
    }
}
