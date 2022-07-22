package day03_WebelementLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElementGetMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        // signIn linkini locate edelim

        WebElement signInLinki=driver.findElement(By.id("sign-in"));
        System.out.println("size: "+signInLinki.getSize());
        System.out.println("AriaRole: "+signInLinki.getAriaRole());
        System.out.println("AccessibleName: "+signInLinki.getAccessibleName());
        System.out.println("id Attribute value'su: "+signInLinki.getAttribute("id"));
        System.out.println("location: "+signInLinki.getLocation());
        System.out.println("genislik: "+signInLinki.getRect().width);
        System.out.println("colour: "+signInLinki.getCssValue("color"));


        driver.close();

    }
}
