package tests.crossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseCross;

import java.util.Set;

public class C03_Windowhandle extends TestBaseCross {
    @Test
    public void windowHandleTest(){
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement sayfadakiYaziElementi=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(sayfadakiYaziElementi.getText(),"Opening a new window","sayfadaki .....");

        softAssert.assertEquals(driver.getTitle(),"The Internet","sayfa title'i beklenenden farkli");

        String windowHandleDegeri1=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        Set<String> hadleDegerleriSeti=driver.getWindowHandles();
        String windowHandleDegeri2="";

        for (String each:hadleDegerleriSeti){
            if (!each.equals(windowHandleDegeri1)){
                windowHandleDegeri2=each;
            }
        }
        driver.switchTo().window(windowHandleDegeri2);
        softAssert.assertEquals(driver.getTitle(),"New Window","yeni sayfa title'i istenenden farkli");

        WebElement ikinciSayfadakiYaziElementi=driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(ikinciSayfadakiYaziElementi.getText(),"New Window","Ikinci sayfadaki .....");

        driver.switchTo().window(windowHandleDegeri1);
        softAssert.assertEquals(driver.getTitle(),"The Internet","ilk sayfanin titli'i beklenen gibi degil");

        softAssert.assertAll();
    }

}
