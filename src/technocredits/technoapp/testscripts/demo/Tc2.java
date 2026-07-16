package technocredits.technoapp.testscripts.demo;

import org.testng.annotations.Test;

public class Tc2 {

    @Test(groups = {"smoke","e2e", "checkout"})
    public void m2() {
        System.out.println("Tc2 : m2");
    }

    @Test(groups = "regression")
    public void m4() {
        System.out.println("Tc2 : m4");
    }

    @Test(groups = "e2e")
    public void m5() {
        System.out.println("Tc2 : m5");
    }
}
