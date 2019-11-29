package Foundation.utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {

    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentTest test;

    public static void start(String runName){
        String path = System.getProperty("user.dir")+"\\src\\test\\reports\\"+runName + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".html";
        htmlReporter = new ExtentHtmlReporter(path);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void setTestName(String name){
        test = extent.createTest(name);
    }

    public static void setResult(ITestResult result){
        switch(result.getStatus()) {
            case 0:
                test.pass("passed");
                break;
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
                test.fail("fail");
                break;
            case 2:
            case 3:
                test.skip("skip");
                break;
        }
    }

    public static void close() {
        extent.flush();
    }
}
