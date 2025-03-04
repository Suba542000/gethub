package com.NGxml;


import java.time.Duration; // Import Duration class
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Class1 {
	
	
	
		
		
		@Test
		
		public void Textknown() {
			
			WebDriverManager.edgedriver().setup();
	        WebDriver driver = new EdgeDriver();
	        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        driver.get("https://ktig.info/Aboutpage");
	     
	        
	        WebElement KtigWord = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/body/div[4]/div/div/div/div[1]/h1"));
	        KtigWord.click();
	        
	        String headingText = KtigWord.getText();
	        System.out.println(" the text recived is " + headingText);
	        
	        driver.quit();
	        }

	}

	

