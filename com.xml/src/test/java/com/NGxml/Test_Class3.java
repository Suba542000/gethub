package com.NGxml;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Class3 {
	@Test
	public void validaccess() {
		
		WebDriverManager.edgedriver().setup();
       WebDriver driver = new EdgeDriver();
       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get("https://ktig.info/");
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
       WebElement Al = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Admin Login")));
       
      try {
       Al.click();
      }
      catch(org.openqa.selenium.ElementClickInterceptedException e){
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
    	    js.executeScript("arguments[0].click();", Al);

      }
      
      driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
      driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ktig@123");
      driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/button")).click();	
      driver.quit();
      
	}
	@Test
    public void imagePresentHome() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://ktig.info/");

        List<WebElement> KtigImage = driver.findElements(By.xpath("//img"));
        System.out.println("Total images found: " + KtigImage.size());

        // Loop through each image and take a screenshot
        for (int i = 0; i < KtigImage.size(); i++) {
            WebElement image = KtigImage.get(i);
            try {
                // Check if the image is displayed and has non-zero width and height
                if (image.isDisplayed() && image.getSize().getWidth() > 0 && image.getSize().getHeight() > 0) {
                    // Capture screenshot of the image element
                    File screenshot = image.getScreenshotAs(OutputType.FILE);
                    // Define file path for saving the screenshot
                    File destination = new File("C:\\Users\\ADMIN\\Desktop\\monish\\com.test\\src\\test\\java\\screenshot\\image_" + (i + 1) + ".png");
                    // Save the screenshot
                    FileHandler.copy(screenshot, destination);
                    System.out.println("Screenshot saved for image " + (i + 1) + " at: " + destination.getAbsolutePath());
                } else {
                    System.out.println("Skipping image " + (i + 1) + " as it is either not displayed or has zero size.");
                }
            } catch (IOException e) {
                System.out.println("Error capturing screenshot for image " + (i + 1) + ": " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error for image " + (i + 1) + ": " + e.getMessage());
            }
        }

        driver.quit();
    }
	@Test
	public  void NSAccess() {
		
		WebDriverManager.edgedriver().setup();
	       WebDriver driver = new EdgeDriver();
	       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	       driver.manage().window().maximize();
	       driver.get("https://ktig.info/");
	       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	       WebElement Al = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Admin Login")));
	       
	      try {
	       Al.click();
	      }
	      catch(org.openqa.selenium.ElementClickInterceptedException e){
	    	  JavascriptExecutor js = (JavascriptExecutor) driver;
	    	    js.executeScript("arguments[0].click();", Al);

	      }
	      
	      driver.findElement(By.xpath("//input[@name='username']")).sendKeys("vignesh");
	      driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
	      driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/button")).click();
	      try{
	    	  Alert alert =wait.until(ExpectedConditions.alertIsPresent());
	    	  System.out.println("Alert Text is: " + alert.getText());
	    	  alert.accept();
	      }
	      catch(Exception e) {
	    	  System.out.println(" No Alert is present ");
	      }
	      driver.quit();
	      
		}

	@Test
	public void screenshot() {
		
		  WebDriverManager.edgedriver().setup();
	        WebDriver driver = new EdgeDriver();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        driver.get("https://ktig.info/Bankingsolution");
	        List<WebElement> bankimage=driver.findElements(By.xpath("//img"));
	        System.out.println("Total image present :" +bankimage.size());
	       for(int i=0;i< bankimage.size();i++) {
	        	
	        	WebElement image = bankimage.get(i);
	        	try {
	        	if (image.isDisplayed() && image.getSize().getWidth()>0 && image.getSize().getHeight()>0) {
	        		
	        		File screenShot = image.getScreenshotAs(OutputType.FILE);
	        		File destination = new File("C:\\Users\\ADMIN\\Desktop\\monish\\com.test\\src\\test\\java\\screenshot\\bank\\image_" + (i + 1) + ".png");
	        		FileHandler.copy(screenShot,destination);
	        		System.out.println("Screeshot for saved images" + (i + 1) + "at:" + destination.getAbsolutePath());
	        	}else {
	        		System.out.println("skipping image" + (i + 1) + "as it is either not disaply or  has zero size");
	        	} 
	        	}catch (IOException e) {
	        		System.out.println("Error capturing screenshot for the image" + (i + 1 )+ ":" + e.getMessage());
	        	}catch(Exception e) {
	        		System.out.println("expected error for image" +(i + 1)+ ":" + e.getMessage());
	        	}
	        	
    driver.quit();

	        }
	        }

	
}

	




