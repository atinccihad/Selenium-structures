package i06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1) Bir class oluşturun: C03_Assertions
public class C03_Assertions {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
        //    testleri yapin
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        //         ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bestbuy.com/";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void test02() {
        //         ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Rest";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void test03() {
        //         ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement bestBuyLogo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());

    }

    @Test
    public void test04() {
        //         ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisLink = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(francaisLink.isDisplayed());
    }
}
