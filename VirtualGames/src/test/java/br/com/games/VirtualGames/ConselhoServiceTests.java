package br.com.games.VirtualGames;
import br.com.games.VirtualGames.model.Conselho;
import br.com.games.VirtualGames.Service.ConselhoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ConselhoServiceTests {

    @Autowired
    private ConselhoService conselhoService;

    @Test
    @DisplayName("Deve retornar um conselho aleatório")
    void deveRetornarConselhoAleatorio() {
        Conselho conselho = conselhoService.obterConselhoAleatorio();

        // Verifica se o conselho retornado não é nulo
        assertNotNull(conselho);

        // Adaptação: Verifica se o conselho tem uma mensagem (ou outra propriedade desejada)
        assertNotNull(conselho.getConselho());
    }

    @Test
    @DisplayName("Deve retornar uma lista de conselhos")
    void deveRetornarListaDeConselhos() {
        List<Conselho> conselhos = conselhoService.obterListaDeConselhos(5);

        // Verifica se a lista não está vazia
        assertFalse(conselhos.isEmpty());

        // Verifica se o tamanho da lista é o esperado (5 conselhos)
        assertEquals(5, conselhos.size());

        // Adaptação: Verifica se cada conselho tem uma mensagem (ou outra propriedade desejada)
        conselhos.forEach(conselho -> assertNotNull(conselho.getConselho()));
    }
}
