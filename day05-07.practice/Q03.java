package practice02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q03 {
    //...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted

    // 1. method: createButtons(100)
    // 2. deleteButtonsAndValidate()
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        createButtons(driver,100);
        deleteButtonsAndValidate(driver,60);
        driver.close();
    }

    private static void createButtons(WebDriver driver, int eklenecekSayi) {
        WebElement addButton=driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int j = 0; j <eklenecekSayi ; j++) {
            addButton.click();
        }
    }

    private static void deleteButtonsAndValidate(WebDriver driver, int number) {
        List<WebElement>elements=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizeBeforeDelete=elements.size();

        List<WebElement>buttonsDelete=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        //int sizeAftereDelete=elements.size();
        int sayac=0;

        for (WebElement w :buttonsDelete) {
            sayac++;
            if (sayac>number){
                break;
            }
            w.click();
        }

        List<WebElement>elementsAfter=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizeAfterDelete=elementsAfter.size();

        if ((sizeBeforeDelete-number)==sizeAfterDelete){
            System.out.println("sizeAfterDelete ==> "+sizeAfterDelete);
            System.out.println("SUCCESS");
        }else {
            System.out.println("FAIL!!");
        }
    }


   /* static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Before
    public void setupBefore(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }
    @Test
    public void addElement() throws InterruptedException {
        driver.findElement(By.xpath("//button['Add Element']")).click();
        Thread.sleep(100);

        //Assert.assertTrue("title test kelimesi icermiyor..",iceriyorMu);
    }
    @Test
    public void deleteElement(){
        driver.findElement(By.xpath("(//button['added-manually'])[1]")).click();
    }





    @After
    public void setupAfter(){

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }*/
}
