package br.com.nathan.ecommerce_tech_java.controllers;

import br.com.nathan.ecommerce_tech_java.dtos.ProdutoRegistroDTO;
import br.com.nathan.ecommerce_tech_java.models.Produto;
import br.com.nathan.ecommerce_tech_java.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Produto> registrar(@RequestBody @Valid ProdutoRegistroDTO dto) {
        Produto produtoCriado = service.cadastrarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {

        return ResponseEntity.ok(service.listarTodos());
    }

}
