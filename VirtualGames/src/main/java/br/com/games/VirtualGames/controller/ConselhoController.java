package br.com.games.VirtualGames.controller;

import br.com.games.VirtualGames.model.Conselho;
import br.com.games.VirtualGames.Service.ConselhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conselho")
public class ConselhoController {

    @Autowired
    private ConselhoService conselhoService;

    @GetMapping("/aleatorio")
    public ResponseEntity<Conselho> obterConselhoAleatorio() {
        Conselho conselho = conselhoService.obterConselhoAleatorio();
        return ResponseEntity.ok(conselho);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Conselho>> obterListaDeConselhos(@RequestParam int quantidade) {
        List<Conselho> conselhos = conselhoService.obterListaDeConselhos(quantidade);
        return ResponseEntity.ok(conselhos);
    }
}
