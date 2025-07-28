package br.com.games.VirtualGames.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Cliente {
    private Long id;
    private String nome;
    private String cpf;


}
