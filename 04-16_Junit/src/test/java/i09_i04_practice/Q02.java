package i09_i04_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q02 {

    // ...Exercise2...
    static WebDriver driver;
    static WebElement searchBox;
    static WebElement sonucSayisi;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void testtenOnce(){
        // http://www.bestbuy.com/ 'agidin,
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void titleTesti(){
        // Sayfa basliginin "Best" icerdigini dogrulayin
        String title= driver.getTitle();
        boolean iceriyorMu= title.contains("Best");
        Assert.assertTrue("title test kelimesi icermiyor..",iceriyorMu);
    }

    @Test
    public void logoDisplayed(){
        // Ayrica relative Locator kullanarak;
        //      logoTest ==> BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
        WebElement helloHeading= driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement logo=driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
        boolean logoGorunuyorMu=logo.isDisplayed();
        Assert.assertTrue(logoGorunuyorMu);
    }
    @Test
    public void linkIsDisplayed(){
        //      mexicoLinkTest ==> Linkin goruntulenip goruntulenmedigini dogrulayin
        WebElement uslink= driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement chooseYazisi=driver.findElement(By.xpath("//h1[.='Choose a country.']"));
        WebElement mexicoLink= driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(uslink).below(chooseYazisi));
        Assert.assertTrue(mexicoLink.isDisplayed());
    }

    @After
    public void testtenSonra(){
        System.out.println("BasliginYazisi==> "+(driver.getTitle()));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
