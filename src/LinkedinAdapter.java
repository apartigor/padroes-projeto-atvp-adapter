package src;
public class LinkedinAdapter implements GerenciadorMidiaSocial {

    private LinkedinAPI linkedinAPI;

    public LinkedinAdapter(LinkedinAPI linkedinAPI) {
        this.linkedinAPI = linkedinAPI;
    }

    @Override
    public RespostaAPI<String> postarConteudo(String conteudo) {
        try {
            // Adapta pois a API precisa de um titulo e um corpo
            String titulo = "Nova Publicação Profissional";
            
            // chama a API original e pega o ID
            String postUuid = linkedinAPI.fazerPostLinkedin(titulo, conteudo);

            // cria e retorna uma RespostaAPI de success com o ID
            if (postUuid != null && !postUuid.isEmpty()) {
                return new RespostaAPI<>(true, "Post enviado com sucesso ao LinkedIn!", postUuid);
            } else {
                return new RespostaAPI<>(false, "A API do LinkedIn não retornou um ID.", null);
            }
        } catch (Exception e) {
            return new RespostaAPI<>(false, "Erro ao conectar com a API do LinkedIn: " + e.getMessage(), null);
        }
    }

    @Override
    public RespostaAPI<String> verificarStatus(String publicacaoId) {
        try {
            // o formato ja esta em string
            boolean statusOk = linkedinAPI.verificarPublicacao(publicacaoId);
            
            // adapta a resposta pois a API espera um boolean
            if (statusOk) {
                return new RespostaAPI<>(true, "Publicação encontrada.", "ATIVO");
            } else {
                return new RespostaAPI<>(false, "Publicação não encontrada ou inválida.", "NÃO ENCONTRADO");
            }
        } catch (Exception e) {
            return new RespostaAPI<>(false, "Erro ao verificar status no LinkedIn: " + e.getMessage(), null);
        }
    }
}