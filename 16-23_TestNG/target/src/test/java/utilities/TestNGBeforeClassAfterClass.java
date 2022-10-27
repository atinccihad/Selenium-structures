package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestNGBeforeClassAfterClass {
    protected static WebDriver driver;
    protected static String tarih;

    // @BeforeClass,  @AfterClass notasyonlarini TestNG'DE kullanirken JUnit'teki gibi static yapmaya gerek yoktur.

    @BeforeClass(groups = "group1")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        tarih = localDateTime.format(dateTimeFormatter);
    }

    @AfterClass(groups = "group1")
    public void tearDown() {
        driver.quit();
    }
}
