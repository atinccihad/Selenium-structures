package tests.i23;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ReusableMethods;
import utilities.TestNGBeforeMethodAfterMethod;

public class Q_03 extends TestNGBeforeMethodAfterMethod {
    // https://www.gmibank.com/  adresine gidip negative login test yapiniz
    // test datalari :
    // {"username1@gmail.com","password1"},
    // {"username2@gmail.com","password2"}

    @DataProvider
    public static Object[][] negativeSignInTest() {

        Object[][] bankData = new Object[3][2];
        bankData[0][0] = "username1@gmail.com";
        bankData[0][1] = "password1";
        bankData[1][0] = "username2@gmail.com";
        bankData[1][1] = "password2";
        bankData[2][0] = "username3@gmail.com";
        bankData[2][1] = "password3";

        return bankData;
    }

    @Test(dataProvider = "negativeSignInTest")
    public void test(String username, String password) {
        driver.get("https://www.gmibank.com/");
        driver.findElement(By.xpath("//*[@id='account-menu']/a")).click();
        driver.findElement(By.xpath("//a[@id='login-item']")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        ReusableMethods.waitFor(3);
    }
}
