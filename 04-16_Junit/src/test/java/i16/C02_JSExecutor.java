package i16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JSExecutor extends TestBaseBeforeAfter {

    @Test
    public void test() {
        // amazon sayfasina gidelim
        driver.get("http://www.amazon.com");
        // asagidaki carrers butonunu gorunceye kadar js ile scroll yapalim
        WebElement carrersButton = driver.findElement(By.xpath("//*[text()='Careers']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",carrersButton);
        // Carrers butonuna js ile click yapalim
        js.executeScript("arguments[0].click();",carrersButton);

        WebElement openJobs = driver.findElement(By.xpath("//a[@class='btn btn-quarternary']"));
        js.executeScript("arguments[0].scrollIntoView(true);",openJobs);
        js.executeScript("arguments[0].click();",openJobs);

    }
}
