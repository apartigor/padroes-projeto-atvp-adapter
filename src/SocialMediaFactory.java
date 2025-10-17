package src;
public class SocialMediaFactory {

    public static GerenciadorMidiaSocial criarGerenciador(PlataformaMidiaSocial plataforma) {
        if (plataforma == null) {
            throw new IllegalArgumentException("A plataforma não pode ser nula.");
        }

        switch (plataforma) {
            case TWITTER:
                TwitterAPI twitterAPI = new TwitterAPI();
                return new TwitterAdapter(twitterAPI);

            case LINKEDIN:
                LinkedinAPI linkedinAPI = new LinkedinAPI();
                return new LinkedinAdapter(linkedinAPI);

            case INSTAGRAM:
                InstagramAPI instagramAPI = new InstagramAPI();
                return new InstagramAdapter(instagramAPI);

            case TIKTOK:
                TiktokAPI tiktokAPI = new TiktokAPI();
                return new TiktokAdapter(tiktokAPI);

            default:
                throw new IllegalArgumentException("Plataforma de mídia social não suportada: " + plataforma);
        }
    }
}