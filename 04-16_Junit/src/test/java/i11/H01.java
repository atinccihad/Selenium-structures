package i11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

// Yeni Class olusturun H01
public class H01 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        // 3- Link 1" e tiklayin
        Actions actions = new Actions(driver);
        WebElement coverMeFirst = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        actions.moveToElement(coverMeFirst).click(driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"))).perform();

        // 4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6- “Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.xpath("//p[text()='Click and Hold!']"))).perform();

        // 7- “Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement wellDoneText = driver.findElement(By.xpath("//div[text()='Well done! keep holding that click now.....']"));
        System.out.println("wellDoneText = " + wellDoneText.getText());

        // 8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMe = driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
        actions.doubleClick(doubleClickMe).perform();

    }
}
