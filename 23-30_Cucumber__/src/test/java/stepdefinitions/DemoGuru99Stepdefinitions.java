package stepdefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import pages.DemoGuruPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class DemoGuru99Stepdefinitions {

    DemoGuruPage demoGuruPage = new DemoGuruPage();

    @Given("{string}, sutunundaki tum degerleri yazdirir")
    public void sutunundaki_tum_degerleri_yazdirir(String istenenBaslikStr) {
        //demoGuruPage.cookiesKabulEtButonu.click();

        List<WebElement> baslikWebelementListesi = demoGuruPage.baslikWebelementListesi;

        List<String> baslikStringListesi = ReusableMethods.getElementsText(baslikWebelementListesi);

        int istenenSutunIndexi = baslikStringListesi.indexOf(istenenBaslikStr);
        //    //tbody//tr//td[3]

        List<WebElement> istenenSutunWebelementListesi = demoGuruPage.sutunListesiGetir(istenenSutunIndexi);

        List<String> istenenSutunStrList = ReusableMethods.getElementsText(istenenSutunWebelementListesi);

        System.out.println(istenenBaslikStr + " Sutunundaki elementler \n" + istenenSutunStrList);

    }

}
