/*
 * Set of test script for testing Website Guru99 Bank
 * The test scripts is developed using Selenium Framework
 *
 */
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScript01 {

    

    public static void main(String[] args) throws Exception {	  
	
    	//Setup Firefox driver    	
       	WebDriver driver = new FirefoxDriver();
    	String baseUrl = "http://www.demo.guru99.com/V4/";
    	
    	// launch Firefox and direct it to the Base URL
    	driver.get(baseUrl);


	    // Enter username
	    driver.findElement(By.name("uid")).sendKeys("mngr1336");

	    // Enter Password
	    driver.findElement(By.name("password")).sendKeys("dAnavUq");
   
	    // Click Login
	    driver.findElement(By.name("btnLogin")).click();


	    }
	

    }

