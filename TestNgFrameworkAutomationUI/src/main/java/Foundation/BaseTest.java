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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeSuite
    @Parameters({"Env"})
    public void beforeSuite(ITestContext context, @Optional String env)
    {
        TestSettings.env = env == null?Environments.valueOf("Production"):Environments.valueOf(env);
        Report.start(context.getName());
        System.out.println("before suite");
    }

    @BeforeTest
    @Parameters({"Browser"})
    public void beforeTest(@Optional String browser){
        TestSettings.browser = browser ==null? Browsers.valueOf("Chrome"):Browsers.valueOf(browser);
        System.out.println("before test");
    }


    @BeforeGroups
    public void beforeGroup(){
        System.out.println("before group");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("before class");
    }


    @BeforeMethod
    public void beforeMethod(ITestResult result){
        Report.setTestName(result.getMethod().getMethodName());
        System.out.println("before method");
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

    @AfterMethod
    public void afterMethod(ITestResult result){
        Report.setResult(result);
        System.out.println("after method");
        driver.quit();
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }
    @AfterGroups
    public void afterGroup(){
        System.out.println("after group");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }

    @AfterSuite
    public void afterSuite(){
        Report.close();
        System.out.println("after suite");
    }
}
