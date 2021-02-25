package tests;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

public abstract class BasicTest {

	
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected NotificationSistemPage notificationSistemPage;
	protected ProfilePage profilePage;
	protected MealPage mealPage;
	protected LoginPage loginPage;
	protected LocationPopupPage locationPopUpPage;
	protected CartSummaryPage cartSummaryPage;
	protected AuthPage authPage;
	protected String baseUrl;
	protected String email;
	protected String password;
	protected JavascriptExecutor js;
	
	@BeforeClass
	
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.waiter = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;
		this.notificationSistemPage = new NotificationSistemPage(driver, waiter, js);
		this.profilePage = new ProfilePage(driver, waiter, js);
		this.mealPage = new MealPage(driver, waiter, js);
		this.loginPage = new LoginPage(driver, waiter, js);
		this.locationPopUpPage = new LocationPopupPage(driver, waiter, js);
		this.cartSummaryPage = new CartSummaryPage(driver, waiter, js);
		this.authPage = new AuthPage(driver, waiter, js);
		this.baseUrl = "http://demo.yo-meals.com/";
		this.email = "customer@dummyid.com";
		this.password = "12345678a";
		
		
		
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	
	
	@AfterMethod
		public void takeScreenshot(ITestResult result) throws HeadlessException, AWTException, IOException {
			String testTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.jpg'").format(new Date());
			if (ITestResult.FAILURE == result.getStatus()) {
			BufferedImage screenshoot = new Robot()
			.createScreenCapture((new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())));
			File screenshot = new File("screenshot.jpg");
			ImageIO.write(screenshoot, "jpg", new File("screenshots\\" + testTime));
		
	}driver.manage().deleteAllCookies();
	
		}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
}
