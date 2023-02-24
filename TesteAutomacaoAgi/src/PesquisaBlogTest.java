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
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.findElement(id("overlay-open")).click();
        navegador.findElement(className("mobile-search")).click();
        navegador.findElement(By.cssSelector(".mobile-search .search-field")).sendKeys(palavraChaveSucesso);
        navegador.findElement(By.cssSelector(".mobile-search .search-field")).submit();

        WebElement resultadoDaBusca = navegador.findElement(By.className("archive-title"));
        String expectedText = String.format("Resultados da busca por: %s", palavraChaveSucesso);
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        System.out.println("Teste com sucesso clicar No Menu Mobile Clicar Na Lupa Pesquisar Por CDB Para Teste Menor Resolucao");
        navegador.quit();
    }

    @Test
    public void clicarNoMenuMobileClicarNaLupaPesquisarPorDataDePublicacaoNaoEncontraMenorResolucao() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.findElement(id("overlay-open")).click();
        navegador.findElement(className("mobile-search")).click();
        navegador.findElement(By.cssSelector(".mobile-search .search-field")).sendKeys(PalavraChaveErro);
        navegador.findElement(By.cssSelector(".mobile-search .search-field")).submit();

        WebElement resultadoDaBusca = navegador.findElement(By.className("entry-title"));
        String expectedText = String.format("Nenhum resultado");
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        System.out.println("Teste com sucesso");
        navegador.quit();
    }

    @Test
    public void clicarNaLupaPesquisarPorCDB() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.manage().window().maximize();
        navegador.findElement(By.id("search-open")).click();
        navegador.findElement(By.name("s")).sendKeys(palavraChaveSucesso);
        navegador.findElement(By.name("s")).submit();

        WebElement resultadoDaBusca = navegador.findElement(By.className("archive-title"));
        String expectedText = String.format("Resultados da busca por: %s", palavraChaveSucesso);
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        System.out.println("Teste com sucesso");
        navegador.quit();
    }

    @Test
    public void clicarNaLupaPesquisarPorDataDePublicacaoNaoEncontra() {
        // Localiza a caixa de pesquisa e insere um termo inexistente
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
        System.out.println("Teste com sucesso quando clicarNaLupaPesquisarPorDataDePublicacao");
        navegador.quit();
    }

    @Test
    public void clicarNaLupaPesquisarVerificaExistenciaDeConteudoAbrePrimeiroDaLista() {
        // Localiza a caixa de pesquisa e insere um termo inexistente
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
        String actualTextResult = entraNaultimaMateria.getText();
        Assert.assertTrue(expectedTextResult, entraNaultimaMateria.getText().contains(palavraComNavecacao.toLowerCase(Locale.ROOT)));

        //Exibe menssagem no log de sucesso
        System.out.println("Teste com sucesso");
        navegador.quit();
    }

    @Test
    public void clicarNaLupaPesquisarSemArgumentos() {
        // Localiza a caixa de pesquisa e pesquisar sem termo
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.manage().window().maximize();
        navegador.findElement(By.id("search-open")).click();
        navegador.findElement(By.name("s")).submit();

        // Verifica se a mensagem de "palavraComNavecacao" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(By.cssSelector("h1.archive-title"));
        String expectedText = String.format("Resultados da busca por:");
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        //Exibe menssagem no log de sucesso
        System.out.println("Teste com sucesso");
        navegador.quit();
    }


}