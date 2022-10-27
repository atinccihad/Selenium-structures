package tests.i16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestNGBeforeClassAfterClass;

public class C04_dependsOnMethod extends TestNGBeforeClassAfterClass {

    @Test
    public void test01() {
        // amazon ana sayfasina gidiniz
        driver.get("https://www.amazon.com");
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //  searchBox'a "Nutella" yazip aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        // Sonuc yazisinin Nutella icerdigini test edelim
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisi = sonucYazisiElementi.getText();
        String beklenenStr = "Nutella";
        Assert.assertTrue(sonucYazisi.contains(beklenenStr), "sonucYazisi " + beklenenStr + " icermiyor!");
    }
}
