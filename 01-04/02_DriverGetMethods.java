package day02_driverMethods.C02_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethods {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());// sayfanin title'ini getirir
        System.out.println(driver.getCurrentUrl());// sayfanin adresini getirir
        System.out.println(driver.getWindowHandle());//CDwindow-E233B21877A6FAE1EE97E796AEE5E8DD 2.de yeni sayfa açildigi icin
                                                     //CDwindow-48FBAC8E8B55CB0DD5C6FB07610CEFCF farkli kod dondurur
        System.out.println(driver.getPageSource());
    }
}
