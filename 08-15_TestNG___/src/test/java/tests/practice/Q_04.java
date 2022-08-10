package tests.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q_04 extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        // Navigate to: https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");
        // Enter the user name: standard_user
        WebElement nameBox=driver.findElement(By.xpath("//input[@id='user-name']"));
        nameBox.sendKeys("standard_user");
        Thread.sleep(1000);
        // Enter the password: secret_sauce
        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("secret_sauce");
        Thread.sleep(1000);
        // Click on login button
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        Thread.sleep(1000);
        //    T1 : Choose price low to high
        WebElement dd=driver.findElement(By.className("product_sort_container"));
        Select select=new Select(dd);
        Thread.sleep(1000);
        select.selectByVisibleText("Price (low to high)");

        String expected="PRICE (LOW TO HIGH)";
        String actual=driver.findElement(By.className("active_option")).getText();
        Thread.sleep(1000);

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actual,expected,"Fiyatlar istenildigi gibi siralanmamis..");
        softAssert.assertAll();
        Thread.sleep(1000);
    }

    @Test
    public void test2() throws InterruptedException {
        // Navigate to: https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");
        // Enter the user name: standard_user
        WebElement nameBox=driver.findElement(By.xpath("//input[@id='user-name']"));
        nameBox.sendKeys("standard_user");
        Thread.sleep(1000);
        // Enter the password: secret_sauce
        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("secret_sauce");
        Thread.sleep(1000);
        // Click on login button
        WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        Thread.sleep(1000);
        //    T1 : Choose price low to high
        WebElement dd=driver.findElement(By.className("product_sort_container"));
        Select select=new Select(dd);
        Thread.sleep(1000);
        //    T2 : Verify item prices are sorted from low to high with soft Assert
        select.selectByIndex(2);

        List<WebElement>fiyatlarListesi=driver.findElements(By.className("inventory_item_price"));
        ArrayList<Double>fiyatlarDouble=new ArrayList<>();

        for (WebElement fiyat:fiyatlarListesi) {
           // String fiyatStr=fiyat.getText().replaceAll("$","");
            String fiyatStr=fiyat.getText().replaceAll("^\\D","");
            fiyatlarDouble.add(Double.parseDouble(fiyatStr));
        }

        ArrayList <Double>kobtrolList=new ArrayList<>(fiyatlarDouble);
        Collections.sort(kobtrolList);

        Assert.assertEquals(kobtrolList,fiyatlarDouble);
    }
}
