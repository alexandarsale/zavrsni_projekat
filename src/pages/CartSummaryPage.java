package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage1{

	public CartSummaryPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		
	}
	
	public WebElement getClearAllBtn () {
		return driver.findElement(By.xpath("//*[@id='cartSummary']/div/div[1]/a[2]"));
	}

	public void ClearAlllBtn () {
		this.getClearAllBtn().click();
	}
	
	
}
