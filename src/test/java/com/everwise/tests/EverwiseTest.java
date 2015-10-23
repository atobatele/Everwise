package com.everwise.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.everwise.pages.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;



public class EverwiseTest {
	private WebDriver driver;
	private String username = "test-student@geteverwise.com";
	private String password = "ewadmin123";

	public static final String USERNAME = "kayode";
  	public static final String ACCESS_KEY = "49582d86-2047-44fe-9f8a-48ba7af573fd";
  	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	//private HomePage hp;
	//private Missions missionpage;

	@BeforeMethod
	public void initialize() throws Exception {


		//driver = new FirefoxDriver();
		
		 DesiredCapabilities caps = DesiredCapabilities.chrome();
    	caps.setCapability("platform", "Windows XP");
    	caps.setCapability("version", "43.0");

    	WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
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
		Assert.assertEquals(title,"You�ve had your first meeting, now what?");
	}

	

}
