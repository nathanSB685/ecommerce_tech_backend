package br.com.nathan.ecommerce_tech_java.repositories;

import br.com.nathan.ecommerce_tech_java.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // O Spring cria o "SELECT * FROM usuarios WHERE cpf = ?" automaticamente!
    boolean existsByCpf(String cpf);

    // O mesmo vale para o e-mail
    boolean existsByEmail(String email);
}
