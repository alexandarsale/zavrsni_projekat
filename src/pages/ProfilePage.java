package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage1 {

	public ProfilePage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		
	}
	
	public WebElement getFristName () {
		return driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastName () {
		return driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getEmail () {
		return driver.findElement(By.name("user_email"));
	}

	public WebElement getAddress () {
		return driver.findElement(By.name("user_address"));
	}
	
	public WebElement getPhoneNum () {
		return driver.findElement(By.name("user_phone"));
	}
	
	public WebElement getZipCode () {
		return driver.findElement(By.name("user_zip"));
	}
	
	public Select getCountry () {
		WebElement country = driver.findElement(By.name("user_country_id"));
		Select se1 = new Select (country);
		return se1;
	}
	
	public Select getState () {
		WebElement state = driver.findElement(By.name("user_state_id"));
		Select se2 = new Select (state);
		return se2;
	}
	
	
	public Select getCity () {
		WebElement city = driver.findElement(By.name("user_city"));
		Select se3 = new Select (city);
		return se3;
	}
	
	public WebElement getSavePersonalInfo () {
		return driver.findElement(By.xpath("//*[@class='row'][5]/input"));
	}
	
	
	public WebElement getUploadButn () {
		return driver.findElement(By.xpath("//a[@title='Upload']"));
	}
	
	public WebElement getRemoveBtn () {
		return driver.findElement(By.xpath("//a[@title='Remove']"));
	}
	
	public WebElement getUpload () {
		return driver.findElement(By.xpath("//*[@type='file']"));
	}
	
	public void uploadPicture (String picture) {
		this.js.executeScript("arguments[0].click();", this.getUploadButn());
		this.getUploadButn().sendKeys(picture);
	}
	
	public void deleteProfilePhoto () {
		this.js.executeScript("arguments[0].click();", this.getRemoveBtn());
	}
	
	
	public void changePersonalInformation (String firstName, String lastName, String address, String phoneNum,
			String zipCode, String country, String state, String city) throws Exception {
		
		this.getFristName().clear();
		this.getLastName().clear();
		this.getAddress().clear();
		this.getPhoneNum().clear();
		this.getZipCode().clear();
		
		this.getFristName().sendKeys(firstName);
		this.getLastName().sendKeys(lastName);
		this.getAddress().sendKeys(address);
		this.getPhoneNum().sendKeys(phoneNum);
		this.getZipCode().sendKeys(zipCode);
		
		this.getCountry().selectByVisibleText(country);
		Thread.sleep(1000);
		
		this.getState().selectByVisibleText(state);
		Thread.sleep(1000);
		
		this.getCity().selectByVisibleText(city);
		
		this.getSavePersonalInfo().click();
	}
	
	
	
}
