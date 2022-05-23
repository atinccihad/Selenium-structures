package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

// Bir class olusturun: DependsOnTest
public class C01_DependsOnTest {
   /*******************************************************************************************************************/
    WebDriver driver;
   /*******************************************************************************************************************/
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test(priority = 1)
    public void logoTest() {
        // https://www.amazon.com/ adresine gidin.
        // 1. Test: Amazon anasayfaya gittiginizi test edin
        driver.get("https://www.amazon.com/");
        WebElement logoElementi = driver.findElement(By.id("nav-logo-sprites"));

        Assert.assertTrue(logoElementi.isDisplayed());
    }
    @Test(dependsOnMethods = "logoTest")
    public void aramaTesti() {
        // 2. Test: 1.Test basarili ise search Box'i kullanarak "Nutella" icinarama yapin ve
        // aramanizin gerceklestigini Test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        String actualTitle = driver.getTitle();
        String arananKelime = "Nutella";

        Assert.assertTrue(actualTitle.contains(arananKelime));
    }
    @Test(dependsOnMethods = "aramaTesti")
    public void fiyatTesti() {
        // 3. Test: "Nutella" icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $14.99 oldugunu test edin
        WebElement ilkUrunElementi = driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        ilkUrunElementi.click();
        WebElement urunFiyatElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[2]"));
        String urunFiyatiString = urunFiyatElementi.getText();
        String arananFiyat = "$14.99";
        Assert.assertTrue(urunFiyatiString.contains(arananFiyat));
    }
    @AfterClass
    public void quit(){
        driver.close();
    }
}

