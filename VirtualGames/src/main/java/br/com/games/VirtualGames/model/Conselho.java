package br.com.games.VirtualGames.model;

import lombok.Getter;

@Getter
public class Conselho {
    private int id;
    private String conselho;

    public Conselho() {
    }

    public Conselho(int id, String conselho) {
        this.id = id;
        this.conselho = conselho;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConselho(String conselho) {
        this.conselho = conselho;
    }



    @Override
    public String toString() {
        return "Conselho{" +
                "id=" + id +
                ", conselho='" + conselho + '\'' +
                '}';
    }
}
