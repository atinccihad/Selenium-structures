package i13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;


public class H01 extends TestBaseBeforeAfter {

    int satir = 3;
    int sutun = 4;

    @Test
    public void test01() {
        // Bir onceki class'taki adrese gidelim
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        // login() methodunu kullanarak sayfaya giris yapalim
        login();
        // input olarak verilen satir ve sutun sayisina sahip cell'deki texti yazdiralim.
        List<WebElement> satirList = driver.findElements(By.xpath("//tbody//tr"));
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));

        System.out.println(satirList.get(satir).getText());
        System.out.println(sutunSayisi.get(sutun).getText());


    }

    public void login() {

        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
