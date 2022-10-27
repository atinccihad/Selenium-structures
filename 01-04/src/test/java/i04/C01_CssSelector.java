package i04;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//  1 ) Bir class oluşturun : C01_CssSelector
public class C01_CssSelector {
    //  2 ) Main method oluşturun ve aşağıdaki görevi tamamlayın.
    public static void main(String[] args) throws InterruptedException {
        /*
        cssSelectorde sadece id attribute'i icin # kullanilir
        cssSelectorde sadece class attribute'i icin . kullanilir
         */

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //          a. Verilen web sayfasına gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");

        //          b. Locate email textbox
        WebElement emailTextBox = driver.findElement(By.cssSelector("#session_email"));

        //          c. Locate password textbox ve
        WebElement passwordTextBox = driver.findElement(By.cssSelector("#session_password"));

        //          d. Locate signin button
        WebElement signInButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));

        //          e. Asagidaki kullanıcı adını ve şifreyi girin ve sign in düğmesini tıklayın
        //             i. Username : testtechproed@gmail.com
        //             ii. Password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com" + Keys.TAB);
        passwordTextBox.sendKeys("Test1234!");
        Thread.sleep(3000);
        signInButton.click();
        // driver close
        driver.close();

    }
}
