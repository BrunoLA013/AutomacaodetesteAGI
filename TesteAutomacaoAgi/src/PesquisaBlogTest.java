package TesteAutomacaoAgi.src;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

class PesquisaBlogTest {


    String palavraChaveSucesso = "CDB";
    String PalavraChaveErro = "13/08/2021";
    String palavraComNavecacao = "Celular";

    @Test
    public void clicarNoMenuMobileClicarNaLupaPesquisarPorCDBParaTesteMenorResolucao() {
        // Abre a tela de navegação com tamanho de necessario para menu Mobile, localiza o menu, a caixa de pesquisa e insere um termo existente
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.findElement(id("overlay-open")).click();
        navegador.findElement(className("mobile-search")).click();
        navegador.findElement(By.cssSelector(".mobile-search .search-field")).sendKeys(palavraChaveSucesso);
        navegador.findElement(By.cssSelector(".mobile-search .search-field")).submit();

        // Verifica se a mensagem de "palavraChaveSucesso" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(By.className("archive-title"));
        String expectedText = String.format("Resultados da busca por: %s", palavraChaveSucesso);
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso clicar No Menu Mobile Clicar Na Lupa Pesquisar Por CDB Para Teste Menor Resolucao");
        navegador.quit();
    }

    @Test
    public void clicarNoMenuMobileClicarNaLupaPesquisarPorDataDePublicacaoNaoEncontraMenorResolucao() {
        // Abre a tela de navegação com tamanho de necessario para menu Mobile, localiza o menu, a caixa de pesquisa e insere um termo inexistente
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.findElement(id("overlay-open")).click();
        navegador.findElement(className("mobile-search")).click();
        navegador.findElement(By.cssSelector(".mobile-search .search-field")).sendKeys(PalavraChaveErro);
        navegador.findElement(By.cssSelector(".mobile-search .search-field")).submit();

        // Verifica se a mensagem de "Nenhum resultado" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(By.className("entry-title"));
        String expectedText = String.format("Nenhum resultado");
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
        navegador.quit();
    }

    @Test
    public void clicarNaLupaPesquisarPorCDB() {
        // Abre a tela de navegação, maximiza a janela, localiza a caixa de pesquisa e insere um termo existente
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.manage().window().maximize();
        navegador.findElement(By.id("search-open")).click();
        navegador.findElement(By.name("s")).sendKeys(palavraChaveSucesso);
        navegador.findElement(By.name("s")).submit();

        // Verifica se a mensagem de "palavraChaveSucesso" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(By.className("archive-title"));
        String expectedText = String.format("Resultados da busca por: %s", palavraChaveSucesso);
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
        navegador.quit();
    }

    @Test
    public void clicarNaLupaPesquisarPorDataDePublicacaoNaoEncontra() {
        // Abre a tela de navegação, maximiza a janela, localiza a caixa de pesquisa e insere um termo inexistente
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.manage().window().maximize();
        navegador.findElement(By.id("search-open")).click();
        navegador.findElement(By.name("s")).sendKeys(PalavraChaveErro);
        navegador.findElement(By.name("s")).submit();

        // Verifica se a mensagem de "Nenhum resultado" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(By.cssSelector("h1.entry-title"));
        String expectedText = String.format("Nenhum resultado");
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso quando clicarNaLupaPesquisarPorDataDePublicacao");
        navegador.quit();
    }

    @Test
    public void clicarNaLupaPesquisarVerificaExistenciaDeConteudoAbrePrimeiroDaLista() {
        // Abre a tela de navegação, maximiza a janela, localiza a caixa de pesquisa e insere um termo inexistente
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.manage().window().maximize();
        navegador.findElement(By.id("search-open")).click();
        navegador.findElement(By.name("s")).sendKeys(palavraComNavecacao);
        navegador.findElement(By.name("s")).submit();

        // Verifica se a mensagem de "palavraComNavecacao" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(By.className("archive-title"));
        String expectedText = String.format("Resultados da busca por: %s", palavraComNavecacao);
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        //Seleciona e entra na ultima matéria postada
        navegador.findElement(By.cssSelector("h2.entry-title")).click();

        // Verifica se o titulo da matéria tem "palavraComNavecacao" e entra na matéria
        WebElement entraNaultimaMateria = navegador.findElement(By.className("entry-title"));
        String expectedTextResult = String.format("%s", palavraComNavecacao);
        Assert.assertTrue(expectedTextResult, entraNaultimaMateria.getText().contains(palavraComNavecacao.toLowerCase(Locale.ROOT)));


        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
        navegador.quit();
    }

    @Test
    public void clicarNaLupaPesquisarSemArgumentos() {
        // Abre a tela de navegação, maximiza a janela, localiza a caixa de pesquisa sem termo
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.manage().window().maximize();
        navegador.findElement(By.id("search-open")).click();
        navegador.findElement(By.name("s")).submit();

        // Verifica se a mensagem de "Resultados da busca por:" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(By.cssSelector("h1.archive-title"));
        String expectedText = String.format("Resultados da busca por:");
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());


        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
        navegador.quit();
    }

}