package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HMCPage;

public class HotelMyCampStepDefinitions {
    HMCPage hmcPage=new HMCPage();

    @Given("login linline tiklar")
    public void login_linkine_tiklar(){
        hmcPage.mainPageLoginLinki.click();
    }

    @Then("kullanici adi olarak {string} girer")
    public void kullanici_adi_olarak_girer(String kullaniciTipi){

    }

    @Then("password olarak {string} girer")
    public void password_olarak_girer(String string){

    }

    @Then("login butonuna basar")
    public void login_butonuna_basar(){

    }

    @Then("basarili olarak giris yapildigini test eder")
    public void basarili_olarak_giris_yapildigini_test_eder(){

    }

}
