package com.ada.aulaselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonLoginPage extends BasicPage {

    public AmazonLoginPage(WebDriver driver) {
        super(driver);
        driver.get("http://www.amazon.com.br/login");
    }

    public WebElement getEmail() {
        return getPage().findElement(By.id("ap_email"));
    }

    public WebElement getContinueLogin() {
        return getPage().findElement(By.id("continue"));
    }

    public WebElement getPassword() {
        return getPage().findElement(By.id("ap_password"));
    }

    public WebElement getButtonLogin() {
        return getPage().findElement(By.id("signInSubmit"));
    }

    public void login(String email, String password) {
        enterEmail(email);

        enterPassword(password);
    }

    public void enterEmail(String email){
        getEmail().sendKeys(email);
        getContinueLogin().click();
    }

    public void enterPassword(String pwd){
        getPassword().sendKeys(pwd);
        getButtonLogin().click();
    }
}
