package Foundation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class DriverListener extends AbstractWebDriverEventListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        System.out.println("method '" + method.getTestMethod().getMethodName() + "' in '"+ context.getName()+"' starting");
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        System.out.println("method '" + method.getTestMethod().getMethodName() + "' in '"+ context.getName()+"' finished");
    }


    @Override
    public void beforeAlertAccept(WebDriver driver) {
        System.out.println("before Alert accepted on page" + driver.getCurrentUrl());
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        System.out.println("after Alert accepted on page" + driver.getCurrentUrl());
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        System.out.println("before Alert dismissed on page" + driver.getCurrentUrl());
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        System.out.println("after Alert dismissed on page" + driver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("before navigating to page" + driver.getCurrentUrl());
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("after navigating to page" + driver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("before navigating back to page" + driver.getCurrentUrl());
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("after navigating to page" + driver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("before navigating forward to page" + driver.getCurrentUrl());
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("after navigating forward to page" + driver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        System.out.println("before navigate refresh on page" + driver.getCurrentUrl());
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        System.out.println("after navigate refresh on page" + driver.getCurrentUrl());
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        if(by !=null){
            System.out.println("Trying to find element" + by.toString());
        }else if(element !=null){
            System.out.println("Trying to find element" + element.toString());
        }else{
            System.out.println("no element was provided when trying to search for element");
        }
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        if(by !=null){
            System.out.println("Found element" + by.toString());
        }else if(element !=null){
            System.out.println("Found element" + element.toString());
        }else{
            System.out.println("no element was provided when trying to search for element");
        }
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click element " + element.toString() + " on page " +driver.getCurrentUrl());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("clicked element " + element.toString() + " on page " +driver.getCurrentUrl());
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Trying to send value to  element " + element.toString() + " on page " +driver.getCurrentUrl());
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Trying to send value to  element " + element.toString() + " on page " +driver.getCurrentUrl());
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        System.out.println("Before executing script " + script + " on page " + driver.getCurrentUrl());
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        System.out.println("After executing script " + script + " on page " + driver.getCurrentUrl());
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Before switching to window " + windowName + " on page "+ driver.getCurrentUrl());
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("After switching to window " + windowName + " on page "+ driver.getCurrentUrl());
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        System.out.println("Trying to get text from element " + element.toString() + " on page "+ driver.getCurrentUrl());
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        System.out.println("After to get text from element " + element.toString() + " on page "+ driver.getCurrentUrl());
    }
}
