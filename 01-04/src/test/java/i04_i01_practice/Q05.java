package i04_i01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

// ...Exercise5...
public class Q05 {
    public static void main(String[] args) throws InterruptedException {
        // 1-driver olusturalim
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

        // 2-java class'imiza chromedriver.exe'yi tanitalim
        WebDriver driver = new ChromeDriver();

        // 3-driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();

        // 4-driver'a sayfanin yuklenmesini 10.000 milisaniye(10 saniye) boyunca beklemesini soyleyelim.Eger oncesinde sayfa yuklenirse, beklemeyi biraksin.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 5- navigate to website  https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        // 6- Under the ORIGINAL CONTENTS
        // 6- ORJİNAL İÇERİKLER ALTINDA
        // 7- click on Alerts
        driver.findElement(By.xpath("(//a[text()='Alerts (JavaScript)'])[1]")).click();

        // 8- print the URL
        System.out.println(driver.getCurrentUrl());

        // 9- navigate back
        driver.navigate().back();

        // 10- print the URL
        System.out.println(driver.getCurrentUrl());

        // 11- click on Basic Ajax
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Basic Ajax']")).click();

        // 12- print the URL
        System.out.println(driver.getCurrentUrl());

        // 13- enter value -> 20 and ENTER
        driver.findElement(By.id("lteq30")).sendKeys("20" + Keys.ENTER);

        // 14- and rhen verify Submitted Values is displayed open page
        WebElement submittedValues = driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        if (submittedValues.isDisplayed()) {
            System.out.println("submittedValues isDisplayed");
        } else {
            System.out.println("submittedValues is not Displayed!");
        }

        // 15- closeDriver.
        driver.close();
    }
}
