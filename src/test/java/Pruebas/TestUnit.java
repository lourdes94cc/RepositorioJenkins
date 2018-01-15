package Pruebas;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;

public class TestUnit {

	public static String browserType = "";
	public static ManageWebDriver manageWebDriver;
	public static WebDriver driver;
	public static WebElement element;
	public static WebElement image = null;
	public static Date today;
	static DateFormat dfdateprint = new SimpleDateFormat("ddMMyy_HH_mm_ss");
	public String byConcatenado = "";
	static String BASE_URL = "https://www.google.com";
	private Log log;

	@BeforeMethod
	public void setUp() {
		try {
			log = LogFactory.getLog(TestUnit.class);
			Constantes.DRIVER_PATH = "C:\\testConfig\\Executor1\\DRIVERS\\";
			manageWebDriver = new ManageWebDriver(WebDrivers.CHROME);
			driver = manageWebDriver.getDriver();
		} catch (Exception e) {
			log.info("Ocurrio un error TestUnit - setUp() " + e.getMessage());
		}
	}

	@Test
	public void Main() {

		try {
			openURL(BASE_URL);

			setValue(By.id("lst-ib"), "nissan.com.mx");
			printScreen();
			element.sendKeys(Keys.ENTER);
			click(By.linkText("Nissan México"));
			printScreen();

			// Menu Vehìculos
			click(By.linkText("VEHÍCULOS"));
			espera(5000);
			printScreen();
			click(By.id("submenu_vehiclesFilters_overbarVehicles_lnkTodos"));
			espera(5000);
			concatenaGuardarImagen("Versa");
			//guardarImagen();
			click(By.linkText("VEHÍCULOS"));
		} catch (Exception e) {
			log.info("Ocurrio un error TestUnit - Main() " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	// Método de click
	public void click(By by) {
		element = driver.findElement(by);
		log.info(element.getText());
		element.click();
	}

	// Método establecer datos
	public void setValue(By by, String value) {
		element = driver.findElement(by);
		element.sendKeys(value);
	}

	// Método para abrir url
	public void openURL(String url) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	// Método de selección de Combo
	public void setCombo(By by, String value) {
		element = driver.findElement(by);
		Select opcion = new Select(element);
		element.click();
		opcion.selectByValue(value);
	}

	private void printScreen() {
		String imgName = dateToStringPrint() + Constantes.DEFAULT_IMAGE_EXTENSION;
		String imgPath = Constantes.SCREENS_PATH + imgName;
		printScreen(imgPath);
	}

	public void printScreen(String pathImage) {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(pathImage));
		} catch (TimeoutException e) {
			log.error("Ocurrio un error printScreen() " + e.getMessage());
		} catch (Exception e) {
			log.error("Ocurrio un error printScreen() " + e.getMessage());
		}
	}

	public static String dateToStringPrint() {
		today = Calendar.getInstance().getTime();
		return dfdateprint.format(today);
	}

	// Metodo de espera...
	public void espera(int millisegundos) throws InterruptedException {
		Thread.sleep(millisegundos);
	}

	// Concatenacion de imagen a guardar
	public String concatenaGuardarImagen(String nombreCarro) {

		byConcatenado = "vehiclefilters_filtrodosautos_" + nombreCarro;
		return byConcatenado;
	}

	// Guardar imagen
	public void guardarImagen() throws AWTException, InterruptedException {

		image = driver.findElement(By.id(byConcatenado));
		Actions action = new Actions(driver);
		action.contextClick(image).build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_D);
		espera(15000);
		robot.keyPress(KeyEvent.VK_ENTER);
		espera(6000);
	}

}