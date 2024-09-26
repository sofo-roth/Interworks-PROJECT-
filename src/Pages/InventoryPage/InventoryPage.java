package Pages.InventoryPage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }
    public String inventoryPageUrl = "https://www.saucedemo.com/inventory.html";

    @FindBy(id = "item_4_title_link")
    private WebElement sauceBackpack;
    
    @FindBy(css = ".btn_primary.btn_inventory")
    private WebElement AddButton;
    
    @FindBy(css = ".btn_secondary.btn_inventory")
    private WebElement removeButton;
    
    @FindBy(xpath = "//div[contains(text(), 'carry.allTheThings()')]")
    private WebElement prodDetails;
    
    @FindBy(className = "inventory_details_price")
    private WebElement priceDetails;

    public void SauceBackpackClick() {
    	driver.get(inventoryPageUrl);
    	driver.navigate().refresh();
    	sauceBackpack.click();
    }
    
    public void AddToCartButton() {
    	AddButton.click();
    }
    
    public void RemoveFromCartButton() {
    	removeButton.click();
    }
    
    public void VerifyProductDetails(String expectedDetails) {
    	String detailsText = prodDetails.getText();
    	Assert.assertTrue(detailsText.contains(expectedDetails), "Text does not match! Expected to contain: " + expectedDetails + " but found: " + detailsText);  
    }
    
    public void VerifyProductPrice(String expectedPrice) {
    	String priceText = priceDetails.getText();
    	Assert.assertTrue(priceText.contains(expectedPrice), "Text does not match! Expected to contain: " + expectedPrice + " but found: " + priceText);  
 
    }
    
    public void VerifyRemovedItem() {
        assert AddButton.isDisplayed() : "Item was ΝΟΤ successfully removed from the cart.";
    }
}
