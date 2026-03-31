package br.com.nathan.ecommerce_tech_java.services;

import br.com.nathan.ecommerce_tech_java.dtos.ProdutoRegistroDTO;
import br.com.nathan.ecommerce_tech_java.models.Produto;
import br.com.nathan.ecommerce_tech_java.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Produto cadastrarProduto(ProdutoRegistroDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setMarca(dto.marca());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setQuantidadeEstoque(dto.quantidadeEstoque());
        produto.setImagemUrl(dto.imagemUrl());
        produto.setCategoria(dto.categoria());

        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

}
