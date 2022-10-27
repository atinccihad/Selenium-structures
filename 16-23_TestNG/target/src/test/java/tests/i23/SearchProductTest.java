package tests.i23;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class SearchProductTest extends TestBaseRapor {

    AutomationExercisePage automationExercisePage;

    @Test
    public void automationExercise() {
        extentTest=extentReports.createTest("automationexcercise","Web automation");
        // 1. Tarayıcıyı başlat
        // 2. 'http://automationexercise.com' url'sine gidin
        extentTest.info("1. Tarayıcıyı başlat\n" +
                "2. 'http://automationexercise.com' url'sine gidin");
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));

        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        extentTest.info("3. Ana sayfanın başarıyla görünür olduğunu doğrulayın");
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Url eslesmiyor!");

        // 4. 'Ürünler' butonuna tıklayın
        extentTest.info("4. 'Ürünler' butonuna tıklayın");
        automationExercisePage = new AutomationExercisePage();
        automationExercisePage.productsButton.click();

        // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        extentTest.info("5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın");
        Assert.assertTrue(automationExercisePage.allProducts.isDisplayed(), "allProducts is not displayed");

        // 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
        extentTest.info("6. Arama girişine ürün adını girin ve ara düğmesine tıklayın");
        automationExercisePage.searchProductBox.sendKeys("Men Tshirt");
        automationExercisePage.searchProductButton.click();

        // 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
        extentTest.info("7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın");
        Assert.assertTrue(automationExercisePage.arananUrunProduct.isDisplayed(), "arananUrun is not displayed!");

        // 8. Aramayla ilgili ürünün ("blue top")  olmadigini doğrulayın
        extentTest.info("8. Aramayla ilgili ürünün (\"blue top\")  olmadigini doğrulayın");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        String urunAdi = automationExercisePage.arananUrunProduct.getText();
        String expectedUrunAdi = "blue top";
        Assert.assertNotEquals(urunAdi, expectedUrunAdi);

    }
}
