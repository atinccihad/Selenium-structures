package tests.practice;

import org.testng.annotations.Test;
import utilities.TestBase;

public class Q_01  {
    /*
    TestNg (default) olarak @Test methodlarini alfabetik siraya gore run eder..(Yukaridan asagiya degil)
    priority anotation Testlere oncelik vermek icin kullanilir, kucuk olan numara daha once calisir.
    priority-> default degeri 0'dir
    priority:  TestNG testlerinde, testler konsola alfabetik siraya gore yazdirilir.

    enabled= false methodu: Testi gormezden gelmek icin @Test in yanina    '(enabled=false)'  fonksiyonunu kullaniriz.
     */

    @Test(priority = 3000)
    public void b(){
        System.out.println("b");
    }

    @Test(priority =2001 ,enabled = false)
    public void a(){
        System.out.println("a");
    }

    @Test(priority = 2000)
    public void c(){
        System.out.println("c");
    }

    @Test
    public void test1(){
        System.out.println("TEST1.....");
    }
    @Test
    public void test2(){
        System.out.println("TEST2.....");
    }

    @Test
    public void test3(){
        System.out.println("TEST3.....");
    }

    @Test(enabled = false)
    public void test4(){
        System.out.println("TEST4.....");
    }

    @Test(enabled = false)
    public void test5(){
        System.out.println("TEST5.....");
    }

    @Test
    public void test6(){
        System.out.println("TEST6.....");
    }

}
