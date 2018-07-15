package com.dice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().fullscreen();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String url = "https://www.dice.com";
	driver.get(url);
	String actualTitle = driver.getTitle();
	String expectedTitle = "Job Search for Technology Professionals | Dice.com";
	if(actualTitle.equals(expectedTitle)){
		System.out.println("Step PASS. Dice homepage successfully loaded.");
	} else {
	System.out.println("Step FAIL. Dice homepage did not loaded successfully.");
	throw new RuntimeException("Step FAIL. Dice homepage did not loaded successfully."); //will not continue testing, in fail case.
	}
	String keyword = "JavaScript Developer";
	driver.findElement(By.id("search-field-keyword")).clear();
	driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
	String location = "60625";
	driver.findElement(By.id("search-field-location")).clear();
	driver.findElement(By.id("search-field-location")).sendKeys(location);
	driver.findElement(By.id("findTechJobs")).click();
	
	String count = driver.findElement(By.id("posiCountId")).getText();
	System.out.println(count);
	int CountResult = Integer.parseInt(count.replace(",", ""));
	if (CountResult>0) {
		System.out.println("Step PASS. Keyword: " + keyword + " search returned - " + CountResult + " results in " + location );
		
		
	} else { 
		System.out.println("Step FAIL. Keyword: " + keyword + " search returned - " + CountResult + " results in " + location );
	}	
	driver.close();
	System.out.println("Test completed: " + LocalDateTime.now());
	

}
}