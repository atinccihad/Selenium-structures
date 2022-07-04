package practice01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04 {
    // ...Exercise5...
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();//Cookies'leri gorunmez hale getirir(mumkun oldugunca)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//a[@id='calculate']")).click();
        WebElement firstBox=driver.findElement(By.id("number1"));
        WebElement secondBox=driver.findElement(By.id("number2"));
        firstBox.sendKeys("25");
        secondBox.sendKeys("25");
        WebElement calculate=driver.findElement(By.id("calculate"));
        calculate.click();
        String answer=driver.findElement(By.id("answer")).getText();
        System.out.println("answer ==> "+answer);

       /* // Navigate to https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        // Click on Calculate under Micro Apps
        driver.findElement(By.xpath("//a[@id='calculate']")).click();
        //    Type any number in the first input
        driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("123456789");
        //    Type any number in the second input
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("123456789");
        // Click on Calculate
        driver.findElement(By.xpath("//input[@id='calculate']")).click();
        // Set the result
        // Get the result
        // Print the result
        System.out.println("answer ==> "+answer);*/
    }
}
