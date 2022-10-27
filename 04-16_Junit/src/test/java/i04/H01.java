package i04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class H01 {
    public static void main(String[] args) {
        // 1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement homeButton = driver.findElement(By.xpath("//a[@style='color: orange;']"));

        if (homeButton.isDisplayed()) {
            System.out.println("home page is visible successfully");
        } else {
            System.out.println("home page is not visible ");
        }

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // 5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        if (loginToYourAccount.isDisplayed()) {
            System.out.println("Verify 'Login to your account' is visible");
        } else {
            System.out.println("Verify 'Login to your account' notDisplayed");
        }

        // 6. Enter correct email address and password
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("asdf" + Keys.TAB);
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("asd@dfg.com" + Keys.TAB);
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("bcdeeee");

        // 7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        // 8. Verify that 'Logged in as username' is visible;
        WebElement loggedInAs = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        if (loggedInAs.isDisplayed()) {
            System.out.println("'Logged in as username' is visible");
        } else {
            System.out.println("'Logged in as username' not visible");
        }

        // 9. Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        // 10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement deleteAccount = driver.findElement(By.tagName("h1"));

        if (deleteAccount.isDisplayed()) {
            System.out.println("'ACCOUNT DELETED!' is visible");
        } else {
            System.out.println("'ACCOUNT DELETED!' is not visible");
        }

    }
}
