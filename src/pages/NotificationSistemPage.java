package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage1 {

	public NotificationSistemPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}
	
	public WebElement getMessage () {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]\r\n" + 
				""));
	}
	
	public String MessageText() {
		return this.getMessage().getText();
	}
	
	
	public void waiting () {
		waiter.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[contains(@class, 'system_message')]"), "Login Successfull"));
	}

}
