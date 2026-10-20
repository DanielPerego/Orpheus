package main;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPlaylist {

    private final ArrayList<Playlist> playlists = new ArrayList<>();

    public Playlist criarPlaylist(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome de playlist inválido!");
            return null;
        }

        String nomeNormalizado = nome.trim();
        if (buscarPlaylist(nomeNormalizado) != null) {
            System.out.println("Já existe uma playlist com esse nome!");
            return null;
        }

        Playlist novaPlaylist = new Playlist(nomeNormalizado);
        playlists.add(novaPlaylist);
        System.out.println("Playlist criada com sucesso!");
        return novaPlaylist;
    }

    public List<Playlist> getPlaylists() {
        return new ArrayList<>(playlists);
    }

    public Playlist buscarPlaylist(int indice) {
        return indice >= 0 && indice < playlists.size() ? playlists.get(indice) : null;
    }

    public Playlist buscarPlaylist(String nome) {
        if (nome == null) return null;
        for (Playlist playlist : playlists) {
            if (playlist.getNome().equalsIgnoreCase(nome.trim())) return playlist;
        }
        return null;
    }

    public boolean adicionarMusica(int indice, Musica musica) {
        Playlist playlist = buscarPlaylist(indice);
        if (playlist == null || musica == null) {
            System.out.println("Não foi possível adicionar a música.");
            return false;
        }
        if (playlist.possuiMusica(musica)) {
            System.out.println("Essa música já está na playlist.");
            return false;
        }
        playlist.adicionarMusica(musica);
        return true;
    }

    public boolean removerMusicaDaPlaylist(int indicePlaylist, String nomeMusica) {
        Playlist playlist = buscarPlaylist(indicePlaylist);
        if (playlist == null) {
            System.out.println("Playlist não encontrada!");
            return false;
        }
        Musica musica = playlist.buscarMusicaPorNome(nomeMusica);
        if (musica == null) {
            System.out.println("Música não encontrada na playlist.");
            return false;
        }
        playlist.removerMusica(nomeMusica);
        return true;
    }

    public boolean excluirPlaylist(int indice) {
        if (indice < 0 || indice >= playlists.size()) {
            System.out.println("Playlist não encontrada!");
            return false;
        }
        playlists.remove(indice);
        System.out.println("Playlist excluída com sucesso!");
        return true;
    }

    public void mostrarPlaylists() {
        System.out.println("\n=== Minhas playlists ===");
        if (playlists.isEmpty()) {
            System.out.println("Você ainda não possui playlists.");
            return;
        }
        for (int i = 0; i < playlists.size(); i++) {
            Playlist playlist = playlists.get(i);
            System.out.printf("%d - %s (%d música(s))%n",
                    i + 1, playlist.getNome(), playlist.quantidade());
        }
    }

    public void mostrarMusicasPlaylist() {
        mostrarPlaylists();
    }

    public int quantidade() {
        return playlists.size();
    }
}