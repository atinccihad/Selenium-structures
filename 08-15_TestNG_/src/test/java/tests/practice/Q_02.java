package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class Q_02 {
    // birbirine bagimli testler olusturun..
    // BeforeClass olusturup setUp ayarlarini yapin..
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    // birbirine bagimli testler olusturarak;
    @Test
    public void test1(){
        //     ilk once facebook'a gidin
        driver.get("https://www.facebook.com");
    }

    @Test(dependsOnMethods ="test1" )
    public void test2(){
        //     daha sonra facebook'a bagimli olarak google'a gidin,
        driver.get("https://www.google.com");
    }

    @Test(dependsOnMethods ="test2" )
    public void test3(){
        //     daha sonra google'a bagimli olarak amazon'a gidin
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public void teardown(){
        // driver'i kapatin
        driver.close();
    }
}
