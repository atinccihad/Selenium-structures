package i06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

// Bir class oluşturun : RadioButtonTest
public class H03_RadioButtonTest {
    WebDriver driver;

    @Before
    public void setUp() {
        //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        //1. Launch browser
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        // Cookies'i kabul edin
        // "Create an Account" button'una basin
        driver.findElement(By.xpath("//a[text()='Create new account'")).click();
        // "radio buttons" elementlerini locate edin
        // secili degilse cinsiyet butonundan sizi uygun olani secin
        driver.findElement(By.xpath("//input[@value='2']")).click();
    }

}
