package tests.day12;

import com.github.dockerjava.core.exec.WaitContainerCmdExec;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C02_MouseActions extends TestBase {
    // amazon ana sayfaya gidin sagUstte Hello, Signin elementinin
    // uzerinde mouse'u bekletin
    // acilan menu'de new list linkine tiklayin
    // ve new list sayfasinin acildigini test edin
    @Test
    public void amazonList() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        Actions actions=new Actions(driver);
        WebElement helloelement=driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
        actions.moveToElement(helloelement).perform();

        WebElement listElementi=driver.findElement(By.xpath("//span[text()='Create a List']"));
        actions.click(listElementi).perform();

        String actualtitle=driver.getTitle();
        String arananMetin="Your List";

        Assert.assertTrue(actualtitle.contains(arananMetin));

        //*********************  SoftAssert  ile    ******************************
       /*
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualtitle.contains(arananMetin));

        softAssert.assertAll();
        */
        Thread.sleep(3000);
    }
}
