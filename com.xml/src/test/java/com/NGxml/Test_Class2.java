package com.NGxml;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Class2 {
	
	@Test
	public void logoImageIdentification() {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver =new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ktig.info/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		try {
		WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id=\"root\"]/div/div/div[1]/nav/a/div/h1/img")));
		
		if(image.isDisplayed()) {
		System.out.println(" logo is displayed");
		}
		else {
			System.out.println(" logo is not displayed ");
		}
		}
		catch(Exception e) {
			System.out.println(" Exception occured :" + e.getMessage());
		}finally {
			driver.quit();
		}

}
	@Test
	public void KTIGWebMousehover() {
		
		WebDriverManager.edgedriver().setup();
         WebDriver driver =new EdgeDriver();
         driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
         driver.manage().window().maximize();
         driver.get("https://ktig.info/");
         WebElement services = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/div[1]/div/a"));
         Actions actions =new Actions(driver);
         actions.moveToElement(services).build().perform();
         driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
         driver.quit();
	}

	@Test
	public void imagePresent() {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver =new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ktig.info/");
		List<WebElement> KtigImage = driver.findElements(By.xpath("//img"));
		System.out.println(KtigImage.size());
		driver.quit();
	}
}

	

