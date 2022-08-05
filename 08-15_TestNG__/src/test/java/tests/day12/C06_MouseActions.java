package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

//C06_MouseActions
public class C06_MouseActions extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // 1- https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");

        // 2- Sag ust bolumde bulunan "Account & Lists" menusunun acilmasi icin mouse'u bu menunun ustune getirelim
        WebElement signIn=driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(signIn).perform();
        Thread.sleep(4000);

        // 3- "Create a list" butonuna basalim
        driver.findElement(By.xpath("//span[.='Create a List']")).click();

        // 4- Acilan sayfada "Your Lists" yazisi oldugunu test edelim.
        WebElement yaziElementi=driver.findElement(By.xpath("//div[@aria-level='1']"));
        Assert.assertTrue(yaziElementi.isEnabled());
    }
}
