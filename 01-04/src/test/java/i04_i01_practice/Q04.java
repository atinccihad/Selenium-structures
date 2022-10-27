package i04_i01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04 {
    public static void main(String[] args) throws InterruptedException {
        // 1-driver olusturalim
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

        // 2-java class'imiza chromedriver.exe'yi tanitalim
        WebDriver driver = new ChromeDriver();

        // 3-driver'in tum ekrani kaplamasini saglayalim
        driver.manage().window().maximize();

        // 4-driver'a sayfanin yuklenmesini 10.000 milisaniye(10 saniye) boyunca beklemesini soyleyelim.Eger oncesinde sayfa yuklenirse, beklemeyi biraksin.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        // Click on Calculate under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        //    Type any number in the first input
        WebElement firstBox = driver.findElement(By.id("number1"));
        WebElement secondBox = driver.findElement(By.id("number2"));

        //    Type any number in the second input
        firstBox.sendKeys("25");
        secondBox.sendKeys("60");

        // Click on Calculate
        WebElement calculate = driver.findElement(By.id("calculate"));
        calculate.click();

        // Set the result
        // Get the result
        // Print the result
        driver.findElement(By.xpath("//option[text()='times']")).click();
        System.out.println(driver.findElement(By.xpath("//option[text()='times']")).getText());
        Thread.sleep(2500);
        driver.findElement(By.xpath("//option[text()='minus']")).click();
        System.out.println(driver.findElement(By.xpath("//option[text()='minus']")).getText());
        Thread.sleep(2500);
        driver.findElement(By.xpath("//option[text()='divide']")).click();
        System.out.println(driver.findElement(By.xpath("//option[text()='divide']")).getText());
        Thread.sleep(2500);

        String answer = driver.findElement(By.id("answer")).getText();
        System.out.println("answer = " + answer);

        // driver.close();
        driver.close();

    }
}
