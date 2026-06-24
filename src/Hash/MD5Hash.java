package Hash;

import interfaces.CalculadoraHash;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MD5Hash implements CalculadoraHash {
    @Override
    public String calcular(String texto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hashBytes = digest.digest(texto.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar MD5", e);
        }
    }
}