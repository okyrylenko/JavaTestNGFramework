package Foundation;

import com.google.inject.Inject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
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
        return null;
    }

    public String getTitle() {
        return null;
    }

    public void close() {

    }

    public void quit() {

    }

    public Set<String> getWindowHandles() {
        return null;
    }

    public String getWindowHandle() {
        return null;
    }


    public WebDriver.ImeHandler ime() {
        return null;
    }

    public WebDriver.Window window() {
        return null;
    }

    public WebDriver.TargetLocator switchTo() {
        return null;
    }

    public WebDriver.Navigation navigate() {
        return null;
    }

    public void deleteCookieNamed(String name) {

    }

    public void deleteCookie(Cookie cookie) {

    }

    public void deleteAllCookies() {

    }

    public Set<Cookie> getCookies() {
        return null;
    }

    public Cookie getCookieNamed(String name) {
        return null;
    }

    public void back() {

    }

    public void forward() {

    }

    public void to(String url) {

    }

    public void to(URL url) {

    }

    public void refresh() {

    }

    public WebDriver frame(int index) {
        return null;
    }

    public WebDriver frame(String nameOrId) {
        return null;
    }

    public WebDriver window(String nameOrHandle) {
        return null;
    }

    public WebDriver newWindow(WindowType typeHint) {
        return null;
    }


    public void maximize() {

    }

    public void fullscreen() {

    }
}
