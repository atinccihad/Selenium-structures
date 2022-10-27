package tests.i17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebappsecurityPage;
import utilities.Driver;
import utilities.TestNGBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.List;

//Yeni bir Class Olusturun : H01
public class H01 {

    @Test
    public void test() {
        //“http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");
        ZeroWebappsecurityPage zeroWebappsecurityPage = new ZeroWebappsecurityPage();

        //Sign in butonuna basin
        zeroWebappsecurityPage.signInButton.click();

        //Login kutusuna “username” yazin
        zeroWebappsecurityPage.usernameBox.sendKeys("username");
        //Password kutusuna “password” yazin
        zeroWebappsecurityPage.passwordBox.sendKeys("password");

        //Sign in tusuna basin
        zeroWebappsecurityPage.signInButton2.click();
        Driver.getDriver().navigate().back();

        //Online banking menusu icinde Pay Bills sayfasina gidin
        zeroWebappsecurityPage.onlineBankingButton.click();

        //“Purchase Foreign Currency” tusuna basin
        zeroWebappsecurityPage.payBillsButton.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.click(zeroWebappsecurityPage.purchaseForeignCurrency).perform();


        //“Currency” drop down menusunden Eurozone’u secin
        Select select = new Select(zeroWebappsecurityPage.currencyDropdownElementi);
        select.selectByVisibleText(zeroWebappsecurityPage.dropdownEurozoneElementi.getText());

        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(zeroWebappsecurityPage.dropdownEurozoneElementi.isDisplayed(), "Eurozone (Euro)    elementi is not displayed!");
        softAssert.assertAll();

        //soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
        // "China  (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        // "Hong Kong  (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
        // "New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)",
        // "Thailand (baht)"
        softAssert = new SoftAssert();

        List<WebElement> dropdownList = Driver.getDriver().findElements(By.xpath("//select//option"));
        List<String> actualDropdownListStr = new ArrayList<>();

        for (WebElement each : dropdownList) {
            actualDropdownListStr.add(each.getText());
        }

        String[] expectedArr = {"Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)",
                "China  (yuan)", "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)",
                "Hong Kong  (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)",
                "New Zealand  (dollar)", "Sweden (krona)", "Singapore (dollar)",
                "Thailand (baht)"};
        List<String> expectedList = new ArrayList<>();
        for (String each : expectedArr) {
            expectedList.add(each);
        }

        softAssert.assertEquals(actualDropdownListStr, expectedList);


    }


}
