package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
       //1) Bir class olusturun : CssSelector
public class C04_CssSelector {
       //2) Main method olusturun ve asagidaki gorevi tamamlayin.
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  a. Verilen web sayfasina gidin. http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");
        //  b. Locate email textbox
        WebElement emailTextBox=driver.findElement(By.cssSelector("input[id='session_email']"));// xpath // input[@id='session_email']
        // WebElement emailTextBox=driver.findElement(By.cssSelector("#session_email"));  olarakDa kullanilir
        //  c. Locate password textbox ve
        WebElement passwordTextBox=driver.findElement(By.cssSelector("input[placeholder='Password']"));//input[@id='session_password']
        //  d. Locate signin button
        WebElement sigInButonu=driver.findElement(By.cssSelector("input[name='commit']"));// xpath //input[@name='commit']
        //  e. Asagidaki kullanici adi ve sifreyi girin ve sign in dugmesini tiklayin
        //
        //       i. Username : testtechproed@gmail.com
        //      ii. Password : Test1234!
        //
        //
        // NOT: cssSelector kullanarak elementleri locate ediniz


        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        sigInButonu.click();

    }
}
