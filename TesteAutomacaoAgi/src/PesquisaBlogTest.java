package TesteAutomacaoAgi.src;


import org.aspectj.util.FileUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

class PesquisaBlogTest {

    String palavraChaveSucesso = "CDB";
    String PalavraChaveErro = "13/08/2021";
    String palavraComNavecacao = "Celular";

    @Test
    public void clicarNoMenuMobileClicarNaLupaPesquisarPorCDBParaTesteMenorResolucao() throws IOException {
        // Abre a tela de navegação com tamanho de necessario para menu Mobile, localiza o menu, a caixa de pesquisa e insere um termo existente
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.findElement(id("overlay-open")).click();
        navegador.findElement(className("mobile-search")).click();
        navegador.findElement(By.cssSelector(".mobile-search .search-field")).sendKeys(palavraChaveSucesso);
        navegador.findElement(By.cssSelector(".mobile-search .search-field")).submit();

        // Tira print da tela na hora que realiza a ação programada
        File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(screenshotFile, new File("cenariodetesteprint/screenshot1.png"));

        // Verifica se a mensagem de "palavraChaveSucesso" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(By.className("archive-title"));
        String expectedText = String.format("Resultados da busca por: %s", palavraChaveSucesso);
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso clicar No Menu Mobile Clicar Na Lupa Pesquisar Por CDB Para Teste Menor Resolucao");
        navegador.quit();
    }

    @Test
    public void clicarNoMenuMobileClicarNaLupaPesquisarPorDataDePublicacaoNaoEncontraMenorResolucao() throws IOException {
        // Abre a tela de navegação com tamanho de necessario para menu Mobile, localiza o menu, a caixa de pesquisa e insere um termo inexistente
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.findElement(id("overlay-open")).click();
        navegador.findElement(className("mobile-search")).click();
        navegador.findElement(By.cssSelector(".mobile-search .search-field")).sendKeys(PalavraChaveErro);
        navegador.findElement(By.cssSelector(".mobile-search .search-field")).submit();

        // Tira print da tela na hora que realiza a ação programada
        File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(screenshotFile, new File("cenariodetesteprint/screenshot2.png"));

        // Verifica se a mensagem de "Nenhum resultado" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(By.className("entry-title"));
        String expectedText = String.format("Nenhum resultado");
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
        navegador.quit();
    }

    @Test
    public void clicarNaLupaPesquisarPorCDB() throws IOException {
        // Abre a tela de navegação, maximiza a janela, localiza a caixa de pesquisa e insere um termo existente
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.manage().window().maximize();
        navegador.findElement(id("search-open")).click();
        navegador.findElement(By.name("s")).sendKeys(palavraChaveSucesso);
        navegador.findElement(By.name("s")).submit();

        // Tira print da tela na hora que realiza a ação programada
        File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(screenshotFile, new File("cenariodetesteprint/screenshot3.png"));

        // Verifica se a mensagem de "palavraChaveSucesso" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(className("archive-title"));
        String expectedText = String.format("Resultados da busca por: %s", palavraChaveSucesso);
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
        navegador.quit();
    }

    @Test
    public void clicarNaLupaPesquisarPorDataDePublicacaoNaoEncontra() throws IOException {
        // Abre a tela de navegação, maximiza a janela, localiza a caixa de pesquisa e insere um termo inexistente
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.manage().window().maximize();
        navegador.findElement(By.id("search-open")).click();
        navegador.findElement(By.name("s")).sendKeys(PalavraChaveErro);
        navegador.findElement(By.name("s")).submit();

        // Tira print da tela na hora que realiza a ação programada
        File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(screenshotFile, new File("cenariodetesteprint/screenshot4.png"));

        // Verifica se a mensagem de "Nenhum resultado" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(By.cssSelector("h1.entry-title"));
        String expectedText = String.format("Nenhum resultado");
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso quando clicarNaLupaPesquisarPorDataDePublicacao");
        navegador.quit();
    }

    @Test
    public void clicarNaLupaPesquisarVerificaExistenciaDeConteudoAbrePrimeiroDaLista() throws IOException {
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

        // Tira print da tela na hora que realiza a ação programada
        File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(screenshotFile, new File("cenariodetesteprint/screenshot5.png"));

        // Verifica se o titulo da matéria tem "palavraComNavecacao" e entra na matéria
        WebElement entraNaultimaMateria = navegador.findElement(By.className("entry-title"));
        String expectedTextResult = String.format("%s", palavraComNavecacao);
        Assert.assertTrue(expectedTextResult, entraNaultimaMateria.getText().contains(palavraComNavecacao.toLowerCase(Locale.ROOT)));

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
        navegador.quit();
    }

    @Test
    public void clicarNaLupaPesquisarSemArgumentos() throws IOException {
        // Abre a tela de navegação, maximiza a janela, localiza a caixa de pesquisa sem termo
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.manage().window().maximize();
        navegador.findElement(By.id("search-open")).click();
        navegador.findElement(By.name("s")).submit();

        // Tira print da tela na hora que realiza a ação programada
        File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(screenshotFile, new File("cenariodetesteprint/screenshot6.png"));

        // Verifica se a mensagem de "Resultados da busca por:" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(By.cssSelector("h1.archive-title"));
        String expectedText = String.format("Resultados da busca por:");
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        //Exibe mensagem de sucesso e fecha o navegador
        System.out.println("Teste com sucesso");
        navegador.quit();
    }

}