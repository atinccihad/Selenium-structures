package practice01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03 {
    public static void main(String[] args) throws InterruptedException {
        //       ...Exercise3....
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();//Cookies'leri gorunmez hale getirir(mumkun oldugunca)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//a[@id='cookieChoiceDismiss']")).click();
        //driver.findElement(By.xpath("//a[text()='Tamam']")).click();
        // fill the firstname
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Seyfullah");
        // fill the lastname
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Nurpir");
        driver.findElement(By.xpath("//a[@id='cookieChoiceDismiss']")).click();
        // check the gender
        driver.findElement(By.xpath("//input[@id='sex-0']")).click();
        // check the experience
        driver.findElement(By.xpath("//input[@id='exp-1']")).click();
        // fill the date
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("19.04.2022");
        // choose your profession -> Automation Tester
        WebElement prf;
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();

        // choose your tool -> Selenium Webdriver
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        // choose your your contient -> Antartica
        driver.findElement(By.xpath("//select[@id='continents']")).sendKeys("Antartica");
        // choose your command -> Browser Commands
        driver.findElement(By.xpath("//option[normalize-space()='Browser Commands']")).click();
        // click submit button
        driver.close();


    }
}
