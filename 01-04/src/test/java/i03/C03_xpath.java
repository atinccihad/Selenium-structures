package i03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_xpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- https://the-internet.herokuapp.com/add_reemove_elements/  adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

        // 3- Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if (deleteButton.isDisplayed()) {
            System.out.println("delete button is displayed");
        } else {
            System.out.println("delete button not displayed");
        }
        // 4- Delete tusuna basin
        deleteButton.click();

        // 5- "Add/Remove Elements" yazisinin gorunur oldugunu test edin
        WebElement removeElements = driver.findElement(By.tagName("h3"));
        if (removeElements.isDisplayed()) {
            System.out.println("Add/Remove Elements  text testi PASS");
        } else {
            System.out.println("Add/Remove Elements  text testi FAILED");
        }

        // 6- driver close
        driver.close();
    }
}
