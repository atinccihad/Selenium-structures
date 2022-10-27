package tests.i21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TutorialsninjaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class P3_TutorialTest {

    TutorialsninjaPage tutorialsninjaPage;
    @Test
    public void test() throws InterruptedException {
        tutorialsninjaPage=new TutorialsninjaPage();

        // url'e gidin "http://tutorialsninja.com/demo/index.php?route=common/home"
        Driver.getDriver().get(ConfigReader.getProperty("tutorialsninjaUrl"));

        // Phones & PDAs e tiklayin
        tutorialsninjaPage.phonesPdaButton.click();

        // Telefonlarin marka adini al
        System.out.println("**Telefon markalari**");
        for (int i = 0; i < tutorialsninjaPage.brandOfPhones.size(); i++) {
            System.out.println(i+".telefon: "+tutorialsninjaPage.brandOfPhones.get(i).getText());
        }
        // Tum elemanlar icin ekle dugmesine tiklayin
        for (WebElement each:tutorialsninjaPage.addToCartButtons) {
            each.click();
        }
        // Siyah toplam eklenen sepet dugmesine tiklayin
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@class=\"btn-group btn-block\"]"))).perform();
        actions.click(Driver.getDriver().findElement(By.xpath("//div[@class=\"btn-group btn-block\"]"))).perform();

       // tutorialsninjaPage.clickBlackButton.click();

        // Listenin isimlerini sepetten al
        for (WebElement each:tutorialsninjaPage.sepetListesi) {
            System.out.println(each.getText());
        }
        // Goruntulenen listeden ve sepet listesinden isimleri karsilastirin
        Assert.assertNotEquals(tutorialsninjaPage.sepetListesi,tutorialsninjaPage.brandOfPhones);

        // Goruntulenen listede toplam fiyatin $583.19 oldugunu test edin
        Assert.assertEquals(tutorialsninjaPage.totalPrice.getText(),ConfigReader.getProperty("beklenenFiyat"));
    }
}
