package i03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class H02 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //"//https://the-internet.herokuapp.com adresine gidin
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
        // Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        // Delete butonunun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if (deleteButonu.isDisplayed()) {
            System.out.println("deleteButonu Pass");
        } else {
            System.out.println("deleteButonu Failed");
        }

        // delete tusuna basin
        deleteButonu.click();
        // "Add/Remove Elements" yazisinin gorunur oldugunu test edin
        WebElement addRemove = driver.findElement(By.xpath("//h3['Add/Remove Elements']"));

        if (addRemove.isDisplayed()) {
            System.out.println("addRemove Pass");
        } else {
            System.out.println("addRemove Failed");
        }
        // driverClose
        driver.close();
    }
}
