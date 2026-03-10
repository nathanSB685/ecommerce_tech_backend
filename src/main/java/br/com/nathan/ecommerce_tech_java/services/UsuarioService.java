package br.com.nathan.ecommerce_tech_java.services;

import br.com.nathan.ecommerce_tech_java.dtos.UsuarioRegistroDTO;
import br.com.nathan.ecommerce_tech_java.models.Endereco;
import br.com.nathan.ecommerce_tech_java.models.Usuario;
import br.com.nathan.ecommerce_tech_java.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UsuarioService {

    // O modificador final é obrigatório para o @RequiredArgsConstructor funcionar
    private final UsuarioRepository repository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Usuario cadastrarUsuario(UsuarioRegistroDTO dto) {

        if (repository.existsByCpf(dto.cpf())) {
            throw new IllegalArgumentException("Este CPF já está cadastrado no sistema.");
        }
        if (repository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Este e-mail já está em uso.");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.nome());
        novoUsuario.setCpf(dto.cpf());
        novoUsuario.setEmail(dto.email());
        novoUsuario.setCelular(dto.celular());

        novoUsuario.setSenha(passwordEncoder.encode(dto.senha()));

        return repository.save(novoUsuario);
    }
}