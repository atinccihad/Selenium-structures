package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_Actions extends TestBase {

    @Test
    public void test() throws InterruptedException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // nutella icin arama yapin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("nutella"+ Keys.ENTER);
        // 9. urunu tiklayin
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[9]")).click();
    }
}
