package pages.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	
	public static WebDriver driver;
	public static FileInputStream fis=null;
	public static Properties Config=new Properties();
	public static Logger log=Logger.getLogger(Page.class);
	public static WebDriverWait wait;
	public static String browser;
	public static int count=0;
	
	
	public static void initConfiguration(){
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\log4j.properties");
				
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("Loaded Config properties file");
		
		
		String browser=System.getProperty("browser");
		System.out.println("Need to launch browser " + browser);
		if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");

			driver = new FirefoxDriver();
			log.debug("Launching Firefox");
		}else if(browser.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

			driver = new ChromeDriver(options);
			log.debug("Launching Chrome");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicitWait")), TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicitWait")));
				
	}
	
	
	public static void click(WebElement element) {

		element.click();
		log.debug("Clicking on an Element : "+element);
	}
	
	
	public static void type(WebElement element, String value) {

		element.sendKeys(value);

		log.debug("Typing in an Element : "+element+" entered value as : "+value);
		
			}
	
	public static void quitBrowser(){
		
		driver.quit();
		
	}
	
}
