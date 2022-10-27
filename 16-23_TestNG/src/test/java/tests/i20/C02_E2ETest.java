package tests.i20;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HMCPage;
import utilities.ConfigReader;
import utilities.Driver;
// Bir class olusturun: C02_E2ETest
public class C02_E2ETest {

    // Bir metod olusturun: E2ETest()
    @Test
    public void E2ETest() throws InterruptedException {

        // https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HMCPage hmcPage = new HMCPage();
        hmcPage.logInButton.click();

        // Username textbox ve password metin kutularını locate edin ve asagidaki verileri
        // Username : manager
        // Password  : Manager1!
        //Login butonuna tıklayın.
        hmcPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCUsername"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("HMCPassword"))
                .sendKeys(Keys.TAB)
                .click(hmcPage.logInButton2)
                .perform();

        // Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        hmcPage.hotelmanagementButton.click();
        Thread.sleep(2000);
        hmcPage.roomreservationButton.click();
        Thread.sleep(2000);
        hmcPage.addRoomReservationButton.click();

        //  Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Faker faker = new Faker();

        hmcPage.selectUserDropdown.sendKeys(("customerservice"));
        actions.sendKeys(Keys.TAB).perform();
        hmcPage.hotelroomDropdown.sendKeys("T1");
        actions.sendKeys(Keys.TAB).perform();
        hmcPage.priceBox.sendKeys("555");
        actions.sendKeys(Keys.TAB).perform();
        hmcPage.dateStart.sendKeys("10/29/2022");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        hmcPage.dateEnd.sendKeys("04/27/2023");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        hmcPage.defaultAmount.sendKeys("4");
        actions.sendKeys(Keys.TAB).perform();
        hmcPage.childrenAmount.sendKeys("5");
        actions.sendKeys(Keys.TAB).perform();
        hmcPage.contactNameSurname.sendKeys(faker.name().fullName());
        actions.sendKeys(Keys.TAB).perform();
        hmcPage.contactPhone.sendKeys(faker.phoneNumber().cellPhone());
        actions.sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).perform();
        actions.sendKeys(Keys.TAB).sendKeys("notes").sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .perform();
        // Save butonuna tıklayın.
        hmcPage.saveButton.click();
        Thread.sleep(3000);

        // “RoomReservation was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(hmcPage.successText.isDisplayed(), "successText is not displayed!");
        Thread.sleep(3000);

        //OK butonuna tıklayın.
        hmcPage.okButton.click();

    }
}
