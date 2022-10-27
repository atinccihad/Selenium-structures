package tests.i21;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q01 {

    @Test
    public void test01() throws InterruptedException {
        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");
        // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
        WebUniversityPage webUniversityPage = new WebUniversityPage();

        //Buradaki listeyi yapılacaklar listesine tek tek manuel olarak eklemek yerine toplu olarak bir loop kullanarak gönderebilmek
        //amacı ile biz olusturduk
        List<String> workList = new ArrayList<>(Arrays
                .asList("Kahvaltıyı hazırla"
                        , "Bulaşıkları yıka"
                        , "Bebekle ilgilen"
                        , "Çocuğunun ödevine yardım et"
                        , "Selenyum çalış"
                        , "Uyu"));
        Actions actions = new Actions(Driver.getDriver());
        for (String w : workList) {
            actions.click(webUniversityPage.addNewToDoBox)
                    .sendKeys(w)
                    .sendKeys(Keys.ENTER)
                    .perform();
        }
        //Tüm yapılacakların üzerini çiz.
        List<WebElement> todos = webUniversityPage.todosWebelement;
        for (WebElement w : todos) {
            w.click();
        }
        //Tüm yapılacakları sil.
        List<WebElement> deleteButtonsWE = webUniversityPage.deleteButtonsWE;
        for (WebElement w : deleteButtonsWE) {
            w.click();
        }
        Thread.sleep(3000);
        //Tüm yapılacakların silindiğini doğrulayın.
        List<WebElement> newtodos = webUniversityPage.newTodosWebelement;
        Assert.assertTrue(newtodos.size() == 0);
    }
}
