package i11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

// 1- Bir Class olusturalim H02
public class H02 extends TestBaseBeforeAfter {

    @Test
    public void test() {
        // 2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        // 3- video’yu gorecek kadar asagi inin
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1200)");

        // 4- videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src=\"https://www.youtube.com/embed/owsfdh4gxyc\"]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        // 5- videoyu calistirdiginizi test edin
        WebElement pauseButton = driver.findElement(By.xpath("//button[@title=\"Pause (k)\"]"));
        Assert.assertTrue("pauseButton is not displayed!", pauseButton.isDisplayed());


    }


}
