package day05_mavenProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement loginBox;
        WebElement passwordBox;
        WebElement signInButton;

        // 1. http:///zero.webappsecurity.com sayfasina gidin
        driver.get("http:///zero.webappsecurity.com");
        // 2. SignIn butonuna tiklayin
        signInButton=driver.findElement(By.xpath("//button[@id='signin_button']"));
        signInButton.click();
        // 3. Login alanina "username" yazdirin
        loginBox=driver.findElement(By.xpath("//input[@id='user_login']"));
        loginBox.sendKeys("username");
        // 4. Password alanina "password" yazdirin
        passwordBox=driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");
        // 5. Sign in butonuna tiklayin
        signInButton=driver.findElement(By.xpath("//input[@name='submit']"));
        signInButton.click();
        // 6. Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//div[.='Online Banking']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount=driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("10"+ Keys.ENTER);
        // 8. tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("2020-09-10");
        // 9. Pay butonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //10. "The payment was succesfully submitted." mesajinin ciktigini kontrol edin
        WebElement yazi=driver.findElement(By.xpath("//h2[@class='board-header']"));
        if (yazi.isDisplayed()){
            System.out.println("***** Mesaj çıkıyor ******");
        }else {
            System.out.println("Mesaj çıkmıyor..");
        }

        driver.close();
    }
}
