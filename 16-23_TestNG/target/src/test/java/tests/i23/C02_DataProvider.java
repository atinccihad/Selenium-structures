package tests.i23;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentalCars;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_DataProvider extends TestBaseRapor {


    @DataProvider
    public static Object[][] kullanicilar() {
        return new Object[][]{{"cihad@gmail.com","12345"},{"atinc@gmail.com","12344"},{"ahmet@gmail.com","1234"}};
    }

    @Test(dataProvider = "kullanicilar")
    public void testName(String userEmail,String password) {
        BlueRentalCars brc =new BlueRentalCars();

        // https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentAcarUrl"));
        extentTest = extentReports.createTest("Arac Testi", "https://www.bluerentalcars.com/ adresine gidildi");
        // login butonuna bas
        extentTest.info("loginButton clicked.");
        brc.loginButton.click();

        // Data provider ile 3 farklı userEmail ve 3 farklı password girelim
        // login butonuna tiklayin
        extentTest.info("3 loginButton clicked.");
        brc.emailBox.sendKeys(userEmail);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(password).sendKeys(Keys.ENTER).perform();

        // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brc.loginButton.isDisplayed());
        extentTest.pass("brc.loginButton.isDisplayed() testi PASS");
    }
}
