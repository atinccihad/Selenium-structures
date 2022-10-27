package i11_i09_practice;

import org.junit.Test;

public class Q01 {
    /*
    TestNg (default) olarak @Test methodlarini alfabetik siraya gore run eder..(Yukaridan asagiya degil)
    priority anotation Testlere oncelik vermek icin kullanilir, kucuk olan numara daha once calisir.
    priority-> default degeri 0'dir
    priority:  TestNG testlerinde, testler konsola alfabetik siraya gore yazdirilir.

    enabled= false methodu: Testi gormezden gelmek icin @Test in yanina    '(enabled=false)'  fonksiyonunu kullaniriz.
     */

    @Test //(priority=3000) => TestNG notasyonu oldugu icin, CTE
    public void b() {
        System.out.println("b");
    }

    @Test
    public void a() {
        System.out.println("a");
    }

    @Test
    public void c() {
        System.out.println("c");
    }

    @Test
    public void test01() {
        System.out.println("test01");
    }

    @Test
    public void test02() {
        System.out.println("test02");
    }

    @Test
    public void test03() {
        System.out.println("test03");
    }

    @Test
    public void test04() {
        System.out.println("test04");
    }

    @Test
    public void test05() {
        System.out.println("test05");
    }

    @Test
    public void test06() {
        System.out.println("test06");
    }

}
