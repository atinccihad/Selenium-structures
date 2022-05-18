package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XpathText {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1- https://the-internet.herokuapp.com/add_remove_elements/  adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        //3- Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButonu=driver.findElement(By.xpath("//button[text()='Delete']"));
        if (deleteButonu.isDisplayed()){
            System.out.println("delete butonu gorunuyor testi PASS");
        }else {
            System.out.println("delete butonu gorunuyor testi FAILED");
        }
        //4- Delete tusuna basin
        deleteButonu.click();
        //5- "Add/Remove Elements" yazisinin gorunur oldugunu test edin

        WebElement addYazisiElementi=driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']"));


        if (addYazisiElementi.isDisplayed()){
            System.out.println("add yazisi gorunuyor testi PASS");
        }else {
            System.out.println("add yazisi gorunuyor testi FAILED");
        }
        driver.close();
    }
}
