package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.FillDetailsPage;
import utilities.Driver;

public class FillDetailsStepDefs {
    FillDetailsPage fillDetailsPage =new FillDetailsPage();

    //steps


    @Then("kullanici ayrintilari \\(birinci bolum) doldurur")
    public void kullanici_ayrintilari_birinci_bolum_doldurur() {
        fillDetailsPage.genderBox.click();
        fillDetailsPage.passwordBox.sendKeys("123456");
        Driver.selectByIndex(fillDetailsPage.dayDropdown,4);
        Driver.selectByIndex(fillDetailsPage.monthDropdown,5);
        Driver.selectByIndex(fillDetailsPage.yearDropdown, 25);
    }
    @Then("kullanici Sign up for our newsletter! checkbox ini secer")
    public void kullanici_sign_up_for_our_newsletter_checkbox_ini_secer() {
        fillDetailsPage.newsletterSignupBox.click();

    }
    @Then("kullanici Receive special offers from our partners! checkbox ini secer")
    public void kullanici_receive_special_offers_from_our_partners_checkbox_ini_secer() {
        fillDetailsPage.specialOfferBox.click();
    }
    @Then("kullanici ayrintilari \\(ikinci bolum) doldurur")
    public void kullanici_ayrintilari_ikinci_bolum_doldurur() {
        fillDetailsPage.firstNameBox.sendKeys("mehmet");
        fillDetailsPage.lastNameBox.sendKeys(Faker.instance().name().lastName());
        fillDetailsPage.companyBox.sendKeys("techproeducation");
        fillDetailsPage.addressBox.sendKeys(Faker.instance().address().fullAddress());
        Driver.selectByIndex(fillDetailsPage.countryDropdown,2);
        fillDetailsPage.stateBox.sendKeys(Faker.instance().address().state());
        fillDetailsPage.cityBox.sendKeys(Faker.instance().address().city());
        fillDetailsPage.zipcodeBox.sendKeys(Faker.instance().address().zipCode());
        fillDetailsPage.mobileNumberBox.sendKeys(Faker.instance().phoneNumber().cellPhone());
    }
    @Then("kullanici Create Account butonuna tiklar")
    public void kullanici_create_account_butonuna_tiklar() {

        fillDetailsPage.createAccountButton.click();

    }
    @Then("kullanici hesabin olustugunu dogrular")
    public void kullanici_hesabin_olustugunu_dogrular() {
        Assert.assertTrue(fillDetailsPage.accountCreatedText.isDisplayed());
    }


}
