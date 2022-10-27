package tests.i21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoGuruPage;
import pages.HepsiburadaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class P1_DemoGuruTest {

    Actions actions;
    DemoGuruPage demoGuruPage;

    @Test
    public void demoGuruTest() throws InterruptedException {
        // http://demo.guru99.com/test/drag_drop.html  url e git
        Driver.getDriver().get(ConfigReader.getProperty("demoGuruUrl"));

        // DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        actions = new Actions(Driver.getDriver());

        demoGuruPage = new DemoGuruPage();
        // CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        // DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        // CREDIT SIDE da Amount bolumune ise ikinci 5000 butonunu surukle ve birak
        actions.dragAndDrop(demoGuruPage.bankButton, demoGuruPage.accountDebitSide)
                .dragAndDrop(demoGuruPage.salesButton, demoGuruPage.accountCreditSide)
                .dragAndDrop(demoGuruPage.first5000Button, demoGuruPage.amountDebitSide)
                .dragAndDrop(demoGuruPage.second5000Button, demoGuruPage.amountCreditSide)
                .sendKeys(Keys.PAGE_DOWN).perform();
        // Perfect butonunun goruntulendigini dogrulayin
        Assert.assertTrue(demoGuruPage.perfect.isDisplayed());

    }

}
