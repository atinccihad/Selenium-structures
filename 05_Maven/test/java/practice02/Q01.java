package practice02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Q01 {
    // ...Exercise1...
    // BeforeClass ile driver olusturun ve class icinde static yapin
    // Maximize yapin 15sn bekletin
    // http://www.google.com/ adresine gidin
    // Arama kutusuna "Green Mile" yazip cikan sonuc sayisini yazdirin
    // Arama kutusuna "Premonition" yazip,cikan sonuc sayisini yazdirin
    // Arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    // AfterClass ile kapatin

   static WebDriver driver;
   static WebElement searchBox;
   static WebElement sonucSayisi;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @AfterClass
    public static void tearDown(){
       driver.close();
    }

    @Before
    public void testtenOnce(){
    driver.get("http://www.google.com/");
    }

    @After
    public void testtenSonra(){
        System.out.println("Sonuc Yazisi==> "+(driver.findElement(By.xpath("//div[@id='result-stats']"))).getText());
        driver.get("http://www.google.com/");

    }

    @Test
    public void test1(){
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Green Mile"+Keys.ENTER);

    }
    @Test
    public void test2(){
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Premonition"+ Keys.ENTER);

    }
    @Test
    public void test3(){
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("The Curious Case of Benjamin Button"+ Keys.ENTER);

    }
}
