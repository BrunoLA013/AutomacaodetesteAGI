package TesteAutomacaoAgi.src;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class PesquisaBlogTest {

    private PesquisaPagina pesquisaPagina;
    private String palavraChaveSucesso = "CDB";
    private String palavraChaveErro = "13/08/2021";
    private String palavraComNavecacao = "Celular";

    @BeforeEach
    private void beforeEach() {
        this.pesquisaPagina = new PesquisaPagina();
    }

    @AfterEach
    public void affeterEache() {
        this.pesquisaPagina.fechar();
    }

    @Test
    public void clicarNoMenuMobileClicarNaLupaPesquisarPorCDBParaTesteMenorResolucao() throws IOException {
        // Abre a tela de navegação com tamanho de necessario para menu Mobile, localiza o menu, a caixa de pesquisa e insere um termo existente
        pesquisaPagina.preencheComPesquisaValidaResolucaoMenor(palavraChaveSucesso);
        // Tira print da tela na hora que realiza a ação programada
        pesquisaPagina.tiraPrintDoResultado();
        // Verifica se a mensagem de "palavraChaveSucesso" foi exibida
        pesquisaPagina.verificaSePalavraComSucessoFoiExibida(palavraChaveSucesso);
        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso clicar No Menu Mobile Clicar Na Lupa Pesquisar Por CDB Para Teste Menor Resolucao");
    }

    @Test
    public void clicarNoMenuMobileClicarNaLupaPesquisarPorDataDePublicacaoNaoEncontraMenorResolucao() throws IOException {
        // Abre a tela de navegação com tamanho de necessario para menu Mobile, localiza o menu, a caixa de pesquisa e insere um termo inexistente
        pesquisaPagina.preencheComPesquisaValidaResolucaoMenor(palavraChaveErro);

        // Tira print da tela na hora que realiza a ação programada
        pesquisaPagina.tiraPrintDoResultado();

        // Verifica se a mensagem de "Nenhum resultado" foi exibida
        pesquisaPagina.verificaSePalavraComErroFoiExibida(palavraChaveErro);

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
    }

    @Test
    public void clicarNaLupaPesquisarPorCDB() throws IOException {
        // Abre a tela de navegação, maximiza a janela, localiza a caixa de pesquisa e insere um termo inexistente
        pesquisaPagina.maximizaTela();
        pesquisaPagina.preencheComPesquisaValidaResolucaoMaior(palavraChaveSucesso);

        // Tira print da tela na hora que realiza a ação programada
        pesquisaPagina.tiraPrintDoResultado();

        // Verifica se a mensagem de "Nenhum resultado" foi exibida
        pesquisaPagina.verificaSePalavraComSucessoFoiExibida(palavraChaveSucesso);

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
    }

    @Test
    public void clicarNaLupaPesquisarPorDataDePublicacaoNaoEncontra() throws IOException {
        // Abre a tela de navegação com tamanho de necessario para menu Mobile, localiza o menu, a caixa de pesquisa e insere um termo inexistente
        pesquisaPagina.maximizaTela();
        pesquisaPagina.preencheComPesquisaValidaResolucaoMaior(palavraChaveErro);

        // Tira print da tela na hora que realiza a ação programada
        pesquisaPagina.tiraPrintDoResultado();

        // Verifica se a mensagem de "Nenhum resultado" foi exibida
        pesquisaPagina.verificaSePalavraComErroFoiExibida(palavraChaveErro);

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
    }

    @Test
    public void clicarNaLupaPesquisarVerificaExistenciaDeConteudoAbrePrimeiroDaLista() throws IOException {
        // Abre a tela de navegação, maximiza a janela, localiza a caixa de pesquisa e insere um termo inexistente
        pesquisaPagina.maximizaTela();
        pesquisaPagina.preencheComPesquisaValidaResolucaoMaior(palavraComNavecacao);

        // Verifica se a mensagem de "palavraComNavecacao" foi exibida
        pesquisaPagina.verificaMensageConfirmaExistenciaDaPalavraENavaga(palavraComNavecacao);

        // Tira print da tela na hora que realiza a ação programada
        pesquisaPagina.tiraPrintDoResultado();

        // Verifica se o titulo da matéria tem "palavraComNavecacao" e entra na matéria
        pesquisaPagina.verificaENavega(palavraComNavecacao);

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
    }

    @Test
    public void clicarNaLupaPesquisarSemArgumentos() throws IOException {
        // Abre a tela de navegação, maximiza a janela, localiza a caixa de pesquisa sem termo
        pesquisaPagina.maximizaTela();
        pesquisaPagina.pesquisaSemString();

        // Tira print da tela na hora que realiza a ação programada
        pesquisaPagina.tiraPrintDoResultado();

        // Verifica se a mensagem de "Resultados da busca por:" foi exibida
        pesquisaPagina.verificaMensageSemPesquisa();

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
    }

}