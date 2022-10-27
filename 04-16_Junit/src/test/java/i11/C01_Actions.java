package i11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

//Bir Class olusturalim C01_Actions
public class C01_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01() {

        // https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        // Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchBox)
                .sendKeys("s")
                .sendKeys("a")
                .sendKeys("m")
                .sendKeys("s")
                .sendKeys("u")
                .sendKeys("n")
                .sendKeys("g")
                .sendKeys(" ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("7")
                .sendKeys("1")
                .sendKeys(Keys.ENTER)
                .perform();

        // aramanin gerceklestigini test edin
        WebElement aramaSonucu = driver.findElement(By.xpath("//span[text()='1-16 of 99 results for']"));
        Assert.assertTrue(aramaSonucu.isDisplayed());
    }
}
