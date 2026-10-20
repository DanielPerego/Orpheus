package main;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private String nome;
    private int musicaAtual = 0;
    private boolean tocando = false;
    private final ArrayList<Musica> musicas = new ArrayList<>();

    public Playlist(String nome) {
        this.nome = nome.trim();
    }

    public void adicionarMusica(Musica musica) {
        if (musica == null) {
            System.out.println("Música inválida.");
            return;
        }
        if (possuiMusica(musica)) {
            System.out.println("Essa música já está na playlist.");
            return;
        }
        musicas.add(musica);
        System.out.println("Música adicionada com sucesso!");
    }

    public void removerMusica(String nomeMusica) {
        if (nomeMusica == null) {
            System.out.println("Nome de música inválido.");
            return;
        }
        for (int i = 0; i < musicas.size(); i++) {
            if (musicas.get(i).getNome().equalsIgnoreCase(nomeMusica.trim())) {
                removerMusicaPorIndice(i);
                System.out.println("Música removida com sucesso!");
                return;
            }
        }
        System.out.println("Música não encontrada!");
    }

    public boolean removerMusicaPorIndice(int indice) {
        if (indice < 0 || indice >= musicas.size()) return false;
        musicas.remove(indice);
        if (musicas.isEmpty()) musicaAtual = 0;
        else if (indice < musicaAtual) musicaAtual--;
        else if (musicaAtual >= musicas.size()) musicaAtual = 0;
        return true;
    }

    public Musica buscarMusicaPorNome(String nomeMusica) {
        if (nomeMusica == null) return null;
        for (Musica musica : musicas) {
            if (musica.getNome().equalsIgnoreCase(nomeMusica.trim())) {
                return musica;
            }
        }
        return null;
    }

    public Musica buscarMusica(String nomeMusica) {
        if (nomeMusica == null) return null;
        for (Musica musica : musicas) {
            if (musica.getNome().equalsIgnoreCase(nomeMusica.trim())) return musica;
        }
        return null;
    }

    public boolean possuiMusica(Musica musica) {
        if (musica == null) return false;
        for (Musica existente : musicas) {
            if (existente.getId() == musica.getId()) return true;
        }
        return false;
    }

    public void listar() {
        listarDetalhado();
    }

    public void listarDetalhado() {
        if (musicas.isEmpty()) {
            System.out.println("Playlist vazia!");
            return;
        }
        for (int i = 0; i < musicas.size(); i++) {
            Musica musica = musicas.get(i);
            System.out.printf("%d - %s | %s | %s%n",
                    i + 1, musica.getNome(), musica.getArtista(), formatarDuracao(musica.getDuracao()));
        }
    }

    public void verPLaylist() {
        listarDetalhado();
    }

    public int quantidade() {
        return musicas.size();
    }

    public List<Musica> getMusicas() {
        return new ArrayList<>(musicas);
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
        if (musicaAtual < 0 || musicaAtual >= musicas.size()) {
        	musicaAtual = 0;
        }
        tocando = true;
        Musica atual = musicas.get(musicaAtual);
        System.out.println("Reproduzindo: " + atual.getNome() + " - " + atual.getArtista());
    }
    public void pausar() {
        if (!tocando) {
            System.out.println("A reprodução já está pausada.");
            return;
        }
        tocando = false;
        Musica atual = musicas.get(musicaAtual);
        System.out.println("\n[PAUSADO] " + atual.getNome() + " - " + atual.getArtista());
    }

    public void encerrarReproducao() {
        tocando = false;
        musicaAtual = 0;
        System.out.println("\n[REPRODUÇÃO ENCERRADA]");
    }

    public void nextMusic() {
        if (musicas.isEmpty()) {
            System.out.println("Playlist vazia!");
            return;
        }
        musicaAtual = (musicaAtual + 1) % musicas.size();
        reproduzir();
    }
    
    public boolean isTocando() {
        return tocando;
    }

    public Musica getMusicaAtualObj() {
        if (musicas.isEmpty() || musicaAtual < 0 || musicaAtual >= musicas.size()) return null;
        return musicas.get(musicaAtual);
    }

    private String formatarDuracao(int segundos) {
        return String.format("%d:%02d", Math.max(0, segundos) / 60, Math.max(0, segundos) % 60);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) this.nome = nome.trim();
    }

    public Musica getMusica(int indice) {
        return indice >= 0 && indice < musicas.size() ? musicas.get(indice) : null;
    }
}