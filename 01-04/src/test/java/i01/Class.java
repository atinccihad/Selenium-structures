package i01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class {
    public static void main(String[] args) throws InterruptedException {
     /*
     En temel haliyle bir otomasyon yapmak için
     Class'ımıza otomasyon için gerekli olan webdriver'in yerini göstermemiz gerekir
     bunun için java kutuphanesinde System.setProperty() method'unu kullanırız
     ve metthod'un içine ilk olarak driver'i yazarız. İkinci olarak onun fiziki yolunu kopyalarız
     */
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        // create driver
        WebDriver driver = new ChromeDriver();
        // go to url
        driver.get("https://www.amazon.com");
        // maximize the window
        driver.manage().window().maximize();
        Thread.sleep(2000);
        // searchBox locate
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        // searchBox sendKeys Nutella
        searchBox.sendKeys("Nutella" + Keys.ENTER);
        // closeDriver
        driver.close();
    }
}
