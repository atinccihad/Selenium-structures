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

//Bir class olusturun C01_Allerts
public class C01_Allerts {
    WebDriver driver;
    WebElement sonucYazisiElementi;
    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(3000);
        // https://the-internet.herokuapp.com/javascript_alerts/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAllertTesti() throws InterruptedException {
        // Bir method olusturun: acceptAlert
        //      - 1. butona tiklayin, uyaridaki OK butonuna tiklayin ve result mesajinin
        //        "You succesfully clicked an alert" oldugunu test edin.
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        Thread.sleep(3000);
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String expectedSonucYazisi="You succesfully clicked an alert";
        Assert.assertFalse(actualSonucYazisi.contains(expectedSonucYazisi),expectedSonucYazisi);

    }

    @Test
    public void
     dismissAllertTesti() throws InterruptedException {
        // Bir method olusturun: dismissAlert
        //      - 2. butona tiklayin, uyaridaki cancel butonuna tiklayin ve result mesajinin
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        //        "successfully" icermedigini test edin.
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String istenmeyenKelime="successfully";
        Thread.sleep(3000);
        Assert.assertFalse(actualSonucYazisi.contains(istenmeyenKelime));
    }

    @Test
    public void sendKeysAlertTesti() throws InterruptedException {
        // Bir method olusturun: sendKeysAlert
        //      - 3. butona tiklayin, yukaridaki metin kutusuna isminizi yazin,
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Yildiz");
        //        OK nutonuna tiklayin ve result mesajinda isminizin goruntulendigini dogrulayin.
        driver.switchTo().alert().accept();
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String arananKelime="Yildiz";
        Thread.sleep(3000);
        Assert.assertTrue(actualSonucYazisi.contains(arananKelime));
    }

     @AfterClass
    public void tearDown(){
        driver.close();
     }
}
