package TesteAutomacaoAgi.src;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;

class PesquisaBlogTest {


    String palavraChaveSucesso = "CDB";
    String PalavraChaveErro = "13/08/2021";


    @Test
    public void clicarNoMenuMobileClicarNaLupaPesquisarPorCDBParaTesteMobile() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.findElement(id("overlay-open")).click();
        navegador.findElement(className("mobile-search")).click();
        navegador.findElement(By.xpath("//*[@id=\"masthead\"]/div[3]/div[2]/form/label/input")).sendKeys(palavraChaveSucesso);
        navegador.findElement(By.xpath("//*[@id=\"masthead\"]/div[3]/div[2]/form/label/input")).submit();

        WebElement resultadoDaBusca = navegador.findElement(By.className("archive-title"));
        String expectedText = String.format("Resultados da busca por: %s", palavraChaveSucesso);
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());

        System.out.println("Teste com sucesso");
        navegador.quit();
    }


    @Test
    public void clicarNoMenuMobileClicarNaLupaPesquisarPorDataDePublicacaoTesteMobile() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();


        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.findElement(id("overlay-open")).click();
        navegador.findElement(className("mobile-search")).click();
        navegador.findElement(By.xpath("//*[@id=\"masthead\"]/div[3]/div[2]/form/label/input")).sendKeys(PalavraChaveErro);
        navegador.findElement(By.xpath("//*[@id=\"masthead\"]/div[3]/div[2]/form/label/input")).submit();

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
    public void clicarNaLupaPesquisarPorDataDePublicacao() {
        // Localiza a caixa de pesquisa e insere um termo inexistente
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.navigate().to("https://blogdoagi.com.br/");
        navegador.manage().window().maximize();
        navegador.findElement(By.id("search-open")).click();
        navegador.findElement(By.name("s")).sendKeys(PalavraChaveErro);
        navegador.findElement(By.name("s")).submit();

        // Verifica se a mensagem de "Nenhum resultado" foi exibida
        WebElement resultadoDaBusca = navegador.findElement(By.className("entry-title"));
        String expectedText = String.format("Nenhum resultado");
        Assert.assertEquals(expectedText, resultadoDaBusca.getText());
        System.out.println("Teste com sucesso quando clicarNaLupaPesquisarPorDataDePublicacao");
        navegador.quit();
    }

}