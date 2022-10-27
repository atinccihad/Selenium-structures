package i08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C04_Iframe {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
       // driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        //https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Youtube videosunu çalıştırınız
        WebElement youtubeiFrame = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtubeiFrame);
        Thread.sleep(5000);
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();
        actions.sendKeys(Keys.UP).perform();
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@title='Pause (k)']")).click();
        Thread.sleep(5000);
        //JavascriptExecutor js= (JavascriptExecutor) driver;
        //js.executeAsyncScript("youtubeiFrame",45,45);

        Thread.sleep(5000);
    }
}