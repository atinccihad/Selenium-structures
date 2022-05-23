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
import java.time.Duration;

// Bir class olusturun C02_Basicauthentication
public class C02_Basicauthentication {
    WebDriver driver;
    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(3000);
    }

    @Test
    public void test(){
        // https://the-internet.herokuapp.com/basic_auth  sayfasina gidin
        //driver.get("https://the-internet.herokuapp.com/basic_auth");
        // asagidaki yontem ve test datalarini kullanarak authentication'i yapin
        //
        // Html komutu : https://username:password@URL
        // Username : admin
        // password : admin
        // basic authentication isteyen web servisleri bize nasil ve hangi bilgilerle authentication
        // yapabilecegimiz bilgisini de vermek zorundadir
        // bi de bize tarif edilen yontem ve bize verilen bilgileri birebir uygulayarak
        // istedigimiz webservise giris saglayabiliriz

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        // Basarili bir sekilde sayfaya girildigini dogrulayin
        WebElement congratMesajElementi=driver.findElement(By.tagName("p"));

        Assert.assertTrue(congratMesajElementi.isDisplayed());
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
