package i12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class H01 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // test01
        // "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOverMeFirst).perform();

        // "Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();

        // Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        // Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // "Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHold).perform();

        // "Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement clickAndHoldCikanYazi = driver.findElement(By.xpath("//div[text()='Well done! keep holding that click now.....']"));
        System.out.println(clickAndHoldCikanYazi.getText());

        // "Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//h2[text()='Double Click Me!']"))).perform();
    }


}
