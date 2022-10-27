package i09_i04_practice;

import org.junit.*;

public class C02_Junit {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass\nHer Class da ilk calisir,1 kere calisir.");
    }

    @Before
    public void before(){
        System.out.println("before\nHer testten once calisir");
    }

    @After
    public void after(){
        System.out.println("after\nHer methoddan sonra calisir.");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass\nClass'da en son ve 1 kere calisir.");
    }

    @Test
    public  void  test01(){
        System.out.println("test01");
    }

    @Test
    public  void  test02(){
        System.out.println("test02");
    }

    @Test
    public  void  test03(){
        System.out.println("test03");
    }
}
