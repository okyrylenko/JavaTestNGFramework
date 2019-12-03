package Foundation;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import java.net.URL;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Browser {

    private final WebDriver driver;
    private final WebDriverWait wait;

    //@Inject
    public Browser(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }


    public WebDriver.ImeHandler ime() {
        return driver.manage().ime();
    }

    public WebDriver.Window window() {
        return driver.manage().window();
    }

    public WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    public WebDriver.Navigation navigate() {
        return driver.navigate();
    }

    public void deleteCookieNamed(String name) {
        driver.manage().deleteCookieNamed(name);
    }

    public void deleteCookie(Cookie cookie) {
        driver.manage().deleteCookie(cookie);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public Set<Cookie> getCookies() {
        return driver.manage().getCookies();
    }

    public Cookie getCookieNamed(String name) {
        return driver.manage().getCookieNamed(name);
    }

    public void get(String relativeUrl){
        navigateTo(relativeUrl);
    }

    public void back() {
        driver.navigate().back();
    }

    public void forward() {
        driver.navigate().forward();
    }

    public void navigateTo(String relativeUrl) {
        String url = TestSettings.baseUrl + relativeUrl;
        driver.navigate().to(url);
    }

    public void navigateTo(URL url){
        driver.navigate().to(url);
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public WebDriver switchToFrame(int index) {
        return driver.switchTo().frame(index) ;
    }

    public WebDriver switchToFrame(String nameOrId) {
        return driver.switchTo().frame(nameOrId);
    }

    public WebDriver window(String nameOrHandle) {
        return driver.switchTo().window(nameOrHandle);
    }

    public WebDriver newWindow(WindowType typeHint) {
        driver.switchTo().newWindow(typeHint);
        return driver;
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void fullscreen() {
        driver.manage().window().fullscreen();
    }
}
