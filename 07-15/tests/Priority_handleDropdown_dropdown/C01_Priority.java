package tests.day08;

import org.testng.annotations.Test;

public class C01_Priority {

    @Test(priority = -9)
    public void youtubeTesti(){
        System.out.println("Youtube testi calisti..");
    }

    @Test
    public void amazonTesti(){//**** priority atanmazsa priority=0 kabul eder ****
        System.out.println("Amazon testi calisti..");
    }

    @Test(priority = 5 )
    public void bestbuyTesti(){
        System.out.println("Bestbuy testi calisti..");
    }
}
