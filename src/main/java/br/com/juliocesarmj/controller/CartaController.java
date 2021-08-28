package br.com.juliocesarmj.controller;

import br.com.juliocesarmj.dto.CartaDTO;
import br.com.juliocesarmj.enums.ClasseEstiloPersonagens;
import br.com.juliocesarmj.enums.TipoPoderesPersonagens;
import br.com.juliocesarmj.service.ICartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/carta")
public class CartaController {

    @Autowired
    private ICartaService cartaService;

    @PostMapping
    public ResponseEntity<Boolean> post(@Valid @RequestBody CartaDTO carta) {
        return ResponseEntity.status(HttpStatus.OK).body(this.cartaService.cadastrar(carta));
    }

    @PutMapping
    public ResponseEntity<Boolean> put(@Valid @RequestBody CartaDTO carta) {
        return ResponseEntity.status(HttpStatus.OK).body(this.cartaService.alterar(carta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.cartaService.excluir(id));
    }

    @GetMapping
    public ResponseEntity<List<CartaDTO>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(this.cartaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.cartaService.listarPorId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<CartaDTO>> getByNome(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(this.cartaService.listarPorNome(nome));
    }

    @GetMapping("/classe/{classe}")
    public ResponseEntity<List<CartaDTO>> getByClasse(@PathVariable String classe) {
        return ResponseEntity.status(HttpStatus.OK).body(this.cartaService.listarPorClasse(ClasseEstiloPersonagens.valueOf(classe)));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<CartaDTO>> getByTipo(@PathVariable String tipo) {
        return ResponseEntity.status(HttpStatus.OK).body(this.cartaService.listarPorTipo(TipoPoderesPersonagens.valueOf(tipo)));
    }
}
