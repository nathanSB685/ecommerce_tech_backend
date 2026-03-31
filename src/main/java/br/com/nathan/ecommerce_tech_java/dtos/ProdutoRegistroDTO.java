package br.com.nathan.ecommerce_tech_java.dtos;

import br.com.nathan.ecommerce_tech_java.models.CategoriaProduto;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProdutoRegistroDTO(

        @NotBlank(message = "O nome do produto é obrigatório")
        String nome,

        @NotBlank(message = "A marca é obrigatório")
        String marca,

        String descricao,

        @NotNull(message = "O preço é obrigatório")
        @Positive(message = "O preço deve ser maior que zero")
        BigDecimal preco,

        @NotNull(message = "A quantidade é obrigatória")
        @Min(value = 0, message = "O estoque não pode ser negativo")
        Integer quantidadeEstoque,

        String imagemUrl,

        @NotNull(message = "A categoria é obrigatória")
        CategoriaProduto categoria

) {}
