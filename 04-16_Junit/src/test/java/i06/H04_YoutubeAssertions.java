package i06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

//Bir class oluşturun: YoutubeAssertions
public class H04_YoutubeAssertions {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        //1. Launch browser
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.youtube.com adresine gidin
        //Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        driver.get("https://www.youtube.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void titleTest() {
        //○ titleTest  => Sayfa başlığının "YouTube" oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals("actualTitle, expectedTitle ile eslesmiyor!", actualTitle, expectedTitle);


    }

    @Test
    public void logoTest() {
        //○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtubeLogo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue("youtube logo gorunmuyor!", youtubeLogo.isDisplayed());
    }

    @Test
    public void searchBoxTest() {
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue("searchBox'a erisilemiyor!", searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest() {
        //○ wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        Assert.assertNotEquals("actualTitle expectedTitle'a esit!!", actualTitle, expectedTitle);
    }
}
