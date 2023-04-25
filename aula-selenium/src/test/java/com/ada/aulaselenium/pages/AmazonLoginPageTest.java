package com.ada.aulaselenium.pages;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonLoginPageTest {

    ChromeDriver chrome;

    @BeforeAll
    public static void init(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alans\\Downloads\\chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        chrome = new ChromeDriver(options);
    }

    @Test
    public void testLogin(){
        AmazonLoginPage page = new AmazonLoginPage(chrome);
        String email = "email@gmail.com";
        page.enterEmail(email);

//        WebDriverWait wait = new WebDriverWait(chrome,Duration.ofMillis(5000));
        // presenceOfElementLocated condition
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ap_password")));

        String senha = "123456";
        page.enterPassword(senha);
    }
}
