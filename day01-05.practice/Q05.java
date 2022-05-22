package practice01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q05 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        WebElement verifySubmittedElementi;
        WebElement inputElementi;
        WebElement basicAjaxElementi;
        WebElement alertsElement;//= driver.findElement(By.xpath("//a[@id='alerts']"));
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();//Cookies'leri gorunmez hale getirir(mumkun oldugunca)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        alertsElement= driver.findElement(By.xpath("//a[@id='alerts']"));
        alertsElement.click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        basicAjaxElementi=driver.findElement(By.xpath("//a[@id='basicajax']"));
        basicAjaxElementi.click();
        System.out.println(driver.getCurrentUrl());
        inputElementi=driver.findElement(By.xpath("//input[@id='lteq30']"));
        inputElementi.sendKeys("20"+ Keys.ENTER);
        verifySubmittedElementi=driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        if (verifySubmittedElementi.isDisplayed()){
            System.out.println("isDisplayed PASS");
        }else{
            System.out.println("isDisplayed FAIL");
        }
        driver.close();
    }
}
