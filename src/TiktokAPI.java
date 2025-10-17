package src;
import java.util.UUID;

public class TiktokAPI {

    public String enviarVideoCurto(byte[] dadosVideo, String descricao, String[] hashtags) {
        System.out.println("Vídeo enviado ao TikTok com a descrição: '" + descricao + "'");
        System.out.println("Hashtags: " + String.join(", ", hashtags));
        String videoId = UUID.randomUUID().toString();
        System.out.println("API do TikTok retornou o ID: " + videoId);
        return videoId;
    }

    public long obterVisualizacoes(String videoId) {
        // simula o numero de visualizacao
        return System.currentTimeMillis() % 100000;
    }
}