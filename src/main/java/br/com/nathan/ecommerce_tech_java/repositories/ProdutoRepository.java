package br.com.nathan.ecommerce_tech_java.repositories;

import br.com.nathan.ecommerce_tech_java.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
