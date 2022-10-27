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

public class C04_Assertions {
    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
        //    testleri yapin
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void titleTest() {
        // * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals("Sayfa title YouTube degil.", actualTitle, expectedTitle);
    }

    @Test
    public void imageTest() {
        //  * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        //  * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement youtubeLogo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue("youtubeLogo not displayed!", youtubeLogo.isDisplayed());
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue("youtube searchBox erisilemiyor!", searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest() {
        // * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualYoutubeTitle = driver.getTitle();
        String unExpectedYoutubeTitle = "youtube";
        Assert.assertNotEquals("actualYoutubeTitle ve expectedYoutubeTitle esit!", actualYoutubeTitle, unExpectedYoutubeTitle);
    }

}
