package tests.day13;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;
//  C07_ActionsClassHW
public class C07_ActionsClassHW extends TestBase {
    @Test
    public void test() throws InterruptedException {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- "Hover over Me First" kutusunun ustune gelin
        WebElement hoverBox=driver.findElement(By.xpath("//div[@class='dropdown hover']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverBox).perform();
        Thread.sleep(2000);

        // 3- "Link 1" e tiklayin
        WebElement link1Box=driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        actions.click(link1Box).perform();

        // 4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(5000);

        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6- "Click and hold" tusuna basili tutun
        WebElement clickBox=driver.findElement(By.xpath("//div[@id='click-box']"));
        clickBox.click();

        // 7- "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickBox.getText());

        // 8- "Double click me" butonunu cift tiklayin.
        WebElement doubleClickMe=driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClickMe).perform();
    }
}
