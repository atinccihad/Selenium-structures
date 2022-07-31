package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class C04_SoftAssertion {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
  @Test
  public void test01(){
        // "https://www.hepsiburada.com/" adresine gidin
        driver.get("https://www.hepsiburada.com/");
        // Basligin "Turkiye'nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin

        String expectedTitleSTR="Turkiye'nin En Buyuk Alisveris Sitesi";
        String actualTitleSTR=driver.getTitle();
        Assert.assertFalse(actualTitleSTR.contains(expectedTitleSTR));
        // search kutusuna araba yazip aratin
        WebElement searchBox=driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']"));
        searchBox.sendKeys("araba"+ Keys.ENTER);
        // bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi=driver.findElement(By.xpath("//div[@class='paginatorStyle-label']"));
        String sonucSayisiStr=sonucSayisi.getText();
        System.out.println("SonucSayisi==> "+sonucSayisiStr);
        // sonuc yazisinin "araba" icerdigini dogrulayin.
        WebElement sonucYazisi=driver.findElement(By.xpath("//h1[@class='searchResultSummaryBar-bold']"));

        String sonucYazisiString=sonucYazisi.getText();
        Assert.assertTrue(sonucYazisiString.contains("araba"),"araba yazisi!!!!");
        // sonuc yazisinin "oto" kelimesi icermedigini dogrulayin..
        Assert.assertFalse( sonucYazisiString.contains("oto"),"oto!!!!");
  }
  @AfterMethod
    public void teardown(){driver.close();}
}
