package app;
// Interface para usar o sistema de resposta unificado
public interface GerenciadorMidiaSocial {

    RespostaAPI<String> postarConteudo(String conteudo);

    RespostaAPI<String> verificarStatus(String publicacaoId);

}