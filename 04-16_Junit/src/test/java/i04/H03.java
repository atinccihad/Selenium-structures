package i04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class H03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //  2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //  3. Login alanina "username" yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username" + Keys.TAB);

        //  4. Password alanine "password" yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        //  5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//span[@id='money_map_link']")).click();

        //  6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='pay_bills_tab']")).click();

        //  7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("2000");

        //  8. tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");

        //  9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        //  10. "The payment was successfully submitted." mesajinin ciktigini control edin.
        WebElement title = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        if (title.isDisplayed()) {
            System.out.println("The payment was successfully submitted.  testi PASS");
        } else {
            System.out.println("The payment was successfully submitted.  testi FAILED");
        }
        //  11. close the driver
        driver.close();

    }
}
