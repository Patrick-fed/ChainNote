package Hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class SHA256Hash {
    public static String gerarHashSHA256(String texto) {
        try {
            // 1. Obtém a instância do algoritmo SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // 2. Gera o hash em formato de array de bytes
            byte[] hashBytes = digest.digest(texto.getBytes(StandardCharsets.UTF_8));

            // 3. Converte os bytes para uma representação hexadecimal (String)
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                // A operação 0xff & b garante que o byte seja tratado como positivo
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0'); // Adiciona um zero à esquerda se necessário
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            // Essa exceção ocorre se o algoritmo "SHA-256" não existir no Java
            throw new RuntimeException("Erro ao inicializar o algoritmo SHA-256", e);
        }
    }
}