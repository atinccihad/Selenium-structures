package practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01 {
    public static void main(String[] args) throws InterruptedException {
        // ...Exercise1...
        // Set Path
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        // create chrome driver
        WebDriver driver=new ChromeDriver();
        // Maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Open google home page https://www.google.com/
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        // on the same class, Navigate to amazon home page https://www.amazon.com/ Navigate back to google
        driver.get("https://www.amazon.com/");
        driver.navigate().back();
        Thread.sleep(2000);
        // Navigate forward to amazon
        driver.navigate().forward();
        Thread.sleep(2000);
        // Refresh the page
        driver.navigate().refresh();
        Thread.sleep(2000);
        // Close/Qıit the browser
        driver.close();
        // And last step: print "all ok" on console
        System.out.println("all ok");



    }
}
