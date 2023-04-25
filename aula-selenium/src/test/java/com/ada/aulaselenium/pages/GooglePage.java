package com.ada.aulaselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends BasicPage {

    public GooglePage(WebDriver driver){
        super(driver);
        driver.get("http://www.google.com");
    }

    public WebElement getCampoPesquisa(){
        return getPage().findElement(By.id("APjFqb"));
    }

    public void pesquisarPor(String texto){
        WebElement campo = this.getCampoPesquisa();
        campo.clear();
        campo.sendKeys(texto);
        campo.submit();
    }



    public WebElement getBotaoPesquisar(){
        return getPage().findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
    }

}
