package i09_i04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_LoginTest extends TestBaseBeforeAfter {

    @Test
    public void test01(){
        // 1- https://www.koalaresorthotels.com/ sayfasina gidiniz
        driver.get("https://www.koalaresorthotels.com/");

        // 2- click to login button
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//input[@class='form-control required']")).sendKeys("");
        actions.sendKeys(Keys.TAB).perform();
        driver.findElement(By.xpath("//input[@class='form-control required password']")).sendKeys("");
        actions.sendKeys(Keys.TAB).perform();
        driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();

    }

}
