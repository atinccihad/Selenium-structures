package i04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class H02 {
    public static void main(String[] args) {
        // 1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement signIn = driver.findElement(By.xpath("//a[@href='/login']"));

        if (signIn.isDisplayed()) {
            System.out.println("Ana sayfanın başarıyla görünür olduğu dogrulandi");
        } else {
            System.out.println("Ana sayfanın  görünür olduğu dogrulanamadi");
        }
        // 4. Click on 'Signup / Login' button
        signIn.click();

        // 5. Verify 'Login to your account' is visible
        // 5. 'Hesabınıza giriş yapın'ın görünür olduğunu doğrulayın
        WebElement loginToYourAccount = driver.findElement(By.xpath("//h2[text()='Login to your account']"));

        if (loginToYourAccount.isDisplayed()) {
            System.out.println("'Hesabınıza giriş yapın'ın görünür olduğu dogrulandi");
        } else {
            System.out.println("'Hesabınıza giriş yapın'ın görünür olduğu dogrulanamadi");
        }

        // 6. Enter correct email address and password
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("asdf" + Keys.TAB);
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("asd@dfg.com" + Keys.TAB);
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("bcdeeee");

        // 7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        // 8. Verify that 'Logged in as username' is visible
        // 8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement loggedInAss = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));

        if (loggedInAss.isDisplayed()) {
            System.out.println("'Kullanıcı adı olarak oturum açıldı' ifadesi görünür");
        } else {
            System.out.println("'Kullanıcı adı olarak oturum açıldı' ifadesi görünür degil");
        }

        // 9. Click 'Logout' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[1]")).click();

        // 10. Verify that user is navigated to login page
        // 10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        if (driver.getCurrentUrl().equals("https://automationexercise.com/login")) {
            System.out.println("'Hesabınıza giriş yapın sayfasina yonlendirildigi dogrulandi");
        } else {
            System.out.println("'Hesabınıza giriş yapın sayfasina yonlendirildigi dogrulanamadi");
        }

        // 11.driver close
        driver.close();

    }
}
