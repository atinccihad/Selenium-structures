package tests.i23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestNGBeforeMethodAfterMethod;

public class Q_02 extends TestNGBeforeMethodAfterMethod {

    // go to URL: http://opencart.abstracta.us/index.php?route=account/login ,
    // login yapınız Email : batch44@gmail.com  password : 123456789
    // Search fonksiyonunu kullanarak  "Mac", "ipod", "samsung"  icin Dataprovider ile yapınız.
    //driver.findElement(By.xpath("//input[@value='Login']"));


    @Test(dataProvider = "getData")
    void searchFunction(String txt) {
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("batch44@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456789");

        WebElement searchArea = driver.findElement(By.xpath("//input[@name='search']"));
        searchArea.sendKeys(txt);
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
    }

    @DataProvider
    public Object[][] getData() {
        String data[][] = {{"mac"}, {"ipod"}, {"samsung"}};
        return data;
    }
}
