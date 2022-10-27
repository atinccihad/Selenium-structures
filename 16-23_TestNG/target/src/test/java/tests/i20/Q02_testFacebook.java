package tests.i20;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Q02_testFacebook {

    @Test
    public void testFacebook() throws InterruptedException {
        // https://www.facebook.com/ adresine gidin
        FacebookPage facebookPage = new FacebookPage();
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        // Giris bilgilerini girip ,login butonuna basiniz
        facebookPage.emailOrNumberBox.sendKeys("5555021235");
        facebookPage.passwordBox.sendKeys("456");
        facebookPage.loginButton.click();
        // Arama butonuna tiklayip "Ahmet" yazip aratiniz
        Thread.sleep(4000);

        ReusableMethods.jsExecutorClick(facebookPage.searchButton);
        facebookPage.searchBox.sendKeys("Ahmet",Keys.ENTER);


    }
}
