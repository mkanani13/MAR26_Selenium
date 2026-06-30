package jayeshSonawane.testNg;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Example1 {
    @Test
    public void m1(){
        System.out.println("m1");
    }

    @Test
    public void m2(){
        // Hard Assert Demo
        System.out.println("m2");
        Assert.assertEquals(10, 5);
        System.out.println("m2 end");
    }

    @Test
    public void m3(){
        // Soft Assert  Demo
        System.out.println("m3");
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(10, 5);
        System.out.println("m3 end");
        sAssert.assertAll("m3()");
    }

    @Test
    public void m4(){
        System.out.println("m4");
    }



}
