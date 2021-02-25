package tests;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	@Test (priority = 0)
	
	public void editProfileImage () throws Exception {
		driver.navigate().to(baseUrl + "/guest-user/login-form");
		locationPopUpPage.ClosePopUp();
		loginPage.UserLogin("customer@dummyid.com", "12345678a");
		
		boolean UserLogin = notificationSistemPage.MessageText().contains("Login Successfull");
		assertTrue(UserLogin, "[ERROR] Login Failed!");
	
		driver.navigate().to(baseUrl + "/member/profile");
		profilePage.changePersonalInformation("Roland", "Dubois", "222", "9992211133", "185203", "United Kingdom", "Aberdeen", "Cleveland");
		boolean setup = notificationSistemPage.MessageText().contains("Setup Successful");
		
		
		assertTrue(setup, "[ERROR] Setup failed!");
		
		
		authPage.UserLogout();
		boolean logout = notificationSistemPage.MessageText().contains("Logout Successfull");
		assertTrue(logout, "[ERROR] Logout failed!");
	}
	
	
	@Test (priority = 5)
	
	public void changeProfileImage () throws InterruptedException, IOException {
		driver.navigate().to(baseUrl + "/guest-user/login-form"); 
	
		locationPopUpPage.ClosePopUp();
		loginPage.UserLogin("customer@dummyid.com", "12345678a");
		Assert.assertTrue(notificationSistemPage.MessageText().contains("Login Successfull"));
		
		
		driver.navigate().to(baseUrl + "/member/profile");
		Thread.sleep(3000);
		
		String imgPath = new File("img/slika.png").getCanonicalPath();
		
		
		//UploadImg
		profilePage.uploadPicture(imgPath);
		Assert.assertTrue(notificationSistemPage.MessageText().contains("Profile Image Uploaded Successfully"), "ERROR - Upload successfully message was not displayed.");
		notificationSistemPage.waitNotification();
		
		
		//DeleteInmg
		profilePage.deleteProfilePhoto();
		Assert.assertTrue(notificationSistemPage.MessageText().contains("Profile Image Deleted Successfully"), "ERROR - Delete message was not displayed.");
		
		notificationSistemPage.waitNotification();
		
		Thread.sleep(1000);
		authPage.UserLogout();
		Assert.assertTrue(notificationSistemPage.MessageText().contains("Logout Successfull!"),
				"[ERROR]: Logout message was not displayed.");
		
		
	} 
	
	
	
	
}
