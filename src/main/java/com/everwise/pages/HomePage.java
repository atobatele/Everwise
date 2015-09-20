package com.everwise.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	    private final WebDriver driver;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;

	       
	    }

	    // The Home page contains several HTML elements that will be represented as WebElements.
	    // The locators for these elements should only be defined once.
	       
	        //By tag = By.tagName("ew-user-mission-card");
	        By mission1 = By.id("user_mission_0");
	        By mission2 = By.id("user_mission_1");
	     
	        By findMissions =By.xpath("//*[@id='add-mission']/div/div/a[1]/i");
	        
	        





	    // Conceptually, the login page offers the user the service of being able to "log into"
	    // the application using a user name and password. 
	    public  boolean TwoMissionsDisplayed() {
	    	
	    	if (driver.findElement(mission1).isDisplayed()&& driver.findElement(mission2).isDisplayed()){
	    		return true;
	    	} 
	    	
	    	return false;
	         
	    }
	    
	    public Missions navigateToMissions(){
	    	
	    	driver.findElement(findMissions).click();
	    	
	    	return new Missions(driver);
	    }
	

}
