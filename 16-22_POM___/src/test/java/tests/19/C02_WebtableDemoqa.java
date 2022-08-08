package tests.day19;

import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

// C02_Webtables
public class C02_WebtableDemoqa {

    @Test(groups = {"smoke","regression"})
    public void demoqaTest(){
        // 1. "https://demoqa.com/webtables"  sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("DemoqaUrl"));

        DemoqaPage demoqaPage=new DemoqaPage();
        // 2. Headers da bulunan department isimlerini yazdirin
        //  normalde     //thead//th   olurdu ancak bu class tablo isimleri ile organize edilmis

        System.out.println("Baslik satiri elementi=> "+demoqaPage.baslikSatiriElementi.getText());

        // ikinci yontem olarak basliklari bir listeye koyabilirim
        // basliklarWebelementiListesi;

        // 3.  3.sutunun basligini yazdirin
        System.out.println("3.sutunun basligi=> "+demoqaPage.basliklarWebelementiListesi.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin
        System.out.println("============ Tum body ==============");
        System.out.println(demoqaPage.bodyTekWebelement.getText());
        // 5. Tabloda kac cell(data) oldugunu yazdirin
        System.out.println("Tablodaki data sayisi=> "+demoqaPage.tumDataWebelementList.size());
        // 6. Tablodaki satir sayisini yazdirin
        System.out.println("Tum satir sayisi => "+demoqaPage.tumSatirlarWebelementList.size());
        // 7. Tablodaki sutun sayisini yazdirin
        //    farkli yollardan hesaplanabilir . hucre sayisi / satir sayisi   yapalim
        System.out.println("Tablodaki sutun sayisi=> "+demoqaPage.tumDataWebelementList.size()/demoqaPage.tumSatirlarWebelementList.size());
        // 8. Tablodaki 3.kolonu yazdirin
        demoqaPage.sutunYadir(2);
        // 9. Tabloda "First Name"i Kierra olan kisinin Salary'sini yazdirin.
        demoqaPage.ismeGoreMaasYazdir("Cierra");
        // 10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
        //     girdigimde bana detayi yazdirsin.
        demoqaPage.hucreYazdir(3,2);

        Driver.closeDriver();
    }

}
