package i09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_windowHandle {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        //9- Sayfaları Kapatalım
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com/");

        //2- Url'nin amazon içerdiğini test edelim
        String actualUrl = driver.getCurrentUrl();
        String expectedStr = "amazon";
        Assert.assertTrue("actualUrl expectedStr'i icermiyor!", actualUrl.contains(expectedStr));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        String amazonWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle = driver.getWindowHandle();

        //4- title'in BestBuy içerdiğini test edelim
        String expectedTitle = "Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue("actualTitle, expectedTitle'i icermiyor!", actualTitle.contains(expectedTitle));

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java" + Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucuElementi = driver.findElement(By.xpath("//span[text()='\"java\"']"));
        String expectedElement = "\"java\"";
        String actualElement = aramaSonucuElementi.getText();
        Assert.assertTrue("Arama sonucu java icermiyor!", expectedElement.contains(actualElement));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);

        //8- Logonun görünürlüğünü test edelim
        WebElement bestbuyLogo = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("bestbuyLogo is not displayed!", bestbuyLogo.isDisplayed());

    }
}
