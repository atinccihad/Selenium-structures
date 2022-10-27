package i02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class H05 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        WebElement signIn = driver.findElement(By.id("sign-in"));
        System.out.println("signIn.getSize() = " + signIn.getSize());
        System.out.println("signIn.getAriaRole() = " + signIn.getAriaRole());
        System.out.println("signIn.getAccessibleName() = " + signIn.getAccessibleName());
        System.out.println("signIn.getAttribute() = " + signIn.getAttribute("id"));
        System.out.println("signIn.getCssValue(color) = " + signIn.getCssValue("color"));

        driver.close();

    }
}
