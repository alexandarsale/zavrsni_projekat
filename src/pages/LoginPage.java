package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage1{

	public LoginPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	
	public WebElement getEmail () {
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword () {
		return driver.findElement(By.name("password"));
	}
	
	public WebElement getRememberMe () {
		return driver.findElement(By.name("remember_me"));
	}
	
	public WebElement getLoginBtn () {
		return driver.findElement(By.name("btn_submit"));
	}
	
	
	public void UserLogin (String email, String password) {
		this.getEmail().clear();
		
		this.getEmail().sendKeys(email);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		this.getRememberMe().click();
		this.getLoginBtn().click();
	}
	
}
