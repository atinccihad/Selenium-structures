package tests.practice;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P3_TutorialPage;
import utilities.ConfigReader;
import utilities.Driver;

public class P3_TutorialTest {

    @Test
    public void test(){
        // url'e gidin: "http://tutorialsninja.com/demo/index.php?route=common/home"
        Driver.getDriver().navigate().to(ConfigReader.getProperty("tutorialUrl"));

        P3_TutorialPage p3_tutorialPage=new P3_TutorialPage();

        // Phones & PDAs e tiklayin
        p3_tutorialPage.phonesPDAs.click();

        // telefonlarin marka adini al
        System.out.println("***** goruntulenen isimler *****");
        for (WebElement each:p3_tutorialPage.products) {
            System.out.println(each.getText());
        }

        // tüm elemanlar icin ekle dugmesine tiklayin
        p3_tutorialPage.addAllCart.stream().forEach(x-> x.click());

        // siyah toplam eklenen sepet dugmesine tiklayin
        p3_tutorialPage.clickBlackButton.click();

        // listenin isimlerini sepetten al
        System.out.println("***** sepetteki isimler *****");
        for (WebElement each:p3_tutorialPage.sepetList) {
            System.out.println(each.getText());
        }

        // goruntulenen listeden ve sepet listesinden isimleri karsilastirin
        Assert.assertEquals(p3_tutorialPage.products,p3_tutorialPage.sepetList);

        // goruntulenen listede toplam fiyatin $583.19 oldugunu test edin
        Assert.assertEquals(p3_tutorialPage.totalPrice.getText(),"$583.19");

    }
}
