package i04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C02_relativeLocators {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidelim
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        // Sayfadaki Berlin Webelementini relative locator kullanarak tiklayalim
        WebElement NYCWE = driver.findElement(By.id("pid3_thumb"));
        WebElement BayAreaWE = driver.findElement(By.id("pid8_thumb"));
        WebElement BerlinWE = driver.findElement(RelativeLocator.
                with(By.tagName("img")).below(NYCWE).toLeftOf(BayAreaWE));
        BerlinWE.click();

        // driver.close();
        driver.close();

    }
}
