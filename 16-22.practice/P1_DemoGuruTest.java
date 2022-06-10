package tests.practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P1_DemoGuruPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class P1_DemoGuruTest {
    // http://demo.guru99.com/test/drag_drop.html  url e git
    // DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
    // CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
    // DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
    // CREDIT SIDE da Amount bolumune ise ikinci 5000 butonunu surukle ve birak
    // Perfect butonunun goruntulendigini dogrulayin

    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("DemoGuruUrl"));

        Actions actions=new Actions(Driver.getDriver());

        P1_DemoGuruPage p1_demoGuruPage=new P1_DemoGuruPage();

        actions.dragAndDrop(p1_demoGuruPage.bankButonu,p1_demoGuruPage.debitsideAccount).
                dragAndDrop(p1_demoGuruPage.salesButonu,p1_demoGuruPage.creditSideAccount).
                dragAndDrop(p1_demoGuruPage.firstnum5000Butonu,p1_demoGuruPage.debitsideAmount).
                dragAndDrop(p1_demoGuruPage.secondnum5000Butonu,p1_demoGuruPage.creditsideAmount).
                sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(p1_demoGuruPage.perfectYazisi.isDisplayed());
        ReusableMethods.waitFor(4);
    }
}
