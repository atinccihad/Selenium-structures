package i12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // http://automationexercise.com sitesine gidelim
        driver.get("https://automationexercise.com");

        // Product bolumune girelim
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // belirli urune tiklayalim.
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,2000)");
        WebElement firstElement = driver.findElement(By.xpath("(//div[@class='choose'])[7]"));
        actions.moveToElement(firstElement).click().perform();
    }
}
