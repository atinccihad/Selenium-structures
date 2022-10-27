package i09_i04_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_GMIBankLogin {
    public static void main(String[] args) {
        // 1) https://www.gmibank.com/ adresine gidin
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.gmibank.com/");

        // 2) Sign In butonuna tikla
        driver.findElement(By.xpath("(//a[@aria-haspopup='true'])[2]")).click();
        driver.findElement(By.xpath("//a[@id='login-item']")).click();

        // 3) Username: Batch81, Password: Batch81+
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Batch81");
        driver.findElement(By.cssSelector("#password")).sendKeys("Batch81+");
        driver.findElement(By.xpath("(//span[text()='Sign in'])[3]")).click();

        driver.close();
    }

}
