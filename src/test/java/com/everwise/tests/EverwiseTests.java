package com.everwise.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.everwise.pages.*;


public class EverwiseTests {
	private WebDriver driver;
	private String username = "test-student@geteverwise.com";
	private String password = "ewadmin123";
	//private HomePage hp;
	//private Missions missionpage;

	@BeforeMethod
	public void initialize(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://o26.ewhosts.net");
		}
	@AfterMethod
	public void cleanUp(){
		driver.quit();
		}


	@Test
	public void verifyNumberOfMissionsIsTwo()  {
		LoginPage loginpage = new LoginPage(driver);
		HomePage hp = loginpage.loginAs(username, password);
		boolean result = hp.TwoMissionsDisplayed();
		Assert.assertEquals(result,true);
		
	}

	@Test
	public void verifyMissionsListTitle() {
		LoginPage loginpage = new LoginPage(driver);
		HomePage hp = loginpage.loginAs(username, password);
		Missions missionpage = hp.navigateToMissions();
		missionpage.missionSort(3);
		//System.out.println(driver.getCurrentUrl());
		String title = missionpage.missionTitle();
		Assert.assertEquals(title,"You’ve had your first meeting, now what?");
	}

	

}
