package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

// 1- C06_KeyboardActions
public class C06_KeyboardActions extends TestBase {

    @Test
    public void test(){
        // 2- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        // 3- Arama kutusuna actions methodlarini kullanarak samsung A71 yazdirin ve Enter'a basarak arama yaptirin
        /********ActionsIle****************/
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);

        actions .click(searchBox)
                .sendKeys("samsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER).perform();

        /*actions.click(searchBox).perform();
        actions.sendKeys("samsung ").perform();
        actions.keyDown(Keys.SHIFT).perform();
        actions.sendKeys("a").perform();
        actions.keyUp(Keys.SHIFT).perform();
        actions.sendKeys("71").perform();
        actions.sendKeys(Keys.ENTER).perform();*/

        /* simdiye kadar once locate edip o webelement uzerinden sendKeys yapiyorduk
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("samsung A71"+ Keys.ENTER);*/

        // 4- Aramanin gerceklestigini test edin..
        /*WebElement sonucText=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(sonucText.isDisplayed(),"SonucText is notDisplayed!! aramaGerceklesmedi!!");*/
        String arananKelime="samsung A71";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime),"arama yapilamadi!!");
    }
}
