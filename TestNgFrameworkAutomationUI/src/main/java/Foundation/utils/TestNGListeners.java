package Foundation.utils;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestNGListeners implements ITestListener, ISuiteListener, IExecutionListener, IInvokedMethodListener, IAnnotationTransformer{

    public void onTestStart(ITestResult result) {
        System.out.println("Test '" + result.getName() + "' started");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test '"+ result.getName() + "' succeeded");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test '"+ result.getName() + "' failed. Exception - '"+result.getThrowable()+"'");

    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test '"+ result.getName() + "' skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test '"+ result.getName() + "' failed with successful percentage");
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Test '"+ result.getName() + "' timed out");
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        System.out.println("Group '" + context.getName() + "' started");
    }

    public void onFinish(ITestContext context) {
        System.out.println("Group- '" + context.getName() + "' finished");
    }

    public void onStart(ISuite suite) {
        System.out.println("Starting suite -'" + suite.getName()+"'");
    }

    public void onFinish(ISuite suite) {
        System.out.println("Finishing suite -'" + suite.getName()+"'");
    }
    public void onExecutionStart() {
        System.out.println("On execution start");
    }

    public void onExecutionFinish() {
        System.out.println("On execution finish");
    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        System.out.println("method '" + method.getTestMethod().getMethodName() + "' in '"+ context.getName()+"' starting");
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        System.out.println("method '" + method.getTestMethod().getMethodName() + "' in '"+ context.getName()+"' finished");
    }



}
