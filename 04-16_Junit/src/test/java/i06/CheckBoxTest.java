package i06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

//Bir class oluşturun : CheckBoxTest
public class CheckBoxTest {
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
    public void test01() throws InterruptedException {
        // a. Verilen web sayfasina gidin.
        //      https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        // b. checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath(" (//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath(" (//input[@type='checkbox'])[2]"));
        // c. checkbox1 secili degilse onay kutusunu tiklayin
        Thread.sleep(3000);
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        // d. checkbox2 secili degilse onay kutusunu tiklayin
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
        Thread.sleep(3000);
    }

}



