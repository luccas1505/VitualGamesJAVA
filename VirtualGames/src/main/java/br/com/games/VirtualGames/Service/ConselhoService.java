package br.com.games.VirtualGames.Service;

import br.com.games.VirtualGames.exception.ResourceNotFoundException;
import br.com.games.VirtualGames.model.Conselho;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ConselhoService {

    private final String API_URL = "https://api.adviceslip.com/advice";
    private final List<Conselho> conselhos = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public Conselho obterConselhoAleatorio() {
        RestTemplate restTemplate = new RestTemplate();
        Conselho conselho = restTemplate.getForObject(API_URL, Conselho.class);

        if (conselho == null) {
            throw new ResourceNotFoundException("Conselho não encontrado");
        }

        return conselho;
    }

    public List<Conselho> obterListaDeConselhos(int quantidade) {
        RestTemplate restTemplate = new RestTemplate();
        Conselho[] conselhosArray = restTemplate.getForObject(API_URL + "/" + quantidade, Conselho[].class);

        if (conselhosArray == null || conselhosArray.length == 0) {
            throw new ResourceNotFoundException("Nenhum conselho encontrado");
        }

        return Arrays.asList(conselhosArray);
    }

    public void criarNovoConselho(Conselho conselho) {
        int novoId = idGenerator.getAndIncrement();
        conselho.setId(novoId);
        conselhos.add(conselho);
    }

    public void excluirConselho(int id) {
        Conselho conselhoParaExcluir = conselhos.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Conselho não encontrado"));

        conselhos.remove(conselhoParaExcluir);
    }

    public void atualizarConselho(int id, Conselho conselho) {
        Conselho conselhoExistente = conselhos.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Conselho não encontrado"));

        conselhoExistente.setConselho(conselho.getConselho());
    }
}
