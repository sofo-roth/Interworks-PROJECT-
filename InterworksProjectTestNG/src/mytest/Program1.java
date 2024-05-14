package mytest;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng;

public class Program1 {
    WebDriver driver;
	
    @BeforeMethod
	public void setUp()
	{
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\lepas\\eclipse-workspace\\InterworksProjectTestNG\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	public void tearDown()
	{
		driver.quit();
	}
	
}
