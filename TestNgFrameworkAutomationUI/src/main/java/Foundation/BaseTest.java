package Foundation;

import UIComponents.LogInPage;
import com.google.inject.Inject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }

    @BeforeTest
    public void beforeTest(){
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
    public void beforeMethod(){
        System.out.println("before method");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,3000);

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
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
        System.out.println("after suite");
    }
}
