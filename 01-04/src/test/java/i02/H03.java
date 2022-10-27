package i02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

//1. Bir class oluşturun: H03
public class H03 {
    // 2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        // b. Sign in butonuna basin
        WebElement signIn = driver.findElement(By.id("sign-in"));
        signIn.click();

        // c. email textbox,password textbox, and signin button elementlerini locate edin
        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='session_email']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='session_password']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@value='Sign in']"));

        // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //  i. Username : testtechproed@gmail.com
        //  ii. Password : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com" + Keys.TAB);
        passwordTextBox.sendKeys("Test1234!");
        signInButton.click();

        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement signOutButton = driver.findElement(By.xpath("(//a[@class='nav-item nav-link'])[2]"));
        if (signOutButton.isDisplayed()) {
            System.out.println("user mail: testtechproed@gmail.com");
        } else {
            System.out.println("user mail: testtechproed@gmail.com degil");
        }

        // f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addresses = driver.findElement(By.xpath("//a[@data-test='addresses']"));
        WebElement signOut = driver.findElement(By.xpath("//a[@data-test='sign-out']"));

        if (addresses.isDisplayed() && signOut.isDisplayed()) {
            System.out.println("Addresses ve Sign Out textleri isDisplayed.");
        } else {
            System.out.println("Addresses ve Sign Out textleri notDisplayed.");
        }

        // 3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> webElements = driver.findElements(By.tagName("a"));
        System.out.println("Sayfadaki link sayisi: " + webElements.size());

        // 4. Linkleri yazdiriniz.
        System.out.println("forEach: ");
        for (WebElement each : webElements) {
            System.out.println(each.getText());
        }
        System.out.println("=====================================");

        // 4. Linkleri lambda ile yazdiriniz.
        System.out.println("lambda: ");
        webElements.forEach(t -> System.out.println(t.getText()));

        // 5. driver.close
        driver.close();

    }
}
