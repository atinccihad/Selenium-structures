package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.util.Set;
// 1- class olusturun: C03_MouseActions
public class C03_MouseActions extends TestBase{
   @Test
    public void test01(){
       // 2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
       driver.get("https://the-internet.herokuapp.com/context_menu");

       // 3- Cizili olan uzerine sag click yapalim
       Actions actions=new Actions(driver);
      WebElement ciziliElement=driver.findElement(By.xpath("//div[@id='hot-spot']"));
      actions.contextClick(ciziliElement).perform();

      // 4- Alert'te cikan yazinin "You selected a context menu" oldugunu
       // test edelim
       String expectedYazi="You selected a context menu";
       String actualYazi=driver.switchTo().alert().getText();

       Assert.assertEquals(actualYazi,expectedYazi,"alert yazisi beklenenden farkli!!");

       // 5- Tamam diyerek alert'i kapatalim
       driver.switchTo().alert().accept();

       // 6- Elemental Selenium linkine tiklayalim
       String ilkSayfaHandle=driver.getWindowHandle();
       driver.findElement(By.linkText("Elemental Selenium")).click();

       // 7- Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim.
       Set<String> windowTumHandleLar=driver.getWindowHandles();

       String ikinciSayfaHandle="";

       for (String each:windowTumHandleLar){
           if (!each.equals(ilkSayfaHandle)){
               ikinciSayfaHandle=each;
           }
       }
       driver.switchTo().window(ikinciSayfaHandle);
       String expectedIkinciSayfaYazi="Elemental Selenium";
       String actualIkinciSayfaYazi=driver.findElement(By.tagName("h1")).getText();

       Assert.assertEquals(actualIkinciSayfaYazi,expectedIkinciSayfaYazi,"ikinci sayfadaki yazi istenenden farkli!!");
       }
   }



