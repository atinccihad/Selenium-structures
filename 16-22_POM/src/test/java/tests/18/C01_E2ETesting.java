package tests.i18;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_E2ETesting {
    @Test
    public void test01(){
        // 2. Bir method  olusturun: createHotel
        // 3. https://www.hotelmycamp.com  adresine git.
        // 4. Username tectbox ve password metin kutularini locate edin ve asagidaki verileri girin.
        //    a. Username : manager
        //    b. Password : Manager1!
        // 5. Login butonuna tiklayin.
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        // 6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        hotelMyCampPage.bekle(3);
        hotelMyCampPage.hotelManagementLinki.click();
        hotelMyCampPage.hotelListLinki.click();
        hotelMyCampPage.addHotelLinki.click();
        // 7. Acilan sayfadaki tum metin kutularina istediginiz verileri girin.
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        actions.click(hotelMyCampPage.addHotelCodeKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        Select select=new Select(hotelMyCampPage.addHotelDropdown);
        select.selectByVisibleText("Hotel Type2");

        // 8. Save butonuna tiklayim.
        hotelMyCampPage.addHotelSaveButonu.click();
        hotelMyCampPage.bekle(2);

        // 9. "Hotel was inserted successfully" textinin gorundugunu test edin.
        Assert.assertTrue(hotelMyCampPage.hotelWasInsertedSuccessfullyAlertYazisi.isDisplayed());

        // 10. OK butonuna tiklayin.
        Driver.getDriver().switchTo().activeElement().click();
    }
}
