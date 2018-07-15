package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Herokuapp {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().fullscreen();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String url = "http://the-internet.herokuapp.com/dynamic_controls";
	driver.get(url);
	driver.findElement(By.id("btn")).click();
	String mes = driver.findElement(By.id("message")).getText();
	System.out.println("Message: " + mes );
	driver.close();

	
}
}
