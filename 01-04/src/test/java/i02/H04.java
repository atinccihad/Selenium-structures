package i02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class H04 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://izlesene.com");
        WebElement ara =driver.findElement(By.xpath("//input[@id='searchtext_top']"));
        Thread.sleep(2000);
        ara.sendKeys("zeynep bastık ara"+ Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@alt='Zeynep Bastık - Şahaneyim']")).click();
        Thread.sleep(15000);
        driver.close();
    }
}
