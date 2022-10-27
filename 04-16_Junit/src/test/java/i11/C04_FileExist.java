package i11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExist {

    @Test
    public void test01() {

        System.out.println(System.getProperty("user.dir")); // C:\Users\USER\eclipse-workspace\com.Batch81JUnit
        // icinde bulundugumuz dosyanin yolunu gosterir
        System.out.println(System.getProperty("user.home")); // C:\Users\USER
        // gecerli kullanicinin ana dizinini verir

       /*
        String farkliBolum = System.getProperty("user.home");
        //"C:\Users\Lenovo\OneDrive\Masaüstü\text.txt" --> masa üstündeki dosyanın yolu
        String ortakBolum = "\\OneDrive\\Masaüstü\\tex.txt";
        String masaUstuDosyaYolu = farkliBolum+ortakBolum; // Masaüstündeki dosya yolunu gösterir
        System.out.println(masaUstuDosyaYolu); //C:\Users\Lenovo\OneDrive\Masaüstü\text.txt
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
 */

        String dosyaYolu = "C:\\Users\\USER\\Desktop\\txt.txt"; // masaustundeki dosyanin yolu
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        System.out.println("dosyaYolu = " + dosyaYolu);

    }
}
