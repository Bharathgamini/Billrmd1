package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; // log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger; // for log4j
	public Properties p;
	@SuppressWarnings("deprecation")
	@BeforeClass(groups= {"Sanity", "Regression", "Master"})
	@Parameters({"OS","browser"})
	public void setup(String os, String br) throws IOException
	{
		
		// loading config. properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			//os
			// rightnow in my system it was not taking the mac platform so, i am commenting the os code.
//			if(os.equalsIgnoreCase("mac"))
//			{
//				cap.setPlatform(Platform.MAC);
//				System.out.println("Mac system");
//			}
//			if(os.equalsIgnoreCase("windows"))
//			{
//				cap.setPlatform(Platform.WIN11);
//				System.out.println("windows system");
//
//			}
//			if(os.equalsIgnoreCase("Linix"))
//				{
//					cap.setPlatform(Platform.LINUX);
//					System.out.println("windows system");
//	
//				}
//			else
//			{
//				System.out.println("No matching OS");
//				return;
//			}
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome"); break;
			case "firefox": cap.setBrowserName("firefox"); break;

			case "safari": cap.setBrowserName("safari"); break;
			default: System.out.println("browser is invalid"); return;
			}
			System.out.println("Browser launched");
			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), cap);
			
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
		
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;

		case "safari": driver = new SafariDriver(); break;
		default: System.out.println("browser is invalid"); return;
		}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL")); // reading URL from properties file
		
		driver.manage().window().maximize();
	
	}
	
	@AfterClass(groups= {"Sanity", "Regression", "Master"})
	public void tearDown()
	{
		driver.quit();
		
	}
	
	
	// for generating the random string
		// depreceation used for current version not supporting error.
		//@SuppressWarnings("deprecation")
		public String randomeString()
		{
			String generatedstring = RandomStringUtils.randomAlphabetic(5);
			return generatedstring;
		}
		
		
		// for generating the random numbers
		//@SuppressWarnings("deprecation")
		public String randomeNumeric()
		{
			String generatednumber = RandomStringUtils.randomNumeric(10);
			return generatednumber;
		}
		
		// for generating the randome alpha numerics
		//@SuppressWarnings("deprecation")
		public String randomeAlphaNumeric()
		{
			String generatedstring = RandomStringUtils.randomAlphabetic(3);
			String generatednumber = RandomStringUtils.randomNumeric(3);
			return (generatedstring+generatednumber);
		}
		
		public String captureScreen(String tname) throws IOException
		{
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath = System.getProperty("user.dir")+"/screenshots/"+tname+"_"+timeStamp;
			File targetFile = new File(targetFilePath);
			sourceFile.renameTo(targetFile);
			
			return targetFilePath;
		}

}
