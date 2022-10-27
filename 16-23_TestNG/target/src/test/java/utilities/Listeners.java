package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

//UTILITY CLASS
public class Listeners implements ITestListener {
    @Override
    public void onStart(ITestContext arg){
        System.out.println("onStart - Tum testlerden ONCE 1 sefer cagrilir => "+arg.getName());
    }
    @Override
    public void onFinish(ITestContext arg) {
        System.out.println("onFinish - Tum testlerden SONTA 1 sefer cagrilir => "+arg.getName());
    }
    @Override
    public void onTestStart(ITestResult result) {
//        Before Method a benzer
        System.out.println("onTestStart - Method sayisi kadar, Her bir @Test annotation dan once bir kez calisir => "+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess - PASS olan Method sayisi kadar, ve PASS edilen methodlardan SONRA bir kez calisir => "+result.getName());
        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
//        System.out.println("onTestSkipped - Skipped edilen Method sayisi kadar, ve skipped edilen methodlardan SONRA bir kez calisir => "+result.getName());
        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestFailure(ITestResult result) {
//        System.out.println("onTestFailure - Failed edilen Method sayisi kadar, ve Failed edilen methodlardan SONRA bir kez calisir => "+result.getName());
        try {
            ReusableMethods.getScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}