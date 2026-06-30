package jayeshSonawane.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementActions {

    public static JavascriptExecutor scrollTo(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);

        return js;
    }

    public static void printElement(List<WebElement> element){
        if(!element.isEmpty()){
            for (WebElement e : element){
                System.out.println("Selected Option is : " + e.getText());
            }
        }else {
            System.out.println("No Option Selected");
        }
    }
}
