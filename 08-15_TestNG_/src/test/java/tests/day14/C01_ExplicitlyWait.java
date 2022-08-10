package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.time.Duration;
// 1- C02_ExplicitlyWait
public class C01_ExplicitlyWait extends TestBase {
    // 2- Iki tane method olusturun: implicitlyWait(), explicitWait()
    //    Iki method icin asagidaki adimlari test edin.
    WebElement ıtsGoneElementi;
    WebElement ıtsBackElementi;
    @Test
    public void implicitlyWaitTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 3- https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4- Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        // 5- "It's gone!" mesajinin goruntulendigini dogrulayin.
        ıtsGoneElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(ıtsGoneElementi.isDisplayed(),"ıtsGone elementi gorunmuyor!!");

        // 6- Add butonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // 7- It's back mesajinin gorundugunu test edin
        ıtsBackElementi=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(ıtsBackElementi.isDisplayed(),"ıtsBackElementi gorunmuyor!!");
    }

    @Test
    public void explicitlyWaitTest(){
        // 3- https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // explicitly wait kullanabilmek icin once wwait objesi olusturmaliyiz
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));

        // 4- Remove butonuna basin.
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        // 5- "It's gone!" mesajinin goruntulendigini dogrulayin.
        /*
        WebElement ıtsGoneElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(ıtsGoneElementi));

        her ne kadar kodun anlasilabilir olmasi icin once locate edelim sonra bekleyelim davranisi daha guzel gorunse de
        WebElement zaten gorunur olmadigindan locate etmemiz de mumkun olmayacaktir
        bu durumda locate ve bekleme islemini beraber yapmak gerekir
         */

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        ıtsGoneElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(ıtsGoneElementi.isDisplayed(),"ıtsGone elementi gorunmuyor!!");

        // 6- Add butonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // 7- It's back mesajinin gorundugunu test edin
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        ıtsBackElementi=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(ıtsBackElementi.isDisplayed(),"ıtsBackElementi gorunmuyor!!");
    }

}
