package technocredits.asssertdemo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example1 {

    @BeforeMethod
    public void setup(){
        System.out.println("1");
    }

    @BeforeMethod
    public void beforeSetup(){
        System.out.println("11");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("2");
    }

    @Test(priority = 1)
    public void m1(){
        System.out.println("m1 start");
        String str1 = "Hi";
        String str2 = new String("Hi");
        Assert.assertTrue(str1!=str2);
        System.out.println("m1 end");
    }

    @Test(priority = 2)
    public void abc(){
        System.out.println("m2 start");
        String str1 = "Hi";
        String str2 = new String("Hi");
        Assert.assertFalse(str1==str2);
        m3();
        System.out.println("m2 end");
    }

    public void m3(){
        System.out.println("Hello");
    }
}
