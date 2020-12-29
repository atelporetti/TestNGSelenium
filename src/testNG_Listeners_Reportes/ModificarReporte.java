package testNG_Listeners_Reportes;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ModificarReporte implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started --> " + result.getName());
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Pass --> " + result.getName());
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed --> " + result.getName());
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped --> " + result.getName());
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Execution (Test) : " + context.getName());
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("End of Execution (Test) : " + context.getName());
		ITestListener.super.onFinish(context);
	}
	
}
