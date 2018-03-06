package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {
    WebDriver webDriver;
    public static int error;
    public static String errorPage = "Некорректно перегрузившиеся разделы";
    private String fieldDashboard = "1";
    private String fieldOrder = "3";
    private String fieldCatalog = "9";
    private String fieldClients = "23";
    private String fieldSupport = "27";
    private String fieldStatistics = "31";
    private String fieldModules = "42";
    private String fieldDesign = "46";
    private String fieldDelivery = "52";
    private String fieldPaymentMathod = "55";
    private String fieldInternational = "58";
    private String fieldShopParameters = "73";
    private String fieldConfiguration = "95";

    public DashboardPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void action() throws InterruptedException {

        List<String> locators = new ArrayList<String>();
        locators.add(fieldDashboard);
        locators.add(fieldOrder);
        locators.add(fieldCatalog);
        locators.add(fieldClients);
        locators.add(fieldSupport);
        locators.add(fieldStatistics);
        locators.add(fieldModules);
        locators.add(fieldDesign);
        locators.add(fieldDelivery);
        locators.add(fieldPaymentMathod);
        locators.add(fieldInternational);
        locators.add(fieldShopParameters);
        locators.add(fieldConfiguration);


        for (String element : locators) {
            String adress = "li[data-submenu=" + "'" + element + "'" + "]";
            WebElement locator = webDriver.findElement(By.cssSelector(adress));
            locator.click();
            PrintRefreshPrint(webDriver);
        }


        Thread.sleep(5000);
    }


    public static void PrintRefreshPrint(WebDriver webDriver) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Раздел - " + webDriver.getTitle());
        String pageOne = webDriver.getTitle();
        webDriver.navigate().refresh();
        Thread.sleep(1000);
        String pageTwo = webDriver.getTitle();
        System.out.println("Раздел после перезагрузки - " + webDriver.getTitle());

        if (pageOne.equals(pageTwo)) {
            System.out.println("Пользователь остался в том же разделе \n");
        } else {
            error++;
            errorPage = errorPage + "\n " + pageOne;
        }

    }
}