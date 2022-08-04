package practice02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class Q06dropdown {
    //...Exercise6...
    static WebDriver driver;
    static WebElement searchBox;
    static WebElement aramaKutusu;
    static WebElement sonucSayisiElementi;
    static WebElement dropDown;
    static Select select;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1. Amazon.com'a gidelim
        driver.get("https://amazon.com/");
    }

    @Before
    public void getUrl(){
        // 1. Amazon.com'a gidelim
       // driver.get("https://amazon.com/");
    }

    @Test
    public void select() throws InterruptedException {
        // 2. DropDown uzerinde Books secelim.(All yazan yerde)
        //    kategorilerin hepsini konsola yazdiralim
       dropDown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        dropDown.click();
        System.out.println(dropDown.getText());
        WebElement booksElementi=driver.findElement(By.xpath("//option[.='Books']"));
        driver.findElement(By.xpath("//option[.='Books']")).click();
        Thread.sleep(1000);
    }

    @Test
    public void select2() throws InterruptedException {
        // 3. Arama kutusuna Les Miserables yazalim ve arama yapalim.
        searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Les Miserables"+ Keys.ENTER);
        Thread.sleep(1000);
    }

    @Test
    public void select3() throws InterruptedException {
        // 4. Sonuc sayisini ekrana yazdiralim.
        sonucSayisiElementi= driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));
        System.out.println("Sonuc sayisi==> "+sonucSayisiElementi.getText());
        Thread.sleep(1000);
    }

    @Test
    public void select4() throws InterruptedException {
        // 5. Sonuclarin Les Miserables i icerdigini assert edelim
        WebElement lesMireables = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        boolean lesMireablesIcerdigi = lesMireables.isDisplayed();
        Assert.assertTrue("Les Miserables i icermiyor!!!",lesMireablesIcerdigi);
        Thread.sleep(1000);
    }

    @AfterClass
    public static void tearDown(){
       driver.close();}

}
