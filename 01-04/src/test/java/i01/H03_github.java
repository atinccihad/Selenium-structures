package i01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H03_github {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        // create driver
        WebDriver driver = new ChromeDriver();
        // maximize the window
        driver.manage().window().maximize();
        // go to profile url
        driver.get("https://github.com/atinccihad");
        // watch list
        WebElement profile = driver.findElement(By.xpath("(//a[@class='Link--secondary no-underline no-wrap'])[2]"));
        profile.click();
        Thread.sleep(2000);
        // go to BerkKaranfil's profil
        driver.findElement(By.xpath("//span[@class='f4 Link--primary']")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        // go to CuneytSoylu's profil
        driver.findElement(By.xpath("(//span[@class='Link--secondary'])[1]")).click();
        Thread.sleep(5000);
        driver.navigate().back();
        // go to OguzSaltukBugra's profil
        driver.findElement(By.xpath("(//span[@class='Link--secondary'])[2]")).click();
        Thread.sleep(5000);
        // close the driver
        driver.close();
    }
}
