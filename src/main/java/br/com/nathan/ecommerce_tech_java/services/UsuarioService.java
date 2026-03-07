package br.com.nathan.ecommerce_tech_java.services;

import br.com.nathan.ecommerce_tech_java.dtos.UsuarioRegistroDTO;
import br.com.nathan.ecommerce_tech_java.models.Endereco;
import br.com.nathan.ecommerce_tech_java.models.Usuario;
import br.com.nathan.ecommerce_tech_java.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    // O modificador final é obrigatório para o @RequiredArgsConstructor funcionar
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
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
        novoUsuario.setSenha(dto.senha());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.logradouro());
        endereco.setComplemento(dto.complemento());
        endereco.setNumero(dto.numero());
        endereco.setCep(dto.cep());
        endereco.setBairro(dto.bairro());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());

        novoUsuario.setEndereco(endereco);

        return repository.save(novoUsuario);
    }
}