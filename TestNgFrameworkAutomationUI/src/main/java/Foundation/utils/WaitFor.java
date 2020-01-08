package Foundation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitFor {

    public static ExpectedCondition<Boolean> waitForUrlToChange(String urlBefore){
        return driver-> driver.getCurrentUrl().equals(urlBefore)?false:true;
    }

    public static ExpectedCondition<WebElement> waitForNestedElementToBeIdDom(WebElement parent, By child){
        return driver->{
            try{
                return parent.findElement(child);
            }catch(NoSuchElementException ex){
                return null;
            }
        };
    }
}
