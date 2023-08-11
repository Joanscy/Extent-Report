package extentReportExmp;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReportExample {
	
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter sparkReporter;
	ExtentTest testCase;
	
 		@Test
 		public void openGoogle() throws IOException
 		{
 			testCase = extentReports.createTest("verify google title");
 			testCase.log(Status.INFO, "navigating to google");
 			
 			driver.get("https://www.google.com/");
 			String title = driver.getTitle();
 		
 			testCase.log(Status.INFO, "Actual title :"+ title);
 			testCase.log(Status.INFO, "Expected title :"+ "google");
 			testCase.log(Status.INFO, "verification of acutal and expected title");
 			if(title.equals("google"))
 			{
 				testCase.log(Status.PASS, "actual title and expected title are equal");
 				System.out.println(" google is passed");
 			}else {
 				testCase.log(Status.FAIL, "actual title and expected title are not equal");
 				System.out.println("google is failed");
 				
 				TakesScreenshot scrShot =(TakesScreenshot)driver;
 				File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
 				File desFile=new File("google.png");
 				FileHandler.copy(srcFile, desFile);
 				testCase.addScreenCaptureFromPath("google.png");
 				
 			
 			}
 		}
		
 		@Test
 		public void openBing() throws IOException
 		{
 			testCase = extentReports.createTest("verify bing title");
 			testCase.log(Status.INFO, "navigating to bing");
 			
 			driver.get("https://www.bing.com/");
 			String title = driver.getTitle();
 		
 			testCase.log(Status.INFO, "Actual title :" + title);
 			testCase.log(Status.INFO, "Expected title :" + "bing");
 			testCase.log(Status.INFO, "verification of acutal and expected title");
 			
 			if(title.equals("bing"))
 			{
 				testCase.log(Status.PASS, "actual title and expected title are equal");
 				System.out.println("bing is passed");
 			}else {
 				testCase.log(Status.FAIL, "actual title and expected title are not equal");
 				System.out.println("bing is failed");
 				
 				TakesScreenshot scrShot =(TakesScreenshot)driver;
 				File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
 				File desFile=new File("bing.png");
 				FileHandler.copy(srcFile, desFile);
 				testCase.addScreenCaptureFromPath("bing.png");
 				
 			}
 		}

 		@Test
 		public void openWikipedia() throws IOException
 		{
 			testCase = extentReports.createTest("verify wikipedia title");
 			testCase.log(Status.INFO, "navigating to wikipedia");
 			driver.get("https://www.wikipedia.org/");
 			String title = driver.getTitle();
 			
 			testCase.log(Status.INFO, "Actual title :"+ title);
 			testCase.log(Status.INFO, "Expected title :"+ "Wikipedia");
 			
 			if(title.equals("Wikipedia"))
 			{
 				testCase.log(Status.PASS, "actual title and expected title are equal");
 				System.out.println(" wiki is passed");
 			}else {
 				testCase.log(Status.FAIL, "actual title and expected title are not equal");
 				System.out.println(" wiki is failed");
 				TakesScreenshot scrShot =(TakesScreenshot)driver;
 				File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
 				File desFile=new File("wiki.png");
 				FileHandler.copy(srcFile, desFile);
 				testCase.addScreenCaptureFromPath("wiki.png");
 			}
 		}
 		
 		@BeforeSuite
 		public void launchBrowser()
 		{
 			extentReports = new ExtentReports();
 			sparkReporter = new ExtentSparkReporter("ExtentReport.html");
 			extentReports.attachReporter(sparkReporter);
 			driver = new ChromeDriver();
 			
 		}

 		@AfterSuite
 		public void CloseBrowser()
 		{
 		driver.quit();
 		extentReports.flush();
 			
 		}
 		
 		
	}


