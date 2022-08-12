package day03_WebelementLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_LoginTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");
        // b. Sign in butonuna basiniz
        WebElement signInLinki=driver.findElement(By.id("sign-in"));// sadece locate edip bir variable'a assign ettik
        signInLinki.click();
        // c. email tectbox,password textbox, and signin button elementlerini locate ediniz.
        WebElement emailTextBox=driver.findElement(By.id("session_email"));
        WebElement passwordTestBox=driver.findElement(By.id("session_password"));
        WebElement signInButonu=driver.findElement(By.name("commit"));
        // d. Kullanici adini ve sifreyi asagiya girin ve oturum ac(sign in) butonunu tiklayin:
        //        i. Username : testtechproed@gmail.com oldugunu dogrulayin(verify).
        //        ii. Pasword : Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTestBox.sendKeys("Test1234!");

        Thread.sleep(3000);
        signInButonu.click();
        // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement girisYazisisElementi=driver.findElement(By.tagName("h1"));
        System.out.println(girisYazisisElementi.getText());
        String actualGirisYazisi=girisYazisisElementi.getText();
        String expectedGirisYazisi="Welcome to Address Book";

        if (actualGirisYazisi.equals(expectedGirisYazisi)){
            System.out.println("Sayfaya giris testi PASS");
        }else {
            System.out.println("Sayfaya giris testi FAILED");
        }
        // f. "Addresses" ve "Sign Out" textlerinin goruntulendigini(displayed) dogrulayin(verify).
        WebElement adresWebElementi=driver.findElement(By.linkText("Addresses"));
        WebElement signOutElementi=driver.findElement(By.linkText("Sign out"));
        System.out.println(adresWebElementi.isDisplayed());// true veya false dondurecek

        if (adresWebElementi.isDisplayed()){
            System.out.println("Adres elementi goruntuleme testi PASS");
        }else {
            System.out.println("Adres elementi goruntuleme testi FAILED");
        }
        if (signOutElementi.isDisplayed()){
            System.out.println("SignOut elementi elementi goruntuleme testi PASS");
        }else {
            System.out.println("SignOut elementi goruntuleme testi FAILED");
        }
        // 3. sayfada kac tane link oldugunu bulun.

        List<WebElement>linllerListesi=driver.findElements(By.tagName("a"));

        System.out.println("Sayfada  "+linllerListesi.size()+" adet link bulunmaktadir");

        driver.close();

    }
}
