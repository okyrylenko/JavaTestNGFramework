package Foundation;

import Foundation.utils.WaitFor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.network.model.ConnectionType;
import org.openqa.selenium.html5.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.logging.LocalLogs;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.net.NetworkInterface;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.http.*;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

//https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/Dimension.html
public class BasePage extends Browser{

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

    protected WebElement findNestedElement(WebElement element, By locator){
        return element.findElement(locator);
    }

    protected  List<WebElement> findNestedElements(WebElement element, By locator){
        return element.findElements(locator);
    }

    protected BasePage submit(By locator) {
        findElement(locator).submit();
        return this;
    }

    
    public void pressKe(By locator, CharSequence keyToPress) {
        findElement(locator).sendKeys(keyToPress);
    }

    
    public void releaseKey(CharSequence keyToRelease) {

    }

    protected BasePage sendKeys(By locator, CharSequence... keysToSend) {
        waitForElementToBeClickable(locator).findElement(locator).sendKeys(keysToSend);
        return this;
    }

    
    public String getItem(String key) {
        return null;
    }

    
    public Set<String> keySet() {
        return null;
    }

    
    public void setItem(String key, String value) {

    }

    
    public String removeItem(String key) {
        return null;
    }

    protected void clear() {

    }

    
    public int size() {
        return 0;
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

    
    public void dismiss() {

    }

    
    public void accept() {

    }



    protected String getText(WebElement element) {
        return element.getText();
    }

    
    public void sendKeys(String keysToSend) {

    }

    protected List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    protected boolean isDisplayed(WebElement element, int timeout) {
        new FluentWait(driver).withTimeout(Duration.ofSeconds(timeout)).ignoring(TimeoutException.class).until(ExpectedConditions.visibilityOf(element));
        return isDisplayed(element);

    }

    protected boolean isDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    protected boolean isDisplayed(By locator, int timeout) {
        new FluentWait(driver).withTimeout(Duration.ofSeconds(timeout)).ignoring(TimeoutException.class).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return isDisplayed(locator);

    }

    protected Point getLocation(WebElement element) {
        return element.getLocation();
    }

    protected String getPageSource() {
        return null;
    }

    
    public WebDriver.Options manage() {
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

    
    public WebDriver frame(int index) {
        return null;
    }

    
    public WebDriver frame(String nameOrId) {
        return null;
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

    protected BasePage setWindowPosition(Point targetPosition) {
        driver.manage().window().setPosition(targetPosition);
        return this;
    }

    protected Rectangle getRect(WebElement element) {
        return element.getRect();
    }

    protected Rectangle getRect(By locator) {
        return getRect(findElement(locator));
    }

    protected String getCssValue(String propertyName) {
        return null;
    }

    protected Point getElementPosition(By locator) {
        return findElement(locator).getLocation();
    }
    protected Point getElementPosition(WebElement element) {
        return element.getLocation();
    }

    protected Dimension getElementDimension(By locator){
        return getRect(locator).getDimension();
    }

    protected Dimension getElementDimension(WebElement element){
        return getRect(element).getDimension();
    }

    protected int getElementHeight(By locator){
        return getRect(locator).getHeight();
    }

    protected int getElementHeight(WebElement element){
        return getRect(element).getHeight();
    }


    protected Point getElementPoint(By locator){
        return getRect(locator).getPoint();
    }

    protected Point getElementPoint(WebElement element){
        return getRect(element).getPoint();
    }

    protected int getElementWidth(By locator){
        return getRect(locator).getWidth();
    }

    protected int getElementWidth(WebElement element){
        return getRect(element).getWidth();
    }

    protected int getElementX(By locator){
        return getRect(locator).getX();
    }

    protected int getElementX(WebElement element){
        return getRect(element).getX();
    }
    protected int getElementY(By locator){
        return getRect(locator).getY();
    }

    protected int getElementY(WebElement element){
        return getRect(element).getY();
    }



    protected Point getWindowPosition() {
        return driver.manage().window().getPosition();
    }

    protected <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }

    protected BasePage waitForElementToBeClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return this;
    }

    protected BasePage waitForUrlToChange(String urlBefore){
        wait.until(WaitFor.waitForUrlToChange(urlBefore));
        return this;
    }

    protected BasePage waitForNestedElementToBeInDOM(WebElement parent, By child){
        wait.until(WaitFor.waitForNestedElementToBeIdDom(parent, child));
        return this;
    }

    
    public void perform() {

    }

    @Nullable
    
    public Object apply(@Nullable Object o) {
        return null;
    }

    @NotNull
    
    public Function andThen(@NotNull Function after) {
        return null;
    }

    @NotNull
    
    public Function compose(@NotNull Function before) {
        return null;
    }

    
    public String getBrowserName() {
        return null;
    }

    
    public Platform getPlatform() {
        return null;
    }

    
    public String getVersion() {
        return null;
    }

    
    public Map<String, Object> asMap() {
        return null;
    }

    
    public Object getCapability(String capabilityName) {
        return null;
    }

    
    public boolean is(String capabilityName) {
        return false;
    }

    
    public Capabilities merge(Capabilities other) {
        return null;
    }

    
    public Set<String> getCapabilityNames() {
        return null;
    }

    
    public WebDriver context(String name) {
        return null;
    }

    
    public Set<String> getContextHandles() {
        return null;
    }

    
    public String getContext() {
        return null;
    }

    
    public Capabilities getCapabilities() {
        return null;
    }

    
    public Object executeScript(String script, Object... args) {
        return null;
    }

    
    public Object executeAsyncScript(String script, Object... args) {
        return null;
    }

    
    public Object convertFromBase64Png(String base64Png) {
        return null;
    }

    
    public Object convertFromPngBytes(byte[] png) {
        return null;
    }

    
    public void rotate(ScreenOrientation orientation) {

    }

    
    public ScreenOrientation getOrientation() {
        return null;
    }

    
    public void rotate(DeviceRotation rotation) {

    }

    
    public DeviceRotation rotation() {
        return null;
    }

    
    public WebDriver.Timeouts implicitlyWait(long time, TimeUnit unit) {
        return null;
    }

    
    public WebDriver.Timeouts setScriptTimeout(long time, TimeUnit unit) {
        return null;
    }

    
    public WebDriver.Timeouts pageLoadTimeout(long time, TimeUnit unit) {
        return null;
    }

    
    public WebDriver getWrappedDriver() {
        return null;
    }

    
    public WebElement getWrappedElement() {
        return null;
    }

    
    public AppCacheStatus getStatus() {
        return null;
    }

    
    public Set<String> getAvailableLogTypes() {
        return null;
    }

    
    public Point onScreen() {
        return null;
    }

    
    public Point inViewPort() {
        return null;
    }

    
    public Point onPage() {
        return null;
    }

    
    public Object getAuxiliary() {
        return null;
    }

    
    public Object encode(Command command) {
        return null;
    }

    
    public Object encode(Supplier factory, Response response) {
        return null;
    }

    
    public Command decode(Object encodedCommand) {
        return null;
    }

    
    public void defineCommand(String name, HttpMethod method, String pathPattern) {

    }

    
    public void alias(String commandName, String isAnAliasFor) {

    }

    
    public Response execute(Command command) throws IOException {
        return null;
    }

    
    public Collection<Map.Entry<String, Object>> apply(Map.Entry<String, Object> entry) {
        return null;
    }

    
    public String getCommandName() {
        return null;
    }

    
    public void printCommandHelp(PrintStream out, boolean helpType) {

    }

    
    public ZoneId getZone() {
        return null;
    }

    
    public Clock withZone(ZoneId zone) {
        return null;
    }

    
    public Instant instant() {
        return null;
    }

    
    public Keyboard getKeyboard() {
        return null;
    }

    
    public Mouse getMouse() {
        return null;
    }

    
    public Object execute(String commandName, Map<String, ?> parameters) {
        return null;
    }

    
    public File getLocalFile(CharSequence... keys) {
        return null;
    }

    
    public Object invoke(ExecuteMethod executeMethod, Object self, Method method, Object... args) {
        return null;
    }

    
    public Map<String, Object> apply(Map<String, Object> capabilities) {
        return null;
    }

    
    public ElementLocator createLocator(Field field) {
        return null;
    }

    
    public Map<String, Object> encode() {
        return null;
    }

    
    public TouchScreen getTouch() {
        return null;
    }

    
    public SourceType getInputType() {
        return null;
    }

    
    public void perform(Collection<Sequence> actions) {

    }

    
    public void resetInputState() {

    }

    
    public List<Interaction> asInteractions(PointerInput mouse, KeyInput keyboard) {
        return null;
    }

    
    public Coordinates getCoordinates() {
        return null;
    }

    
    public void click(Coordinates where) {

    }

    
    public void doubleClick(Coordinates where) {

    }

    
    public void mouseDown(Coordinates where) {

    }

    
    public void mouseUp(Coordinates where) {

    }

    
    public void mouseMove(Coordinates where) {

    }

    
    public void mouseMove(Coordinates where, long xOffset, long yOffset) {

    }

    
    public void contextClick(Coordinates where) {

    }

    
    public void singleTap(Coordinates where) {

    }

    
    public void down(int x, int y) {

    }

    
    public void up(int x, int y) {

    }

    
    public void move(int x, int y) {
        /**
         * TODO - find the current coursor and move to new location
         */
        new Point(x, y).move(x,y);
    }

    protected BasePage moveBy(WebElement element,int xOffset, int yOffset){
        getElementPosition(element).moveBy(xOffset, yOffset);
        return this;
    }

    
    public void scroll(Coordinates where, int xOffset, int yOffset) {

    }

    
    public void doubleTap(Coordinates where) {

    }

    
    public void longPress(Coordinates where) {

    }

    
    public void scroll(int xOffset, int yOffset) {

    }

    
    public void flick(int xSpeed, int ySpeed) {

    }

    
    public void flick(Coordinates where, int xOffset, int yOffset, int speed) {

    }

    
    public WebElement findElement() {
        return null;
    }

    
    public List<WebElement> findElements() {
        return null;
    }

    
    public void writeTo(File parentDirectory) throws IOException {
        
    }

    
    public int getLowestEphemeralPort() {
        return 0;
    }

    
    public int getHighestEphemeralPort() {
        return 0;
    }

    
    public Object decorate(ClassLoader loader, Field field) {
        return null;
    }

    
    public Location location() {
        return null;
    }

    
    public void setLocation(Location location) {

    }

    
    public void setLocalLogs(LocalLogs logs) {

    }

    
    public NetworkConnection.ConnectionType getNetworkConnection() {
        return null;
    }

    
    public ConnectionType setNetworkConnection(ConnectionType type) {
        return null;
    }
    
    public Iterable<NetworkInterface> getNetworkInterfaces() {
        return null;
    }

    
    public NetworkInterface getLoInterface() {
        return null;
    }

    
    public WebSocket openSocket(HttpRequest request, WebSocket.Listener listener) {
        return null;
    }

    
    public HttpClient createClient(URL url) {
        return null;
    }

    
    public HttpClient createClient(ClientConfig config) {
        return null;
    }

    
    public void cleanupIdleClients() {

    }

    
    public HttpResponse execute(HttpRequest req) throws UncheckedIOException {
        return null;
    }

    
    public HttpHandler with(Filter filter) {
        return null;
    }

    
    public boolean isMultiple() {
        return false;
    }

    
    public List<WebElement> getOptions() {
        return null;
    }

    
    public List<WebElement> getAllSelectedOptions() {
        return null;
    }

    
    public WebElement getFirstSelectedOption() {
        return null;
    }

    
    public void selectByVisibleText(String text) {

    }

    
    public void selectByIndex(int index) {

    }

    
    public void selectByValue(String value) {

    }

    
    public void deselectAll() {

    }

    
    public void deselectByValue(String value) {

    }

    
    public void deselectByIndex(int index) {

    }

    
    public void deselectByVisibleText(String text) {

    }

    
    public LocalStorage getLocalStorage() {
        return null;
    }

    
    public SessionStorage getSessionStorage() {
        return null;
    }

    
    public void sleep(Duration duration) throws InterruptedException {
        
    }

    
    public Object until(Function isTrue) {
        return null;
    }

    
    public void beforeAlertAccept(WebDriver driver) {
        
    }

    
    public void afterAlertAccept(WebDriver driver) {

    }

    
    public void afterAlertDismiss(WebDriver driver) {

    }

    
    public void beforeAlertDismiss(WebDriver driver) {

    }

    
    public void beforeNavigateTo(String url, WebDriver driver) {

    }

    
    public void afterNavigateTo(String url, WebDriver driver) {

    }

    
    public void beforeNavigateBack(WebDriver driver) {

    }

    
    public void afterNavigateBack(WebDriver driver) {

    }

    
    public void beforeNavigateForward(WebDriver driver) {

    }

    
    public void afterNavigateForward(WebDriver driver) {

    }

    
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    
    public void afterNavigateRefresh(WebDriver driver) {

    }

    
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

    }

    
    public void afterFindBy(By by, WebElement element, WebDriver driver) {

    }

    
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    
    public void beforeScript(String script, WebDriver driver) {

    }

    
    public void afterScript(String script, WebDriver driver) {

    }

    
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    
    public void onException(Throwable throwable, WebDriver driver) {

    }

    
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }
}
