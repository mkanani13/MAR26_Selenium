package technocredits.technoapp.testscripts.standalone;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class TestNGListenerExample {

    @BeforeMethod
    public void setup() {
        System.out.println("Chrome Launch");
    }


    @Test
    public void m1() {
        File file = new File("/technocredits/technoapp/testscripts/standalone/IframeDemo.java");
        Assert.assertTrue(file.exists(), "File not found..");
//        throw new RuntimeException("Element not found");
    }

    @Test
    public void m2() {
        File file = new File("/technocredits/technoapp/testscripts/standalone/IframeDemo.java");
//        Assert.assertTrue(file.exists(), "File not found..");
        throw new RuntimeException("Element not found");
    }

    @Test
    public void m3() {
        File file = new File("src/technocredits/technoapp/testscripts/standalone/IframeDemo.java");
        Assert.assertTrue(file.exists(), "File not found..");
//        throw new RuntimeException("Element not found");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        System.out.println("Method Name : " + result.getMethod().getMethodName());
        System.out.println("Test Execution Start : " + result.getStartMillis());

        System.out.println("Test Execution End : " + result.getEndMillis());

        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Check Failed...");
        }

        if (result.isSuccess()) {
            System.out.println("Test Execution Done Properly");
        } else {
            System.out.println("Test Execution Closed unexpectedly");
        }

        System.out.println("Execution Done...!");
    }


}
