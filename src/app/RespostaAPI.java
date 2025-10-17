package app;
public class RespostaAPI<T> {
// classe genérica para padronizar as respostas da API

    private final boolean sucesso;
    private final String mensagem;
    private final T dados; // 'T' para poder qualquer tipo, é um tipo genérico

    public RespostaAPI(boolean sucesso, String mensagem, T dados) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.dados = dados;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public T getDados() {
        return dados;
    }

    @Override
    public String toString() {
    return String.format(
        "Response {\n" +
        "  \"sucesso\": %b,\n" +
        "  \"mensagem\": \"%s\",\n" +
        "  \"dados\": \"%s\"\n" +
        "}",
        sucesso, mensagem, dados
        );
    }
}