package i12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

// 1. Bir class olusturun : C03_ExplicitlyWait
public class C03_ExplicitlyWait extends TestBaseBeforeAfter {

    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //    Iki metod icin de asagidaki adimlari test edin.
    @Test
    public void implicitlyWaitTest01() {
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();

        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebElement itsGone = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue("'It's gone!'   is notDisplayed!", itsGone.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();

        // 7. It's back mesajinin gorundugunu test edin
        WebElement itsBack = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue("'It's back!'    is notDisplayed!", itsBack.isDisplayed());
    }

    @Test
    public void explicitlyWaitTest02() {
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[1]")).click();

        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue("'It's gone!'     is notDisplayed!", itsGoneWE.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // 7. It's back mesajinin gorundugunu test edin
        WebElement itsBackWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue("'It's back'      is notDisplayed!", itsBackWE.isDisplayed());
    }
}
