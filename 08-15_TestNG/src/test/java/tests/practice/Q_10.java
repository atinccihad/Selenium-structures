package tests.practice;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q_10 extends TestBase {
    // https://www.gmibank.com/ adresine gidip negative login testi yapiniz..
    // dest datalari :
    // {"username1@gmail.com","password1"},
    // {"username2@gmail.com","password2"}.

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
    public void loginTesti(String username, String password) throws InterruptedException {
        driver.get("https://www.gmibank.com/");
        driver.findElement(By.xpath("(//a[@aria-haspopup='true'])[2]")).click();
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("(//span[text()='Sign in'])[3]")).click();

        Thread.sleep(4000);
    }

}
