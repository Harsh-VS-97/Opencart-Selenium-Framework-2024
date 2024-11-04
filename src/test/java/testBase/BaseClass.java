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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;    //For Log4j
import org.apache.logging.log4j.Logger;        //For Log4j

public class BaseClass {
	
	public static WebDriver driver;
	public Logger Logger;
	public Properties Pr;
	
	@SuppressWarnings("deprecation")
	@Parameters({"os","browser"})
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	public void Setup(String OS,String BR) throws IOException {
		
		//Loading config.Properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		Pr=new Properties();
		Pr.load(file);
		
		Logger = LogManager.getLogger(this.getClass()); // For Log4j
		
		
		//For running in Selenium grid(single remote machine)
		if(Pr.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(OS.equalsIgnoreCase("Windows")) {
				
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(OS.equalsIgnoreCase("Mac")) {
				
				capabilities.setPlatform(Platform.MAC);
			}
			else if(OS.equalsIgnoreCase("Linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			
			else {
				System.out.println("No matching system");
				return;
			}
			
			switch(BR.toLowerCase()) {
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox" : capabilities.setBrowserName("firefox"); break;
			default : System.out.println("No matching browser"); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities); //Creating remote webdriver for selenium grid
			
		}
		
		//For running in Local machine
		if(Pr.getProperty("execution_env").equalsIgnoreCase("local")) {
		//switching browser using switch and taking it from master.xml
			if(OS.equalsIgnoreCase("Windows")) {
		switch(BR.toLowerCase()) {
		case "chrome": driver = new ChromeDriver(); break;
		case "edge":   driver = new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		default: System.out.println("Invalid Browser");return;
		}
		}
		}
			
		driver.get(Pr.getProperty("URL")); //Reading URL from config.properties
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}	
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void teardown() {
		
		driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	public String randomString() {
		
		String randString=RandomStringUtils.randomAlphabetic(5);
		return randString;
	}
	
	@SuppressWarnings("deprecation")
	public String randomNumber() {
		
		String randNumber=RandomStringUtils.randomNumeric(10);
		return randNumber;
	}
	
	@SuppressWarnings("deprecation")
	public String randomAlphaNumeric() {
		
		String randString=RandomStringUtils.randomAlphabetic(5);
		String randNumber=RandomStringUtils.randomNumeric(5);
		
		return (randString+"@"+randNumber);
	}
	
	//For capturing failes test cases screenshots in Extent Report
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
