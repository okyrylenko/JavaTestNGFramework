package Foundation;

import Foundation.utils.ThreadManager;
import com.google.inject.internal.cglib.core.$CollectionUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import java.net.URL;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.Set;

//https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/Dimension.html
public class Browser {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private TestSettings settings;

    //@Inject
    public Browser(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.settings = new TestSettings();
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

    public Browser setCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
        return this;
    }

    public Browser setCookie(String name, String value, String path, String domain, Date date, boolean secure, boolean httpOnly){
        Cookie cookie = new Cookie.Builder(name, value)
                .domain(domain)
                .expiresOn(date)
                .isSecure(secure)
                .isHttpOnly(httpOnly)
                .build();
        this.setCookie(cookie);
        return this;
    }

    protected Browser setSize(Dimension targetSize) {
        driver.manage().window().setSize(targetSize);
        return this;
    }

    protected Browser setSize(int x, int y) {
        this.setSize(new Dimension(x, y));
        return this;
    }

    protected Dimension getSize(){
        return driver.manage().window().getSize();
    }

    protected int getBrowserHeight(){
        return this.getSize().getHeight();
    }

    protected int getBrowserWidth(){
        return this.getSize().getWidth();
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
        String url = ThreadManager.getSettings().getBaseUrl() + relativeUrl;
        System.out.println("url is " + url);
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


    //-------------------------------Browser Configurations----------------//

}
