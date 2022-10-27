package i09_i04_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// ...Exercise1...
public class Q01 {


// AfterClass ile kapatin

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // BeforeClass ile driver olusturun ve class icinde static yapin
        // Maximize yapin 15sn bekletin
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }


    @Before
    public void testtenOnce() {
        // http://www.google.com/ adresine gidin
        driver.get("http://www.google.com/");
    }

    @After
    public void testtenSonra() {
        // Arama kutusuna "Premonition" yazip,cikan sonuc sayisini yazdirin
        // Arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
        System.out.println("sonuc yazisi :" + driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }

    @Test
    public void test01() {
        // http://www.google.com/ adresine gidin
        // Arama kutusuna "Green Mile" yazip cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Green Mile" + Keys.ENTER);
    }

    @Test
    public void test02() {
        // http://www.google.com/ adresine gidin
        // Arama kutusuna "Premonition" yazip,cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Premonition" + Keys.ENTER);
    }

    @Test
    public void test03() {
        // http://www.google.com/ adresine gidin
        // Arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);
    }
}
