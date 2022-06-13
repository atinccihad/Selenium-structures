package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCampPage;
import utilities.Driver;

import java.util.List;

// C02_WebTables
public class C02_WebTables {
    // - login() methodu olusturun ve oturum acin
    HotelMyCampPage hotelMyCampPage;
    HMCWebTablePage hmcWebTablePage;

    @Test
    public void loginT(){
        // https://www.hotelmycamp.com  admin/HotelRoomAdmin  adresine gidin
        //                    - Ussername : manager
        //                    - Password : Manager1!
        hotelMyCampPage =new HotelMyCampPage();
        hotelMyCampPage.girisYap();
    }

    @Test(dependsOnMethods = "loginT")
    public void table(){
        // - table() methodu olusturun
        //                    - Tum table body'sinin boyutunu(sutun sayisini) bulun./tbody
        // header kisminda birinci satir ve altindaki datalari locate edelim
        //      //thead//tr[1]//th"
        hmcWebTablePage=new HMCWebTablePage();
        List<WebElement> headerDataList=hmcWebTablePage.headerBirinciSatirDatalar;
        System.out.println("tablodaki sutun sayisi: "+headerDataList.size());

        //                    - Table'daki tum body'ı ve basliklari(headers) konsolda yazdirin.
        //         //tbody
        System.out.println(hmcWebTablePage.tumBodyWebElementi.getText());
        // eger body'i tek bir webelement olarak locate edersek
        // icindeki tum datalari gettext() ile yazdirabiliriz
        // ancak bu durumda bu elementler ayri ayri degil body'nin icindeki tek bir String'in parcalari olurlar
        // dolayisiyla bu elementlere tek tek ulasmamiz mumkun olmaz
        // sadece contains methodu ile body'de olup olmadiklarini test ederiz

        // eger her datayi ayri ayri almak istersek
        //    //tbody//td   sekline locate edip bir list'e atabiliriz.
        List<WebElement> bodyTumDataList=hmcWebTablePage.tumBodyDatalariList;
        System.out.println("body'deki data sayisi"+bodyTumDataList);
    }

    @Test(dependsOnMethods = "loginT")
    public void printRows() {
        // -printRows() methodu olusturun //tr
        //                    - Table body'sinde bulunan toplam satir(row) sayisini bulun.
        //     //tbody//tr
        hmcWebTablePage=new HMCWebTablePage();
        System.out.println(hmcWebTablePage.satirlarListesi.size());

        //                    - Table body'sinde bulunan toplam satirlari(rows) konsolda yazdirin.
        List<WebElement> satirlarWebelementListesi=hmcWebTablePage.satirlarListesi;
        for (WebElement each:satirlarWebelementListesi) {
            System.out.println(each.getText());
        }
        //                    - 4.satirdaki(row) elementlerini konsolda yazdirin.
        System.out.println("4.satirdaki(row) elementleri==> "+satirlarWebelementListesi.get(3).getText());

    }

}
