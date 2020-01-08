package Foundation.utils;

import Foundation.TestSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThreadManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    private static ThreadLocal<TestSettings> settings = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver dr) {
        driver.set(dr);
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    public static void setWait(WebDriverWait w) {
        wait.set(w);
    }

    public static TestSettings getSettings() {
        return settings.get();
    }

    public static void setSettings(TestSettings s) {
        settings.set(s);
    }
}
