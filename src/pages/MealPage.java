package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage1 {

	public MealPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		
	}
	
	
	public WebElement getQInput () {
		return driver.findElement(By.xpath("//*[@name='product_qty']"));
	}
	
	
	public WebElement getAddToCart () {
		return driver.findElement(By.xpath("//*[@id='body']/section[1]/div/div/div[2]/div/div[3]/div[2]/a"));
	}

	public WebElement getAddtoFavorites () {
		return driver.findElement(By.xpath("/html/body/div[6]/section[1]/div/div/div[1]/div[1]/a"));
	}
	
	public void addMealToCart (String quantity) {
		this.getQInput().sendKeys(Keys.DELETE);
		this.getQInput().sendKeys(quantity);
		js.executeScript("arguments[0].click()", this.getAddToCart());
	}
	
	
	
	public void addMealToFavorites () {
		js.executeScript("arguments[0].click()", this.getAddtoFavorites());
	}
	
	
	
	
	
	
	
	
	
	
	
}
