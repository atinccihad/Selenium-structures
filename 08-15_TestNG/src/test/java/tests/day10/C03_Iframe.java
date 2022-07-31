package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class C03_Iframe {

    WebDriver driver;
    // Bir method olusturun: iframeTest
    public void iframeTest(){

    }
    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(3000);
    }
    @Test
    public void iframeTesti(){
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // Bir method olusturun: iframeTest
        //     -"An IFrame containing..." text'inin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement istenenYaziElementi= driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(istenenYaziElementi.isEnabled(),"iFrame yazisi gorunmuyor..");
        System.out.println(istenenYaziElementi.getText());

        // yazi yazmak istedigimiz text kutusu iframe'in icinde oldugundan direk ulasamiyoruz
        // Once iframe'i locate edip onun icine switch yapmaliyiz.

        //     -Text Box'a "Merhaba Dunya!" yazdirin
        WebElement iFrame=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);

        WebElement textBox=driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya.");
        //     -TextBox'in altinda bulunan "Elemental Selenium" linkini tiklayin
        // Yukarida iframe'in icine switch yaptigimizdan yeniden disari cikmak istedigimizde
        // ana sayfaya donmeliyiz...
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        //  Yeni sayfada "Sponsored by Sauce Labs" text'inin gorunur oldugunu dogrulayin ve konsolda yazdirin.

        // Sponsored yazisi yeni sayfada oldugundan ve driver eski sayfada kaldigindan
        // yaziyi locate edemedik..
        WebElement sponsoredYazisiElementi=driver.findElement(By.xpath("//p[text()='Sponsored by ']"));
        Assert.assertTrue(sponsoredYazisiElementi.isDisplayed(),"notDisplayed..");

        softAssert.assertAll();
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
