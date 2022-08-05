package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {
   WebDriver driver;
    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        // Sayfadaki text'in "Opening a new window" oldugunu dogrulayin.
       WebElement sayfadakiYaziElementi=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(sayfadakiYaziElementi.getText(),"Opening a new window","Sayfadaki yazi beklenenden farkli.");
        // Sayfa basliginin(title) "The Internet" oldugunu dogrulayin.
        softAssert.assertEquals(driver.getTitle(),"The Internet","sayfa title'i beklenenden farkli");
        // Click Here butonuna basin.
        // Soruda windowhandle degerini bilmedigim bir window aciliyor
        // O sayfanin windowgandle degerini bulmak icin gectigim sayfalardaki
        // window handle degerlerini kaydetmeliyim
        String windowHandleDegeri1=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        // Acilan yeni pencerenin sayfa basliginin(title) "New Window" oldugunu dogrulayin.
        // Once acilan yeni sayfanin handle degerini elde etmeliyim

        // once tum handle degerlerini alip bir set'e koyalim
        Set<String> handleDegerleriSeti=driver.getWindowHandles();
        String windowHandledegeri2="";

        for (String each:handleDegerleriSeti){
            if (!each.equals(windowHandleDegeri1)){
                System.out.println(windowHandledegeri2=each);
            }
        }
        // artik yeni sayfaya gecis yapabilirim
        driver.switchTo().window(windowHandledegeri2);
        softAssert.assertEquals(driver.getTitle(),"New Window","Yeni sayfa title'i istenenden farkli!!");

        // Sayfadaki text'in "New Window" oldugunu dogrulayin.
        WebElement ikinciSayfadakiYaziElementi=driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(ikinciSayfadakiYaziElementi.getText(),"New Window","ikinci sayfadaki yazi istenenden farkli!!");

        // Bir onceki pencereye geri dondukten sonra sayfa basliginin "The Internet" oldugunu dogrulayin.
        driver.switchTo().window(windowHandleDegeri1);
        softAssert.assertEquals(driver.getTitle(),"The Internet","Ilk sayfanin title'i beklenen gibi degil!!");


        softAssert.assertAll();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
