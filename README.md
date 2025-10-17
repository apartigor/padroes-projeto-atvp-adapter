# Sistema de Integração de APIs de Mídia Social

Este projeto é uma implementação em Java que demonstra o uso dos padrões de projeto **Adapter** e **Factory** para criar uma interface unificada para interagir com múltiplas APIs de mídias sociais que são, por design, incompatíveis entre si.

## Problema Resolvido

O código aborda o desafio comum de integrar serviços de terceiros (neste caso, APIs de mídias sociais) em uma única aplicação. Cada API possui seus próprios métodos, parâmetros e tipos de retorno. Esta solução permite que o código cliente opere através de uma única interface abstrata (`GerenciadorMidiaSocial`), sem precisar conhecer os detalhes específicos de cada API subjacente.

## Padrões de Projeto Utilizados

  * **Adapter Pattern**: Converte a interface de uma classe (a API da mídia social) em outra interface que o cliente espera. Ele cobre e permite que objetos com interfaces incompatíveis trabalhem juntos.
  * **Factory Method Pattern**: Fornece uma interface para criar objetos em uma superclasse, mas permite que as subclasses alterem o tipo de objetos que serão criados. No nosso caso, a `SocialMediaFactory` centraliza a lógica de criação dos adapters específicos.

## Arquitetura do Código

O projeto está estruturado nos seguintes componentes:

1.  **Interface Alvo (`GerenciadorMidiaSocial.java`)**:

      * Define os métodos padronizados (`postarConteudo`, `verificarStatus`) que o sistema cliente usa para todas as interações.

2.  **Componentes a serem Adaptados (`*API.java`)**:

      * `TwitterAPI.java`, `LinkedinAPI.java`, `InstagramAPI.java`, `TiktokAPI.java`.
      * Classes que simulam as bibliotecas de API externas, cada uma com sua própria interface incompatível.

3.  **Adapters (`*Adapter.java`)**:

      * `TwitterAdapter.java`, `LinkedinAdapter.java`, `InstagramAdapter.java`, `TiktokAdapter.java`.
      * Classes que implementam a interface `GerenciadorMidiaSocial`. Cada adapter contém uma instância de uma API e "traduz" as chamadas da interface padrão para as chamadas de método específicas da API que ele adapta.

4.  **Modelo de Resposta (`RespostaAPI.java`)**:

      * Uma classe genérica para padronizar os retornos de todas as operações da API, encapsulando o status de sucesso/falha, uma mensagem descritiva e os dados de retorno.

5.  **Fábrica (`SocialMediaFactory.java`)**:

      * Uma classe com um método estático que cria e retorna a instância correta do adapter com base em um enum `PlataformaMidiaSocial`. Isso desacopla o cliente da instanciação concreta dos adapters.

6.  **Cliente (`AgendadorDePosts.java`)**:

      * Ponto de entrada da aplicação (`main`). Demonstra o uso da `SocialMediaFactory` para obter gerenciadores e interagir com eles através da interface comum, sem nunca se acoplar diretamente a uma implementação de adapter específica.

## Como Executar

### Pré-requisitos

  * JDK (Java Development Kit) instalado.

### Passos

1.  Clone ou baixe todos os arquivos `.java` para um único diretório.

2.  Abra um terminal ou prompt de comando nesse diretório.

3.  Compile todos os arquivos Java:

    ```bash
    javac src/app/*.java 
    ```

4.  Execute a classe principal:

    ```bash
    java -cp src app.AgendadorDePosts
    ```

A saída no console mostrará o processo de postagem e verificação de status em todas as quatro plataformas de mídia social simuladas.