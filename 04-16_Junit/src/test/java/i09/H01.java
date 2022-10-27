package i09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class H01 {
    WebDriver driver;

    @Before
    public void setUp() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void iframeTest() throws InterruptedException {
        // http://demo.guru99.com/test/guru99home/  sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        // sayfadaki iframe sayisini bulunuz
        int iframeSayisi = 0;
       List <WebElement> iframeS =driver.findElements(By.tagName("iframe"));
        for (WebElement each:iframeS ) {
            iframeSayisi++;
        }
        System.out.println("iframeSayisi = " + iframeSayisi);

        // ilk frame'deki(youtube) play butonuna tiklayiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(iframe);

        WebElement play=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();

        Thread.sleep(8000);

    }

}
