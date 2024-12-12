package TestNg;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListnerPgm implements ITestListener //Press ctrl+click on ITestListner will show all the listner methods in the class
{
	
	public void onStart(ITestContext context) 
	{    //make default to public   //executed only once before starting all the test 
	    System.out.println("Test execution is started"); 
	  }
	public void onTestStart(ITestResult result)
	{   //will execute multiple times for multiple test b4 starting every test
	    System.out.println("test started");
	  }
	
	public void onTestSuccess(ITestResult result)
	{// trigger when a test is passed
		 System.out.println("test Passed");
	  }
	
	public void onTestFailure(ITestResult result) 
	{//trigger when a test is failed
		System.out.println("test Failed");
	   
	  }
	
	public void onTestSkipped(ITestResult result)
	{//trigger when a test is skipped
		System.out.println("test skipped");
	  }
	
	public void onFinish(ITestContext context) 
	{//trigger when a test is finished only once
		System.out.println("test finish");
		  }


}
