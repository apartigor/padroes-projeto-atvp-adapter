package app;
import java.util.UUID;

public class LinkedinAPI {

    public String fazerPostLinkedin(String titulo, String corpo) {
        System.out.println("Post feito para a API do LinkedIn com o título '" + titulo + "': '" + corpo + "'");
        // simula a geração de um UUID
        String postUuid = UUID.randomUUID().toString();
        System.out.println("API do LinkedIn retornou o UUID: " + postUuid);
        return postUuid;
    }

    public boolean verificarPublicacao(String publicacaoUUID) {
        // verifica status
        return publicacaoUUID != null && !publicacaoUUID.isEmpty();
    }
}