package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	
	@Test
	public void LoginSignupTC001(){
			
			
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
			driver.get("http://3.108.235.33:8000/");
			WebElement Welmessage = driver.findElement(By.xpath("//*[@id=\"login-section\"]/div/div/div/div/div/div[2]/h5"));
			String headingText = Welmessage.getText();
			System.out.println(" The text recived is :" +headingText);
			driver.quit();
		}


	}


