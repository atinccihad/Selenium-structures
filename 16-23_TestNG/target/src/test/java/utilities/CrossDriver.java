package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrossDriver {

    private CrossDriver() {

    }

    static String tarih;
    static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        // Eger browser'a bir deger atanmamissa ConfigReader'daki browser calissin
        browser = browser==null ? ConfigReader.getProperty("browser") : browser;

        if (driver == null) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }


        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        tarih = localDateTime.format(dateTimeFormatter);

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null; // kapandiktan sonraki acmalari garanti altina almak icin driver'i tekrar null yaptik
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // kapandiktan sonraki acmalari garanti altina almak icin driver'i tekrar null yaptik
        }
    }

}
