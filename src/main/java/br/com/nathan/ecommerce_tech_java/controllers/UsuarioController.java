package br.com.nathan.ecommerce_tech_java.controllers;

import br.com.nathan.ecommerce_tech_java.dtos.UsuarioRegistroDTO;
import br.com.nathan.ecommerce_tech_java.models.Usuario;
import br.com.nathan.ecommerce_tech_java.services.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario> registrar(@RequestBody @Valid UsuarioRegistroDTO dto) {

        Usuario usuarioCriado = service.cadastrarUsuario(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }
}
