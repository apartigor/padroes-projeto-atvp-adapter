package src;
import java.util.concurrent.ThreadLocalRandom;

public class InstagramAPI {

    public int publicarFoto(String caminhoImagem, String legenda) {
        System.out.println("Foto em '" + caminhoImagem + "' publicada no Instagram com a legenda: '" + legenda + "'");
        // simula o ID numérico da postagem
        int postId = ThreadLocalRandom.current().nextInt(1000, 9999);
        System.out.println("API do Instagram retornou o ID: " + postId);
        return postId;
    }

    public int checarEngajamento(int postId) {
        // simula o numero de curtidas
        return ThreadLocalRandom.current().nextInt(0, 5000);
    }
}