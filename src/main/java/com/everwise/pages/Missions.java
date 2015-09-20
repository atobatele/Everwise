package com.everwise.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Missions {
		
	    private final WebDriver driver;

	    public Missions(WebDriver driver) {
	        this.driver = driver;

	       
	    }
	    By tagname = By.tagName("option");
	    By ewCard = By.xpath(".//*[@id='ng-app']/body/div[3]/div/div/div[3]/div[2]/div[2]/div[2]/div/ew-mission-card[1]/div/div/div[2]/p");
	    
	    
	    public void missionSort(int option){
	    	
	    	List<WebElement> webelems = driver.findElements(tagname);
	    	//System.out.println(webelems.get(3).getAttribute("value"));
	    	webelems.get(option).click();
	    	
	    }
	    public String missionTitle(){
	    	String title = driver.findElement(ewCard).getText();
	    	return title;
	    }
}
