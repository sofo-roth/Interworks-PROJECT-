package testngpackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {

    private WebDriver driver;
    
    //Αρχικοποιώ τον οδηγο για το chrome και ξεκινώ με την σελίδα του 1ου τεστ 
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lepas\\Desktop\\selenium files\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.oasth.gr/");
    }

    @Test
    public void testOasthEpikoinwnia() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
     

    	// Βρίσκω το πρώτο element με tag span 
        WebElement span = driver.findElement(By.xpath("//span[contains(text(),'Επικοινωνήστε μαζί μας')]"));


        // Κλικάρω το span
        span.click();
        
        WebElement searchBoxfirstname = driver.findElement(By.name("names[first_name]"));

        // Πληκτρολογώ χαρακτήρες στο αντιστοιχο element
        searchBoxfirstname.sendKeys("ΣΟΦΟΚΛΗΣ");

        WebElement searchBoxemail = driver.findElement(By.name("email"));

        // Πληκτρολογώ χαρακτήρες στο αντιστοιχο element
        searchBoxemail.sendKeys("toemailmou@gmail.com");
        
        WebElement searchBoxsubject = driver.findElement(By.name("subject"));

        // Πληκτρολογώ χαρακτήρες στο αντιστοιχο element
        searchBoxsubject.sendKeys("Τα λεωφορεια σας παιρνουν φωτια βοηθεια");
        
        WebElement searchBoxmessage = driver.findElement(By.name("message"));

        // Πληκτρολογώ χαρακτήρες στο αντιστοιχο element
        searchBoxmessage.sendKeys("Ειμουν μεσα στο 52 και πηρε φωτια ελεος");
    }
    
    // Εκκίνηση 2ου τεστ με προυπόθεση ολοκλήρωσης του 1ου
    @Test(dependsOnMethods = "testOasthEpikoinwnia")
    public void testIMDB() {
    	driver.get("https://www.imdb.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        
        // Κλικάρω στο textbox αναζητησης του IMDB και αναζητώ την ταινία avengers 
        WebElement element = driver.findElement(By.cssSelector("input[placeholder='Search IMDb']"));
        element.click();
        
        element.sendKeys("avengers endgame");
        element.sendKeys(Keys.ENTER);
        
        WebElement span = driver.findElement(By.xpath("//span[contains(text(),'Menu')]"));
        span.click();
        
     // Σταματώ την διαδικασία για 2 δευτερολεπτα για να φορτώσει η σελίδα
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
     // Αναζητώ απ το αναδυόμενο μενου την κατηγορία αναζήτησης ταινιών ανα είδος και κλικάρω
        WebElement span2 = driver.findElement(By.xpath("//span[contains(text(),'Browse Movies by Genre')]"));
        span2.click();
    }
  
    // Εκκίνηση 3ου τεστ με προυπόθεση ολοκλήρωσης του 2ου
    @Test(dependsOnMethods = "testIMDB")
    public void testExamsLogin() {
    	// Μπαινω στην σελίδα login της σχολής
        driver.get("https://sso.ihu.gr/login?service=https%3A%2F%2Fexams-iee.the.ihu.gr%2Flogin%2Findex.php");

        // Βρίσκω τα αντίστοιχα κελιά 
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameInput.sendKeys("it164659");
        passwordInput.sendKeys("574685");

        // Πατάω το login κουμπί
        loginButton.click();

        // Επαληθεύω αν η σύνδεση ηταν επιτυχής ή αποτυχής
        String expectedUrlAfterLogin = "https://exams-iee.the.ihu.gr/";
        String actualUrlAfterLogin = driver.getCurrentUrl();
        
        if (expectedUrlAfterLogin.equals(actualUrlAfterLogin)) {
            System.out.println("LOGIN WAS SUCCESSFUL");
            System.out.println("");
            System.out.println("");
        } else {
        	System.out.println("LOGIN WAS UNSUCCESSFUL");
        	System.out.println("");
            System.out.println("");
        }

    }
    
    
    @AfterClass
    public void tearDown() {
        // Σταματώ την διαδικασία για 5 δευτερολεπτα
    	try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Κλείνω το chrome 
        driver.close();
    } 
}