package i01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_driverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        // Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        //Kaynak kodların içinde "Gateway" kelisinin oldugunu test ediniz
        System.out.println(driver.getPageSource());
        String istenenKelime = "Gateway";

        if (driver.getPageSource().contains(istenenKelime)) {
            System.out.println("PageSource testi PASSED");
        } else System.out.println("PageSource testi FAILED");

        driver.close();
    }
}
