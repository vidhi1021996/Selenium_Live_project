/*
 * Time to create a more professional Script
 * 1) All parameters will will be saved in File Util.java - Helps in easy code maintenance
 * 2) We will move the code to launch Webdriver in a separate method as SetUp. Helps in code understanding
 */

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;




public class TestScript02 {

    static WebDriver driver; // Selenium control driver
    private static String baseUrl; // baseUrl of Website Guru99
    
    // This method SetUp will read initialization parameters from the class Util.java & launch Firefox 

    public static void setUp() throws Exception {

    	File pathToBinary = new File(Util.FIREFOX_PATH);
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);

	
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary, firefoxProfile);

	// Setting Base URL of website Guru99
	baseUrl = Util.BASE_URL;
	// Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
	// Refer - http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html
	driver.manage().timeouts()
		.implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
	// Go to http://www.demo.guru99.com/V4/
	driver.get(baseUrl + "/V4/");
    }

   
   public static void main(String[] args) throws Exception {

     	
	
    String username, password;
	String actualTitle;
	String actualBoxtitle;

	    
	    //Setup Firefox driver
	    setUp();
	
	   
	    driver.findElement(By.name("uid")).clear(); 
	    driver.findElement(By.name("uid")).sendKeys(Util.USER_NAME);  // Enter username

	   
	    driver.findElement(By.name("password")).clear(); 
	    driver.findElement(By.name("password")).sendKeys(Util.PASSWD);  // Enter Password

	    // Click Login
	    driver.findElement(By.name("btnLogin")).click();

	  	actualTitle = driver.getTitle();
		if (actualTitle.contains(Util.EXPECT_TITLE)) {
				    System.out.println("Test case: Passed");
		} 
		else {
				    System.out.println("Test case : Failed");
		}
				
	    driver.close();
	    
	

    }

}

        

