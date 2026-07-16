package technocredits.technoapp.testscripts.demo;

import org.testng.annotations.Test;

public class Tc1 {

    @Test(groups = "smoke", priority = 1)
    public void m1(){
        System.out.println("Tc1 : m1");
    }

    @Test(groups = "regression", priority = 0)
    public void m3(){
        System.out.println("Tc1 : m3");
    }
}
