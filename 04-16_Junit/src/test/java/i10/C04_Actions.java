package i10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

// Yeni bir class olusturalim: C04_Actions
public class C04_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();

        // Alert’te cikan yazinin “You selected a context menu” oldugunu
        String alertText = driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assert.assertEquals("text 'You selected a context menu' degil!", expectedText, alertText);

        // test edelim.
        // Tamam diyerek alert’i kapatalim
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        // Elemental Selenium linkine tiklayalim
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        actions.perform();
        elementalSelenium.click();

        List<String> windowlist = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));

        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String actualTag = driver.findElement(By.xpath("//h1")).getText();
        String expectedTag = "Elemental Selenium";
        Assert.assertTrue("Elemental Selenium yazmiyor!", actualTag.contains(expectedTag));

    }

}
