import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.LoginPage;

import java.io.File;

import static pages.DashboardPage.error;
import static pages.DashboardPage.errorPage;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = initChromeDriver();
        webDriver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login();

        DashboardPage dashboardPage = new DashboardPage(webDriver);
        dashboardPage.action();

        if (error == 0) {
            System.out.println("\n" + "Все разделы перезагруженны корректно");
        } else {
            System.out.println("\n" + errorPage);
        }

        webDriver.quit();

    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver",
                new File(Main.class.getResource("/chromedriver.exe").getFile()).getPath());
        return new ChromeDriver();
    }
}
