package Foundation;

import com.google.inject.Inject;
import org.jsoup.Connection;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.Set;

public class BasePage extends Browser {

    private final WebDriver driver;
    private final WebDriverWait wait;

    //@Inject
    protected BasePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }


    protected By locateElementByCss(String css){
        return By.cssSelector(css);
    }

    protected BasePage click(By locator) {
        findElement(locator).click();
        return this;
    }

    protected BasePage clickEnter(By locator){
        waitForElementToBeClickable(locator).sendKeys(locator, Keys.RETURN);
        return this;
    }

    protected void submit() {

    }

    protected void sendKeys(By locator, CharSequence... keysToSend) {
        waitForElementToBeClickable(locator).findElement(locator).sendKeys(keysToSend);
    }

    protected void clear() {

    }

    protected String getTagName() {
        return null;
    }

    protected String getAttribute(String name) {
        return null;
    }

    protected boolean isSelected() {
        return false;
    }

    protected boolean isEnabled() {
        return false;
    }

    protected String getText() {
        return null;
    }

    protected List<WebElement> findElements(By by) {
        return null;
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected boolean isDisplayed() {
        return false;
    }

    protected Point getLocation() {
        return null;
    }

    protected String getPageSource() {
        return null;
    }

    protected void addCookie(Cookie cookie) {

    }

    protected WebDriver.Timeouts timeouts() {
        return null;
    }

    protected Logs logs() {
        return null;
    }

    protected List<String> getAvailableEngines() {
        return null;
    }

    protected String getActiveEngine() {
        return null;
    }

    protected boolean isActivated() {
        return false;
    }

    protected void deactivate() {

    }

    protected void activateEngine(String engine) {

    }

    protected WebDriver frame(WebElement frameElement) {
        return null;
    }

    protected WebDriver parentFrame() {
        return null;
    }

    protected WebDriver defaultContent() {
        return null;
    }

    protected WebElement activeElement() {
        return null;
    }

    protected Alert alert() {
        return null;
    }

    protected void setSize(Dimension targetSize) {

    }

    protected void setPosition(Point targetPosition) {

    }

    protected Dimension getSize() {
        return null;
    }

    protected Rectangle getRect() {
        return null;
    }

    protected String getCssValue(String propertyName) {
        return null;
    }

    protected Point getPosition() {
        return null;
    }

    protected <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }

    protected BasePage waitForElementToBeClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return this;
    }
}
