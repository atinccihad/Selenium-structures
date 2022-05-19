package day05_mavenProjeOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1. http://zero.webappsecurity.com/    sayfasina gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2. Signin butonuna tiklayin
        driver.get("signin_button");
        // 3. Login alanina "username" yazdirin
        
        // 4. Password alanina "password" yazdirin
        // 5. Signin butonuna tiklayin
        // 6. Pay Bills sayfasina gidin
        // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        // 8. tarih kismina "2020-09-10" yazdirin
        // 9. Pay butonuna tiklayin
        //10. "The payment was successfully submited." mesajinin ciktigini kontrol edin.

    }
}
