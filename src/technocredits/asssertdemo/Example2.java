package technocredits.asssertdemo;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example2 {

    @BeforeClass
    public void beforeClass(){
        System.out.println("hc");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("1");
    }

    @Test
    public void m1(){
        System.out.println("m1");
        int numberOfCards = 4;
        Assert.assertEquals(numberOfCards,4);
        System.out.println("m1 end");
    }

    @Test
    public void m2(){
        System.out.println("m2");
        int openJobCountFromCard = 9;
        int openJobCountFromLabel = 9;
        Assert.assertEquals(openJobCountFromLabel, openJobCountFromCard);
        System.out.println("m2 end");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("ac");
    }
}
