package app;

public class AgendadorDePosts {

    public static void main(String[] args) {
        System.out.println("--- Iniciando Sistema de Gerenciamento de Mídias Sociais ---");
        System.out.println();

        GerenciadorMidiaSocial gerenciadorTwitter = SocialMediaFactory.criarGerenciador(PlataformaMidiaSocial.TWITTER);
        GerenciadorMidiaSocial gerenciadorLinkedin = SocialMediaFactory.criarGerenciador(PlataformaMidiaSocial.LINKEDIN);
        GerenciadorMidiaSocial gerenciadorInstagram = SocialMediaFactory.criarGerenciador(PlataformaMidiaSocial.INSTAGRAM);
        GerenciadorMidiaSocial gerenciadorTikTok = SocialMediaFactory.criarGerenciador(PlataformaMidiaSocial.TIKTOK);

        testarPlataforma(gerenciadorTwitter, "Twitter", "Estou nos TRENDING TOPICS #Chama");
        testarPlataforma(gerenciadorLinkedin, "Linkedin", "Preciso de um emprego, alguem?");
        testarPlataforma(gerenciadorInstagram, "Instagram", "Estava aqui codando e decidi postar essa foto #EuAmoCodarEmJava");
        testarPlataforma(gerenciadorTikTok, "TikTok", "Tutorial básico para ensinar a como codar em java #Pegadinha #Fake");

        System.out.println("--- Sistema finalizado com sucesso! ---");
    }

    public static void testarPlataforma(GerenciadorMidiaSocial gerenciador, String nomePlataforma, String conteudo) {
        System.out.println("==================================================");
        System.out.println(">>> Processando postagem no " + nomePlataforma + " <<<");

        RespostaAPI<String> respostaPost = gerenciador.postarConteudo(conteudo);

        if (respostaPost.isSucesso()) {
            String postId = respostaPost.getDados();
            System.out.println("Sucesso! Publicação no " + nomePlataforma + " realizada. ID: " + postId);

            System.out.println("Verificando status da postagem...");
            RespostaAPI<String> respostaStatus = gerenciador.verificarStatus(postId);
            System.out.println("Resposta da verificação: \n\n" + respostaStatus);
        } else {
            System.out.println("Falha ao postar no " + nomePlataforma + ": " + respostaPost.getMensagem());
        }
        System.out.println();
    }
}