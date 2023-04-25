package com.ada.aulaselenium.pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleTest {

    @Test
    public void testeTitulo(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alans\\Downloads\\chromedriver.exe");
//        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver chrome = new ChromeDriver(options);

        GooglePage page = new GooglePage(chrome);
        page.pesquisarPor("Cotação dolar");

        String title = page.getTitulo();
        String expected = "Google";
        assertEquals(expected, title);

//        WebElement botao = page.getBotaoPesquisar();
//        botao.click();

        assertTrue(chrome.getTitle().equals("cotação dolar hoje - Pesquisa Google"));
    }

    @Test
    public void teste2(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alans\\Downloads\\chromedriver.exe");
//        System.setProperty("webdriver.http.factory", "jdk-http-client");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver chrome = new ChromeDriver(options);
        chrome.get("http://www.google.com");

        String textoPesquisado = "cotação bitcoin";

        WebElement textArea = chrome.findElement(By.id("APjFqb"));
        textArea.clear();
        textArea.sendKeys(textoPesquisado);
        textArea.submit();
        ExpectedCondition condicao = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().toLowerCase().startsWith(textoPesquisado.toLowerCase());
            }
        };
        new WebDriverWait(chrome, Duration.ofMillis(500)).until(condicao);

    }

}
