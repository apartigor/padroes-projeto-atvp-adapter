package app;
import java.util.ArrayList;
import java.util.List;

public class TiktokAdapter implements GerenciadorMidiaSocial {

    private TiktokAPI tiktokAPI;

    public TiktokAdapter(TiktokAPI tiktokAPI) {
        this.tiktokAPI = tiktokAPI;
    }

    @Override
    public RespostaAPI<String> postarConteudo(String conteudo) {
        try {
            // simular os dados dos vídeos e pegar as #
            byte[] dadosVideoSimulados = "videodata".getBytes();
            String[] hashtags = extrairHashtags(conteudo);
            String videoId = tiktokAPI.enviarVideoCurto(dadosVideoSimulados, conteudo, hashtags);
            return new RespostaAPI<>(true, "Vídeo enviado para o TikTok!", videoId);
        } catch (Exception e) {
            return new RespostaAPI<>(false, "Erro ao postar no TikTok: " + e.getMessage(), null);
        }
    }

    @Override
    public RespostaAPI<String> verificarStatus(String publicacaoId) {
        try {
            long views = tiktokAPI.obterVisualizacoes(publicacaoId);
            String status = "ONLINE - Visualizações: " + views;
            return new RespostaAPI<>(true, "Status do vídeo verificado.", status);
        } catch (Exception e) {
            return new RespostaAPI<>(false, "Erro ao verificar status no TikTok: " + e.getMessage(), null);
        }
    }

    // método para extrair as #
    private String[] extrairHashtags(String texto) {
        List<String> tags = new ArrayList<>();
        for (String palavra : texto.split("\\s+")) {
            if (palavra.startsWith("#")) {
                tags.add(palavra);
            }
        }
        return tags.toArray(new String[0]);
    }
}