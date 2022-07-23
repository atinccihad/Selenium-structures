package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExist {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home"));// C:\Users\USER

        // masaustundeki deneme klasor'unun path'i
        // C:\Users\USER\Desktop\deneme

        // yani dinamik olarak masaustundeki deneme klasor'unun path'ini yazmak istersek
        String path=System.getProperty("user.home") ;
        System.out.println(path);

        System.out.println("user.dir   :"+System.getProperty("user.dir"));

        // Masaustundeki bir dosya yolunun tum bilgisayarlarda sorunsuz calismasi icin
        // dosya yolunu ikiye ayiracagiz
        // 1. herkesin bilgisayarinda farkli olan kisim
        // bu kismi bilgisayardan System.getProperty("user.home") kodu ile alabiliriz
        // 2. Herkes icin ayni olan kisim
        // bu kisim 1. maddedeki yolun devami seklinde olur

        // ornek: masaustundeki success dosyasi icin yol kaydedelim

        // Masaustunde Deneme klasoru icerisinde selenium.xlsx isminde bir dosya oldugunu test edin
        // **************  masaustunde Deneme klasoru ve icinde  selenium.xlsx  olmazsa CALİSMAZ  *****************
        // 1- once bu dosyaya ulasmak icin gerekli dinamik path olusturalim
        String dosyaYolu=System.getProperty("user.home") +"Desktop\\Deneme\\selenium.xlsx";

        System.out.println("dosya yolumuz: "+dosyaYolu);

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        // projemizde pom.xml oldugunu test edin.
        //C:\Users\USER\IdeaProjects\com.TestNGBatch44\pom.xml

        System.out.println("user.dir: "+System.getProperty("user.dir"));// projemin yolunu verir
        //C:\Users\USER\IdeaProjects\com.TestNGBatch44

        String pomPath=System.getProperty("user.dir")+"\\pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));

    }
}
