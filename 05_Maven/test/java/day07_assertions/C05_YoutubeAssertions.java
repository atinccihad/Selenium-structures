package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1) Bir class olusturun C05_YoutubeAssertions
public class C05_YoutubeAssertions {
   static WebDriver driver;
    //2) https://www.youtube.com adresine gidin
   @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }
    //3) Asagidaki adlari kullanarak 4 test methodu olusturun ve gerekli testleri yapin
    //   -titleTest    => Sayfa basliginin "YouTube" oldugunu test edin
    //   -imageTest    => YouTube resminin goruntulendigini (isDisplayed()) test edin
    //   -Search Box'in erisilebilir oldugunu test edin (isEnabled())
    //   -wrongTitleTest  => Sayfa basliginin "youtube" olmadigini dogrulayin.
    @Test
    public void titleTest(){
        //   -titleTest    => Sayfa basliginin "YouTube" oldugunu test edin
        String actualTitle= driver.getTitle();
        String ecpectedTitle="YouTube";
        Assert.assertEquals("Sayfa title YouTube icermiyor",ecpectedTitle,actualTitle);
    }
    @Test
    public void urlTest(){
        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.YouTube.com/";
        Assert.assertNotEquals("Lutfen URL'i gozden gecirin",expectedURL,actualURL);
    }
    @Test
    public void imageTest(){
     //   -imageTest    => YouTube resminin goruntulendigini (isDisplayed()) test edin
        WebElement youtubeLogo= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue("YouTube resmi gorunmuyor",youtubeLogo.isDisplayed());
    }
    @Test
    public void searchBoxTest(){
        //   -Search Box'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxElementi= driver.findElement(By.xpath("//ytd-searchbox[@id='search']"));
        Assert.assertTrue("Search Box'in erisilebilirligi testi FAIL",searchBoxElementi.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        //   -wrongTitleTest  => Sayfa basliginin "youtube" olmadigini dogrulayin.
        String wrongTitle="youtube";
        String titleElementi= driver.getTitle();
        //Assert.assertFalse("title youtube testi FAIL",titleElementi.equals("youtube"));
        Assert.assertFalse("title youtube testi FAIL",driver.getTitle().contains(wrongTitle));
    }
    @AfterClass
    public static void teardown(){
      driver.close();
    }
}
