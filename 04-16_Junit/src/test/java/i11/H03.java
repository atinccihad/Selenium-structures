package i11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class H03 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //-  amazon a gidin
        driver.get("https://www.amazon.com/");

        // Test01
        // 1- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        List<WebElement> dropdownList = driver.findElements(By.xpath("//option"));
        for (int i = 0; i < dropdownList.size(); i++) {
            System.out.println(dropdownList.get(i).getText());
        }

        // 2- dropdown menude 40 eleman olduğunu doğrulayın
        int expectedSize = 40;
        int actualSize = dropdownList.size();
        Assert.assertNotEquals("dropdown menudeki eleman sayisi 40'dan farkli!", expectedSize, actualSize);

        // Test02
        // 1- dropdown menuden elektronik bölümü seçin
        for (int i = 0; i < dropdownList.size(); i++) {
            if (dropdownList.get(i).getText().equals("Electronics")) {
                dropdownList.get(i).click();
                break;
            }
        }

        // 2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER);
        WebElement sonucYazisiWE = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiString = sonucYazisiWE.getText();
        String[] sonucSayisiArr = sonucYazisiString.split(" ");
        String sonucSayisiStr = sonucSayisiArr[2];
        int sonucSayisi = Integer.parseInt(sonucSayisiStr);
        System.out.println("sonucSayisi = " + sonucSayisi);

        // 3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue("sonuc sayisi bildiren yazi, iphone icermiyor!", sonucYazisiString.contains("iphone"));

        // 4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement rightOfIphone = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[5]"));
        WebElement leftOfIphone = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        By searchInPhone = RelativeLocator.with(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[4]")).toRightOf(rightOfIphone).toLeftOf(leftOfIphone);

        // 5- ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[4]")).click();
        WebElement urunTitle = driver.findElement(By.xpath("//span[@id='productTitle']"));
        WebElement urunFiyat = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']"));

        driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();

    }


}
