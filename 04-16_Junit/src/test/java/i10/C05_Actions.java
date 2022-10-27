package i10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

// Yeni bir class olusturalim: C05_Actions
public class C05_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01() throws InterruptedException {
        // https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.dragAndDrop(dragMe, dropHere).perform();

        // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement text = driver.findElement(By.xpath("(//p[text()='Drop here'])[1]"));
        WebElement newText = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String strText = text.getText();
        String strNewText = newText.getText();

        Assert.assertNotEquals("strText, strNewText'e  esit!", strNewText, strText);
        Assert.assertTrue("Drop here, Dropped!  OLMADI! ", strNewText.equals("Dropped!"));


    }


}
