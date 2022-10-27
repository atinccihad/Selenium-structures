package i02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_findElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // amazon sayfasina gidiniz.
        driver.get("https://amazon.com");

        // amazon sayfasindaki tag'lari link(a) olanlarin sayisini yazdiriniz.
        List<WebElement> tag = driver.findElements(By.tagName("a"));
        System.out.println("a tag'inin sayisi: " + tag.size());

        // amazon sayfasindaki tag'lari input olanlarin sayisini yazdiriniz.
        tag = driver.findElements(By.tagName("input"));
        System.out.println("input tag'inin sayisi: " + tag.size());
    }
}
