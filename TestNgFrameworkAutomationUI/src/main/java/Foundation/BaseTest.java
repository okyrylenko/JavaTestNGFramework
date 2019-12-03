package Foundation;

import Foundation.Enums.Browsers;
import Foundation.Enums.Environments;
import Foundation.utils.Report;
import UIComponents.LogInPage;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.inject.Inject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    private Properties props;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"Env"})
    public void beforeSuite(ITestContext context, @Optional("Production") String env) throws IOException {
        TestSettings.env = Environments.valueOf(env);
        TestSettings.baseUrl = getValueForProperty(TestSettings.env+".baseUrl");
        Report.start(context.getName());
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
    @Parameters({"Browser"})
    public void beforeMethod(@Optional("Chrome") String browser,ITestResult result){
        TestSettings.browser = Browsers.valueOf(browser);
        System.out.println("opening " + TestSettings.browser +" on  thread " + Thread.currentThread().getId());
        Report.setTestName(result.getMethod().getMethodName());
        switch (TestSettings.browser){
            case Chrome:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case Firefox:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }

        wait = new WebDriverWait(driver,5);

        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result){
        Report.setResult(result);
        driver.quit();
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
