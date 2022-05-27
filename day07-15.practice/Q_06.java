package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_06 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // web sitesini maximize yapin
        driver.manage().window().maximize();

        // ikinci emojiye tiklayin
        /*     1. yol           */
        /*  driver.switchTo().frame("emoojis");    */

        /*     2. yol           */
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);

        WebElement secondEmoji=driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        secondEmoji.click();

        // tüm ikinci emoji ogelerini tiklayin
        List<WebElement>emojiOgeler=driver.findElements(By.xpath("//div[@id='nature']/div/img"));

        for (WebElement w:emojiOgeler) {
            w.click();
        }
        // emojiOgeler.stream().forEach(x->x.click());   ==> yukaridaki for each yerine bu lambda satiri a kullanilabilir.
        System.out.println("ogeler tiklandi..");

        // parent iframe e geri donun
        driver.switchTo().defaultContent();

        // formu doldurun, (istediginiz metinlerle)
        List<WebElement>metinGirList=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String>metinler=new ArrayList<>(Arrays.asList("Bir","iframe","sorusu","bu","kadar","eglenceli","olabilir","sizce de","oyle degil mi?","",""));

        for (int i = 0; i <metinGirList.size() ; i++) {
            metinGirList.get(i).sendKeys(metinler.get(i));
        }
        Thread.sleep(4000);

        // apply butonuna basin
        driver.findElement(By.xpath("//button[@id='send']")).click();


    }

}
