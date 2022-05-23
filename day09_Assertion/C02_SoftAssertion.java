package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;
// C02_SoftAssertion
public class C02_SoftAssertion {

WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01(){
        // 1. "http://zero.webappsecurity.com/" adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        // 3. Login kutusuna "username" yazin
        WebElement nameBox=driver.findElement(By.xpath("//input[@id='user_login']"));
        nameBox.sendKeys("username");
        // 4. Password kutusuna "password" yazin
        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordBox.sendKeys("password");
        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        //WebElement keepMeSignedIn=driver.findElement(By.xpath("//input[@type='checkbox']"));
        //keepMeSignedIn.click();
        //WebElement signInTus=driver.findElement(By.xpath("//input[@type='submit']"));
        //signInTus.click();
        // 6. Online Bankıng menusu altinda  Pay Bills sayfasina gidin
        driver.navigate().back(); // guvenli degil uyarisini geciyor
        driver.findElement(By.xpath("//strong[text( )='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        // 7. Online banking menusu altinda "Purchase Foreign Currency" tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        // 8. "Currency" drop down menusunden Eurozone'u secin
        WebElement dropDown=driver.findElement(By.xpath("//select[id='pc_currency']"));
        Select select=new Select(dropDown);
        select.selectByValue("EUR");
        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String actualSecim=select.getFirstSelectedOption().getText();
        String expectedSecim="Eurozone(euro)";
        softAssert.assertEquals(actualSecim,expectedSecim,"Dropdown dogru secilemedi");
        System.out.println("Hard assertion failed olsaydi ve ilk assertion failed oldugundan bu satir calismazdi");
        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One",
        //     "Australia(dollar)
        List<WebElement>optionList=select.getOptions();

        String actualOptionListesiStringOlarak="";
        for (WebElement each:optionList){
            actualOptionListesiStringOlarak+="\"" +each.getText()+"\", ";
        }

        actualOptionListesiStringOlarak=actualOptionListesiStringOlarak.substring(0,actualOptionListesiStringOlarak.length()-2);
        String expectedListesiStringOlarak="\"Select One\", \"Australia (dollar)\", \"Canada (dollar)\", \"Switzerland (franc)\", \"China (yuan)\", \"Denmark (krone)\", \"Eurozone (Euro)\", \"Great Britain (pound)\", \"Hong Kong (dollar)\", \"Japan (yen)\", \"Mexico (peso)\", \"Norway (krone)\", \"New Zealand (dollar)\", \"Sweden (krona)\", \"Singapore (dollar)\", \"Thailand (baht)\"";
        softAssert.assertEquals(actualOptionListesiStringOlarak,expectedListesiStringOlarak);
        softAssert.assertAll();

        System.out.println("testlerden failed olan varsa softAssert.assertAll'dan sonrasi calismaz");
    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
