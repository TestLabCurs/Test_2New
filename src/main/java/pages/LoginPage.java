package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver webDriver;
    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void login() throws InterruptedException {
        webDriver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        Thread.sleep(2000);

        WebElement fieldLogin = webDriver.findElement(By.id("email"));
        WebElement fieldPasswort = webDriver.findElement(By.id("passwd"));
        WebElement buttonEnter = webDriver.findElement(By.name("submitLogin"));


        fieldLogin.sendKeys("webinar.test@gmail.com");
        fieldPasswort.sendKeys("Xcg7299bnSmMuRLp9ITw");
        buttonEnter.click();
        Thread.sleep(3000);

    }
}
