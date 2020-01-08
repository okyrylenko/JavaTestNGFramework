package Foundation;

import Foundation.Enums.Browsers;
import Foundation.Enums.Environments;
import Foundation.utils.DriverListener;
import Foundation.utils.Report;
import Foundation.utils.ThreadManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;


public class BaseTest {
    private Properties props;


    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
        Report.start(context.getCurrentXmlTest().getSuite().getName());
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest(){

    }


    @BeforeGroups(alwaysRun = true)
    public void beforeGroup(){
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
    }


    @BeforeMethod(alwaysRun = true)
    @Parameters({"Browser", "Env"})
    public void beforeMethod(@Optional("Chrome") String browser, String env, ITestResult result, ITestContext context) throws IOException {
        ThreadManager.setSettings(new TestSettings());
        ThreadManager.getSettings()
                .setEnv(Environments.valueOf(env));
        ThreadManager.getSettings()
                .setBaseUrl(getValueForProperty( ThreadManager.getSettings().getEnv().toString() +".baseUrl"))
                .setBrowser(Browsers.valueOf(browser));
        System.out.println("opening " + ThreadManager.getSettings().getBrowser().toString() +" on  thread " + Thread.currentThread().getId());
        Report.setTestName(result.getMethod().getMethodName() + "_" + ThreadManager.getSettings().getBrowser().toString());
        switch (ThreadManager.getSettings().getBrowser()){
            case Chrome:
                WebDriverManager.chromedriver().setup();
                ThreadManager.setDriver(new ChromeDriver());
                break;
            case Firefox:
                WebDriverManager.firefoxdriver().setup();
                ThreadManager.setDriver(new FirefoxDriver());
                break;
        }

        ThreadManager.setWait(new WebDriverWait(ThreadManager.getDriver(), 5));

        ThreadManager.getDriver().manage().window().maximize();

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(ThreadManager.getDriver());
        DriverListener listeners = new DriverListener();
        eventDriver.register(listeners);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result){
        Report.setResult(result);
        ThreadManager.getDriver().quit();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){

    }
    @AfterGroups(alwaysRun = true)
    public void afterGroup(){

    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){

    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        Report.close();
    }

    private String getValueForProperty(String propertyName) throws IOException {
        if(props ==null) props = new Properties();

        String path = FilenameUtils.separatorsToSystem(System.getProperty("user.dir")+"\\src\\main\\resources\\runConfigurations\\config.properties");

        InputStream input = new FileInputStream(path);
        props.load(input);
        return props.getProperty(propertyName);
    }
}
