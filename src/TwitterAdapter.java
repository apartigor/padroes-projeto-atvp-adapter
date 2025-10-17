package src;
public class TwitterAdapter implements GerenciadorMidiaSocial {

    private TwitterAPI twitterAPI;

    public TwitterAdapter(TwitterAPI twitterAPI) {
        this.twitterAPI = twitterAPI;
    }

    @Override
    public RespostaAPI<String> postarConteudo(String conteudo) {
        try {
            // chama o método da API original
            long tweetId = twitterAPI.tweetar(conteudo);

            // adapta a resposta e converte o id para string
            String idString = String.valueOf(tweetId);

            // cria e retorna uma RespostaAPI com success
            return new RespostaAPI<>(true, "Tweet publicado com sucesso!", idString);

        } catch (Exception e) {
            // aqui teria o tratamento das exceções
            return new RespostaAPI<>(false, "Erro ao conectar com a API do Twitter: " + e.getMessage(), null);
        }
    }

    @Override
    public RespostaAPI<String> verificarStatus(String publicacaoId) {
        try {
            // adapta o parametro, a interface legada usa string, a api usa long
            long tweetId = Long.parseLong(publicacaoId);

            // chama a API
            String statusRetornado = twitterAPI.checarStatusTweet(tweetId);

            // adapta a resposta e retorna o objeto unificado
            boolean sucesso = "OK".equals(statusRetornado);
            String mensagem = "Status verificado: " + statusRetornado;

            return new RespostaAPI<>(sucesso, mensagem, statusRetornado);

        } catch (NumberFormatException e) {
            return new RespostaAPI<>(false, "ID da publicação inválido. Esperado um número.", null);
        } catch (Exception e) {
            return new RespostaAPI<>(false, "Erro ao verificar status no Twitter: " + e.getMessage(), null);
        }
    }
}