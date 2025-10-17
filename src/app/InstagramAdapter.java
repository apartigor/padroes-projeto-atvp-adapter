package app;
public class InstagramAdapter implements GerenciadorMidiaSocial {

    private InstagramAPI instagramAPI;

    public InstagramAdapter(InstagramAPI instagramAPI) {
        this.instagramAPI = instagramAPI;
    }

    @Override
    public RespostaAPI<String> postarConteudo(String conteudo) {
        try {
            // Adapta a interface legada que só recebe texto, então vou passar o caminho da imagem
            String caminhoImagemSimulado = "/images/post_temp.jpg";
            int postId = instagramAPI.publicarFoto(caminhoImagemSimulado, conteudo);
            return new RespostaAPI<>(true, "Foto postada no Instagram!", String.valueOf(postId));
        } catch (Exception e) {
            return new RespostaAPI<>(false, "Erro ao postar no Instagram: " + e.getMessage(), null);
        }
    }

    @Override
    public RespostaAPI<String> verificarStatus(String publicacaoId) {
        try {
            // adapta o parametro, a interface legada usa string, a api usa int
            int postId = Integer.parseInt(publicacaoId);
            int curtidas = instagramAPI.checarEngajamento(postId);
            String status = "ATIVO - Curtidas: " + curtidas;
            return new RespostaAPI<>(true, "Engajamento verificado.", status);
        } catch (NumberFormatException e) {
            return new RespostaAPI<>(false, "ID da publicação inválido para o Instagram.", null);
        }
    }
}