package br.com.nathan.ecommerce_tech_java.dtos;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public record UsuarioRegistroDTO(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "O CPF é obrigatório")
        @CPF(message = "Formato de CPF inválido")
        String cpf,

        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "Formato de e-mail inválido")
        String email,

        @NotBlank(message = "O celular é obrigatório")
        String celular,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 10, message = "A senha deve ter no mínimo 10 caracteres")
        @Pattern(
                regexp = "^(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).*$",
                message = "A senha deve conter pelo menos um caractere especial"
        )
        String senha,

        // Podemos receber o endereço como campos separados ou um objeto aninhado
        String logradouro, // Opcional, sem anotação
        String complemento, // Opcional, sem anotação

        @NotBlank(message = "O número é obrigatório")
        String numero,

        @NotBlank(message = "O CEP é obrigatório")
        String cep,

        @NotBlank(message = "O bairro é obrigatório")
        String bairro,

        @NotBlank(message = "A cidade é obrigatória")
        String cidade,

        @NotBlank(message = "O estado é obrigatório")
        String estado
) {}
