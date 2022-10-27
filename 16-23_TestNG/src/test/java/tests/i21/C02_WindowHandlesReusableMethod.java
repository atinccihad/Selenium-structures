package tests.i21;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;

public class C02_WindowHandlesReusableMethod {

    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.xpath("//a[@href=\"/windows/new\"]")).click();
        // acilan yeni tab'in title'inin "New Window" oldugunu test edin
        ArrayList<String>pencereHandles =new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(pencereHandles.get(1));

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle ="New Window";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void test02() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        //● Click Here butonuna basın.
        ReusableMethods.waitFor(3);
        Driver.getDriver().findElement(By.xpath("//a[@href=\"/windows/new\"]")).click();
        // acilan yeni tab'in title'inin "New Window" oldugunu test edin
        ReusableMethods.switchToWindow("New Window");
        // Driver.closeDriver();
        Driver.quitDriver();
    }
}
