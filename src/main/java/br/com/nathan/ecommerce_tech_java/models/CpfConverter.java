package br.com.nathan.ecommerce_tech_java.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Converter
public class CpfConverter implements AttributeConverter<String, String> {

    // Em produção, essa chave DEVE vir das variáveis de ambiente (.env), nunca escrita no código!
    // Deve ter exatamente 16, 24 ou 32 caracteres.
    private static final String CHAVE_SECRETA = "TechStoreKey2026";
    private static final String ALGORITMO = "AES";

    @Override
    public String convertToDatabaseColumn(String cpfReal) {
        if (cpfReal == null) return null;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(CHAVE_SECRETA.getBytes(), ALGORITMO));
            return Base64.getEncoder().encodeToString(cipher.doFinal(cpfReal.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criptografar o CPF", e);
        }
    }

    @Override
    public String convertToEntityAttribute(String cpfCriptografado) {
        if (cpfCriptografado == null) return null;
        try {
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(CHAVE_SECRETA.getBytes(), ALGORITMO));
            return new String(cipher.doFinal(Base64.getDecoder().decode(cpfCriptografado)));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao descriptografar o CPF", e);
        }
    }
}
