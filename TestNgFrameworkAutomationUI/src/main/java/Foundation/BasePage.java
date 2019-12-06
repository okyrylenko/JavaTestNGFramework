package Foundation;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;
import org.omg.CORBA.ORB;
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

    
    public void click() {

    }

    protected void submit() {

    }

    
    public void sendKeys(CharSequence... keysToSend) {

    }

    
    public void pressKey(CharSequence keyToPress) {

    }

    
    public void releaseKey(CharSequence keyToRelease) {

    }

    protected void sendKeys(By locator, CharSequence... keysToSend) {
        waitForElementToBeClickable(locator).findElement(locator).sendKeys(keysToSend);
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

    protected String getText() {
        return null;
    }

    
    public void sendKeys(String keysToSend) {

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

    
    public void to(String url) {

    }

    
    public void to(URL url) {

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

    
    public boolean processCommand(String[] cmd, ORB orb, PrintStream out) {
        return false;
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
