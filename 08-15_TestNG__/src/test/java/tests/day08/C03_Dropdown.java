package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

// Bir class olusturun: C03_Dropdown
public class C03_Dropdown {

WebDriver driver;
    @BeforeMethod
public void setyUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.manage().window().maximize();
}

         @Test
    public void dropdownTesti(){
             // https://the-internet.herokuapp.com/dropdown adresine gidiniz.
             driver.get("https://the-internet.herokuapp.com/dropdown");

             WebElement dropdownElementi= driver.findElement(By.xpath("//select[@id='dropdown']"));
             Select select=new Select(dropdownElementi);

             // 1. Index kullanarak Secenek 1'i(Option 1) secin ve yazdirin.
             select.selectByIndex(1);
             System.out.println(select.getFirstSelectedOption().getText());

             // 2. Value kullanarak Secenek 2'i(Option 2) secin ve yazdirin.
             select.selectByValue("2");
             System.out.println(select.getFirstSelectedOption().getText());

             // 3. Visible Text(Gorunen metin) kullanarak Secenek 1'i(Option 1) secin ve yazdirin.
             select.selectByVisibleText("Option 1");
             System.out.println(select.getFirstSelectedOption().getText());

             // 4. Tum dropdown degerleri(value) yazdirin.
             List<WebElement>optionList=select.getOptions();
             for (WebElement each:optionList){
                 System.out.println(each.getText());
             }
             // 5. Dropdown'un boyutunu bulun,Dropdown'da 4 oge bulundugunu test edin.
             int actualSize= optionList.size();
             int expectedSize=4;

             Assert.assertEquals(actualSize,expectedSize,"Opsiyon sayisi beklentileri karsilamiyor.");

         }
         @AfterMethod
    public void tearDown(){
        driver.close();
         }
}
