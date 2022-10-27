package i06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

//1)     Bir class oluşturun: BestBuyAssertions
public class H02_BestbuyAssertion {
    WebDriver driver;

    @Before
    public void setUp() {
        //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        //1. Launch browser
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // 2)  https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        //  ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bestbuy.com/";
        Assert.assertEquals("expectedUrl, actualUrl'den farkli!", expectedUrl, actualUrl);

        //  ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Rest";
        Assert.assertFalse("Sayfa basligi Rest iceriyor!", actualTitle.contains(expectedTitle));

        //  ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement bestBuyLogo = driver.findElement(By.xpath("(//img[alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("bestBuy logo not displayed!", bestBuyLogo.isDisplayed());

        //  ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francais = driver.findElement(By.xpath("//button[text()='Francais']"));
        Assert.assertTrue("francais linki gorunmuyor!", francais.isDisplayed());
    }
}
