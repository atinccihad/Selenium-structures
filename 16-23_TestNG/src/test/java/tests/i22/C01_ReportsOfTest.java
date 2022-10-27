package tests.i22;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCars;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_ReportsOfTest extends TestBaseRapor {

    @Test
    public void testBlueRentalCars() {
        extentTest = extentReports.createTest("Arac Testi", "Masserati secimi dogrulandi");
        BlueRentalCars brc = new BlueRentalCars();

        // -https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentAcarUrl"));
        extentTest.info("Blue rent a car sitesine gidildi.");
        // -login butonuna bas
        brc.loginButton.click();
        extentTest.info("Blue rent a car login butonuna basildi.");
        // -test data user email: customer@bluerentalcars.com ,
        // -test data password : 12345 dataları girip login e basın
        // -login butonuna tiklayin
        brc.emailBox.sendKeys(ConfigReader.getProperty("blueRentAcarEmail") + Keys.ENTER);
        brc.paswordBox.sendKeys(ConfigReader.getProperty("blueRentAcarPassword") + Keys.ENTER);
        brc.loginButton.click();

        // -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(brc.text.isDisplayed());
        extentTest.info("Blue rent a car sitesinde login basarili.");
        // Masserati markasini seciniz
        Select select = new Select(brc.carMarka);
        select.selectByVisibleText("Maserati");
        // Masserati markasini secildigini test ediniz
        Assert.assertTrue(brc.maseratiSecimi.isDisplayed());
        extentTest.info("Blue rent a car sitesinde Masserati secimi basarili.");
        // Il ilce secimi tarih yapiniz
        brc.il.sendKeys("izmir");
        brc.ilce.sendKeys("urla" + Keys.TAB + "12" + Keys.TAB + "03" + Keys.TAB + "1988" + Keys.TAB + "00" + Keys.TAB + "00" + Keys.TAB + "00" + Keys.TAB + "12" + Keys.TAB + "03" + Keys.TAB + "1988" + Keys.TAB + "00" + Keys.TAB + "00" + Keys.TAB + "00" + Keys.TAB + Keys.ENTER);

        extentTest.pass("Reservation testi PASS");

    }


}
