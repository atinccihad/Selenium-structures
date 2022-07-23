package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C08_FileExist {
    @Test
    public void test(){
        System.out.println(System.getProperty("user.home"));//C:\Users\USER
        String dosyaYoluDinamik=System.getProperty("user.home")+"\\Desktop\\success.jpg";

        // Masaustundeki bir dosya yolunun tum bilgisayarlarda sorunsuz calismasi icin
        // dosya yolunu ikiye ayiracagiz
        // 1. herkesin bilgisayarinda farkli olan kisim
        // bu kismi bilgisayardan System.getProperty("user.home") kodu ile alabiliriz
        // 2. Herkes icin ayni olan kisim
        // bu kisim 1. maddedeki yolun devami seklinde olur

        // ornek: masaustundeki success dosyasi icin yol kaydedelim
        String dosyaYoluManual="C:\\Users\\USER\\Desktop\\success.jpg";

        System.out.println("dosya yolumuz: "+dosyaYoluDinamik);

        System.out.println(Files.exists(Paths.get(dosyaYoluDinamik)));

        Assert.assertTrue(Files.exists(Paths.get(dosyaYoluManual)));

        System.out.println(System.getProperty("user.dir"));
        // icinde oldugumuz dosyanin yolunu verir.
    }
}
