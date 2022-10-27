package i16_i12_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

public class Q04 extends TestBaseBeforeAfter {

    @Test
    public void test() {
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        // 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
        driver.findElement(By.xpath("//span[@id='button1']")).click();

        // 3. Açılır metni alın
        String alertText = driver.switchTo().alert().getText();
        System.out.println("alertText = " + alertText);

        // 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
        String expectedAlertText = "I am an alert box!";
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertText, actualAlertText);

        // 5. Açılır pencereyi kabul edin
        driver.switchTo().alert().accept();
    }
}
