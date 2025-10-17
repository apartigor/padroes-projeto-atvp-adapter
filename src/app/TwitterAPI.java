package app;
import java.util.concurrent.ThreadLocalRandom;

public class TwitterAPI {

    public long tweetar(String mensagem) {
        System.out.println("Tweet enviado para a API do Twitter: '" + mensagem + "'");
        //simulacao da geracao de um id de tweet
        long tweetId = ThreadLocalRandom.current().nextLong(100000, 999999);
        System.out.println("API do Twitter retornou o ID: " + tweetId);
        return tweetId;
    }

    public String checarStatusTweet(long tweetId) {
        // verifica status
        if (tweetId % 2 == 0) {
            return "OK";
        } else {
            return "FALHA";
        }
    }
}