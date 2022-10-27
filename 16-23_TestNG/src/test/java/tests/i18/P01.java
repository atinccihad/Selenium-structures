package tests.i18;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DhtmlgoodiesPage;
import utilities.Driver;
import utilities.TestNGBeforeClassAfterClass;

public class P01 {


    @Test
    public void test01() {
        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // Fill in capitals by country.
        // Ülkeye göre başkentleri doldurun.
        DhtmlgoodiesPage dhtmlgoodiesPage = new DhtmlgoodiesPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(dhtmlgoodiesPage.oslo, dhtmlgoodiesPage.norway)
                .dragAndDrop(dhtmlgoodiesPage.washington, dhtmlgoodiesPage.unitedStates)
                .dragAndDrop(dhtmlgoodiesPage.stockholm, dhtmlgoodiesPage.sweden)
                .dragAndDrop(dhtmlgoodiesPage.copenhagen, dhtmlgoodiesPage.denmark)
                .dragAndDrop(dhtmlgoodiesPage.seul, dhtmlgoodiesPage.southKorea)
                .dragAndDrop(dhtmlgoodiesPage.rome, dhtmlgoodiesPage.italy)
                .dragAndDrop(dhtmlgoodiesPage.madrid, dhtmlgoodiesPage.spain)
                .perform();

        // Driver.closeDriver();
        Driver.closeDriver();

        /*
        -Frameworkler buyudukce yeni classlar yeni test methodlari yeni webelementler olusturdukca
        icinden cikilmaz, anlasilmaz, tekrar bakimi yapilamaz, guncellemesi cok zor hatta imkansiz bir hal alir.
        -Uzmanlar reusable, maintainable, rahat manipule edilebilir bir framework icin bir design pattern olarak
        POM (page object model)'de karar vermisler.
        -Olmazsa olmazlar
                1) Driver class
                2) Page class
                3) Test class
                   Utilities
        -Aradigimiz bir web elementi ya da bir methodu kolaylikla bulabilmek ve guncelleyebilmek icin javadan
        ogrenmis oldugumuz OOP Concept Selenium ile page object modelde birlestirilmis oluyor.
         */
    }
          /*
          PageFactory bizlere nesne deposu oluşturmaya imkan veren, sürdürülebilir,
         yeniden kullanılabilir ve elementleri tek bir yerden yönetmeyi sağlayan bir Page object model konseptidir.
         Page Factory’i kullanımına bakacak olursak PageFactory model, Web elementlerini
         @FindBy annotionu ile algılar. How kalıbı ile birlikte elementlerin ayırt edici
         locator’ından hangisini kullanacaksak belirtilir. Sonrasında ise o ayırt edici
         locator’ın adı tanımlanır. Public WebElement ile birlikte test senaryolarında
         kullanmak üzere isimlendirmesi yaparız. Burada isimlendirme daha sonra baktığında
         anlayabilmek için önemlidir, okunaklı olmalıdır.
         */
}
