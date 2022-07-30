package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_IlkTestMethodu {
    WebDriver driver;

    @Test
    public void test01(){
        // amazon.com'a gidelim ve title'in amazon icerdigini test edelim
        driver.get("https://www.amazon.com/");
        String actualTitle=driver.getTitle();
        String arananKelime="amazon";


        if (actualTitle.contains(arananKelime)){
            System.out.println("amazon testi PASS");
        }else {
            System.out.println("amazon testi FAIL");
        }
       // Assert.assertTrue(actualTitle.contains(arananKelime));
    }
    @Test
    public void test02(){
        // google'a gidelim ve basligin "google" icerdigini test edelim
        driver.get("https://www.google.com/");
        // cookies uyarisini kabul ederek kapatin
       // driver.findElement(By.xpath("//div[text()='Ich stimme zu']")).click();
        String actualTitle=driver.getTitle();
        String arananKelime="google";

        if (actualTitle.contains(arananKelime)){
            System.out.println("google testi PASS");
        }else {
            System.out.println("google testi FAIL");
        }
    }

    @Before
    public void ayarlariDuzenle(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void ortaligiTopla(){
        driver.close();
    }
}
