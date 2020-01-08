package UIComponents;

import Foundation.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends BasePage {
    public Header(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By inpSearch = locateElementByCss("input[name='q']");
    private final By imgAccount = locateElementByCss("details.details-overlay[data-feature-preview-indicator-src]");

    public Header search(String searchCriteria){
        this.enterValueIntoSearchField(searchCriteria);
        clickEnter(inpSearch);
        return this;
    }

    private void enterValueIntoSearchField(String value){
        sendKeys(inpSearch, value);
    }

    public boolean isAccountIconVisible(){
        return isDisplayed(imgAccount, 3);
    }

}
