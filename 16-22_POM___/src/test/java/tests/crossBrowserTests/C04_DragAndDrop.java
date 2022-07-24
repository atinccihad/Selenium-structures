package tests.crossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C04_DragAndDrop extends TestBaseCross {

    @Test
    public void test01() throws InterruptedException{
        driver.get("https://demoqa.com/droppable");

        Actions actions=new Actions(driver);
        WebElement tasinacakElement=driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement tasinacakHedefElement=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(tasinacakElement,tasinacakHedefElement).perform();

        String actualDroppedYazisi=tasinacakHedefElement.getText();
        String expectedDroppedYazisi="Dropped!";

        Assert.assertEquals(actualDroppedYazisi,expectedDroppedYazisi);

        Thread.sleep(7000);
    }
}
