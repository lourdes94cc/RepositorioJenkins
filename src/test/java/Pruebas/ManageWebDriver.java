package Pruebas;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ManageWebDriver {
	private final Log log = LogFactory.getLog(ManageWebDriver.class);
	private static String CHROME_DRIVER  = "chromedriver";
	
	private WebDriver webDriver;
	WebDrivers driver;
	
	public ManageWebDriver(WebDrivers driver){
		 this.driver = driver;
	}
	
	public WebDriver getDriver() {
        switch (driver) {
            case CHROME:
            	ChromeOptions options = new ChromeOptions();
            	Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
               // options.setExperimentalOption("prefs", prefs);
                options.addArguments("--dns-prefetch-disable");
                if(!Constantes.isMAC){
                	if(!StringUtils.contains(CHROME_DRIVER, ".exe")){
                		CHROME_DRIVER = CHROME_DRIVER + ".exe";
                    }
                }
                
            	System.setProperty("webdriver.chrome.driver", Constantes.DRIVER_PATH + CHROME_DRIVER);
            	webDriver = new ChromeDriver(options);
            	webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            	log.info("ChromeDriver");
            	
                break;
                    
            default:
            	log.info("No definido");
                break;
        }
        return webDriver;
    }

}