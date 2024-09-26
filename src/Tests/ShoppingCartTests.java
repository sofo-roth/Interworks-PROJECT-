package Tests;

import Pages.InventoryPage.InventoryPage;
import Pages.Login.LoginPage;
import Utils.Log;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCartTests extends TestBase{
	        private String expectedPrice = "29.99";
	        private String validUserName = "standard_user";
	        private String validPassword = "secret_sauce";
	        private String expectedProdDetails = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
	        
	        //Στο πρώτο τέστ θα τσεκάρω αν με το πάτημα του κουμπιού ADD TO CART , οι λεπτομέρειες ΚΑΙ η τιμή του προιόντος είναι οι αναμενόμενες
	        @Test(priority = 1)
	    	public void addToCartTest() {
	    	
		    	 Log.info("Start Test Case: addToCartTest");
		    	 
		    	 InventoryPage inventoryPage = new InventoryPage(driver);
		    	 LoginPage loginPage = new LoginPage(driver);
		    	 loginPage.Login(validUserName,validPassword);
		         inventoryPage.SauceBackpackClick();
		         inventoryPage.AddToCartButton();
		         inventoryPage.VerifyProductDetails(expectedProdDetails);
		         inventoryPage.VerifyProductPrice(expectedPrice);  
		         inventoryPage.RemoveFromCartButton();   //κλικάρω στο REMOVE προτού περάσω στο δευτερο test επειδή το session μου διατηρείται και το προιον μένει στο καλάθι 
		                                                 //οπότε το αφαιρώ για να δουλέψει κανονικά το δεύτερο τέστ
	    	}
	        
	        //Στο δεύτερο τέστ θα τσεκάρω αν δουλεύει το REMOVE button, μετά το κλικάρισμα του ADD
	        @Test(priority = 2)
	        public void removeFromCartTest() throws InterruptedException {
	        	
	        	 Log.info("Start Test Case: removeFromCartTest");
	        	 InventoryPage inventoryPage = new InventoryPage(driver);
		    	 LoginPage loginPage = new LoginPage(driver);
		    	 loginPage.Login(validUserName,validPassword);
		         inventoryPage.SauceBackpackClick();
		         inventoryPage.AddToCartButton();
		         inventoryPage.RemoveFromCartButton();
		         inventoryPage.VerifyRemovedItem();
	        }
	            
	    
}

