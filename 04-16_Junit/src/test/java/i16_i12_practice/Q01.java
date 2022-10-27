package i16_i12_practice;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Q01  {


    @Test
    public void verify() {
        // Verify that we have pom.xml file in our project
        String pomPath = "C:\\Users\\USER\\eclipse-workspace\\com.Batch81JUnit\\pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));

    }
}
