package i04_i01_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// ...Exercise1...
public class Q01 {
    public static void main(String[] args) {
        // Set Path
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

        // create chrome driver
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Open google home page https://www.google.com/
        driver.get("https://www.google.com/");

        // on the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().back();

        // Navigate forward to amazon
        driver.navigate().forward();

        // Refresh the page
        driver.navigate().refresh();

        // Close/Quit the browser
        driver.quit();

        // And last step: print "all ok" on console
        System.out.println("all ok");

    }
}
