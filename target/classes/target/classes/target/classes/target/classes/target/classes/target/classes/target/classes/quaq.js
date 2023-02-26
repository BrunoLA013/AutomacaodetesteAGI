// Importa as bibliotecas necessárias
const webdriver = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');
const { Builder, By, Key, until } = require('selenium-webdriver');

// Define o navegador que será utilizado
const options = new chrome.Options();
options.addArguments('start-maximized');
const driver = new Builder()
    .forBrowser('chrome')
    .setChromeOptions(options)
    .build();

// Define o URL do website a ser testado
const url = 'https://blogdoagi.com.br/';

// Define as palavras-chave a serem testadas
const palavrasChave = [
    'automação',
    'selenium',
    'testes',
    'webdriver'
];

// Define os testes a serem executados
async function runTests() {
    try {
        // Abre a página inicial do website
        await driver.get(url);

        // Teste 1 - Verifica se a página inicial foi carregada corretamente
        const title = await driver.getTitle();
        if (title !== 'Blog do Agi') {
            console.log('Erro no Teste 1: Página inicial não foi carregada corretamente');
        }

        // Teste 2 - Verifica se a busca por uma palavra-chave existente retorna resultados corretos
        await driver.findElement(By.name('s')).sendKeys(palavrasChave[0], Key.RETURN);
        await driver.wait(until.titleIs(`Resultados da busca por: ${palavrasChave[0]} | Blog do Agi`), 5000);

        // Teste 3 - Verifica se a busca por uma palavra-chave inexistente retorna mensagem de erro
        await driver.findElement(By.name('s')).sendKeys('palavranaoencontrada', Key.RETURN);
        await driver.wait(until.elementLocated(By.css('.no-results')), 5000);

        // Teste 4 - Verifica se a busca funciona em diferentes tamanhos de tela
        await driver.manage().window().setSize(800, 600);
        await driver.findElement(By.name('s')).sendKeys(palavrasChave[2], Key.RETURN);
        await driver.wait(until.titleIs(`Resultados da busca por: ${palavrasChave[2]} | Blog do Agi`), 5000);
        await driver.manage().window().setSize(1024, 768);
        await driver.findElement(By.name('s')).sendKeys(palavrasChave[2], Key.RETURN);
        await driver.wait(until.titleIs(`Resultados da busca por: ${palavrasChave[2]} | Blog do Agi`), 5000);
        await driver.manage().window().setSize(1280, 1024);
        await driver.findElement(By.name('s')).sendKeys(palavrasChave[2], Key.RETURN);
        await driver.wait(until.titleIs(`Resultados da busca por: ${palavrasChave[2]} | Blog do Agi`), 5000);

        // Finaliza os testes e fecha o navegador
        console.log('Testes finalizados com sucesso!');
        await driver.quit();
    } catch (error) {
        console.log(`Erro: ${error}`);
        await driver.quit();
    }
}