package i04_i01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

//       ...Exercise3....
public class Q03 {
    public static void main(String[] args) throws InterruptedException {
        // 1-driver olusturalim
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

        // 2-java class'imiza chromedriver.exe'yi tanitalim
        WebDriver driver = new ChromeDriver();

        // 3-driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();

        // 4-driver'a sayfanin yuklenmesini 10.000 milisaniye(10 saniye) boyunca beklemesini soyleyelim.Eger oncesinde sayfa yuklenirse, beklemeyi biraksin.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        // driver.manage().deleteAllCookies();    => Cookies'leri gorunmez hale getirir(mumkun oldugunca)
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//a[@id='cookieChoiceDismiss']")).click();

        // fill the firstname
        driver.findElement(By.name("firstname")).sendKeys("seyfullah");

        // fill the lastname
        driver.findElement(By.name("lastname")).sendKeys("M");

        // check the gender
        driver.findElement(By.id("sex-0")).click();

        // check the experience
        driver.findElement(By.id("exp-1")).click();

        // fill the date
        driver.findElement(By.id("datepicker")).sendKeys("10/04/2021");

        // choose your profession -> Automation Tester
        WebElement prf = driver.findElement(By.id("profession-1"));
        prf.click();
        Thread.sleep(3000);

        // choose your tool -> Selenium Webdriver
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // choose your your contient -> Antartica
        driver.findElement(By.xpath("//select[@id='continents']")).sendKeys("Antartica" + Keys.ENTER);

        // choose your command -> Browser Commands
        driver.findElement(By.xpath("//option[text()='Browser Commands']")).click();
        Thread.sleep(3000);

        // Click Submit
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();

        // driver.close();
        driver.close();
    }
}
