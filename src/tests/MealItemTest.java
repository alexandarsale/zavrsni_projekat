package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest {

	
	
	
	@Test(priority = 1)
public void addMealToCartTest() throws InterruptedException {
	
		
this.driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
	
locationPopUpPage.ClosePopUp();
mealPage.addMealToCart("3");

Assert.assertTrue(notificationSistemPage.MessageText().contains("The Following Errors Occurred:"),
		"[ERROR]: Error message was not displayed.");
Assert.assertTrue(notificationSistemPage.MessageText().contains("Please Select Location"),
		"[ERROR]: Please Select Location message was not displayed.");
notificationSistemPage.waitNotification();

locationPopUpPage.openPopUp();
locationPopUpPage.setLocation("City Center - Albany");
Thread.sleep(1000);

	mealPage.addMealToCart("3");
	Assert.assertTrue(notificationSistemPage.MessageText().contains("Meal Added To Cart"),
			"[ERROR]: Meal Added message was not displayed.");
	}
	
	
	@Test (priority = 2)
	public void addMealToFavorite () throws InterruptedException {
	driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
	locationPopUpPage.ClosePopUp();
	Thread.sleep(3000);
	mealPage.addMealToFavorites();
	
	Assert.assertTrue(notificationSistemPage.MessageText().contains("Please login first!"),
			"[ERROR]:Please login message was not displayed.");
	
	notificationSistemPage.waitNotification();
	driver.navigate().to(baseUrl + "/guest-user/login-form");
	loginPage.UserLogin("customer@dummyid.com", "12345678a");
	
	
	driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
	
	mealPage.addMealToFavorites();
	Thread.sleep(1000);
	
	Assert.assertTrue(notificationSistemPage.MessageText().contains("Product has been added to your favorites."),
			"[ERROR]:Product added message was not displayed.");
	
	
	}
	
	
	@Test(priority = 3)
	
	public void clearCart() throws IOException, InterruptedException  {
		
		driver.navigate().to(baseUrl + "/meals");
		
		SoftAssert sa = new SoftAssert();
		locationPopUpPage.setLocation("City Center - Albany");
		
		// Import xlsx
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Meals");
	
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			XSSFRow row = sheet.getRow(i);

			XSSFCell meals = row.getCell(0);
			String links = meals.getStringCellValue();

			this.driver.navigate().to(links);
			Thread.sleep(3000);
			mealPage.addMealToCart("1");

			sa.assertTrue(notificationSistemPage.MessageText().contains("Meal Added To Cart"),
					"[ERROR]:Meal added message was not displayed.");
			notificationSistemPage.waitNotification();
		}
		sa.assertAll();
	
		cartSummaryPage.ClearAlllBtn();
		
		Assert.assertTrue(notificationSistemPage.MessageText().contains("All meals removed from Cart successfully"),
				"[ERROR]: Meals removed message was not displayed.");

		workbook.close();
		fis.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
