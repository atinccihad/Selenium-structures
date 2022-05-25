package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.TestBase;
//C05_MouseActions
public class C05_MouseActions extends TestBase {

    @Test
    public void test(){
        // 1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // 2- "Drag me" butonunu tutup "Drop here" kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement dragElementi=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropAlani=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(dragElementi,dropAlani).perform();

        // 3- "Drop here" yazisi yerine "Dropped!" oldugunu test edin.
        WebElement droppedYazisi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualDroppedYazisi=droppedYazisi.getText();
        String expectedDroppedYazisi="Dropped!";

        Assert.assertEquals(actualDroppedYazisi,expectedDroppedYazisi,"dropped yazisi beklenenden farkli!!");
    }
     @AfterClass
     public void teardown(){driver.close();}
}
