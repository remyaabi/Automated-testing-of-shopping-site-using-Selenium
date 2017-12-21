package automationPractice.automationPractice.pageobjects;

import java.util.List;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automationPractice.automationPractice.configuration.Elements;


public class ShoppingCartSummary {
	static Logger logger = Logger.getLogger(ShoppingCartSummary.class);

	@FindBy(xpath = Elements.proceedCheckOutSummary)
	private WebElement proceedCheckOutSummary;
	@FindBy(xpath = Elements.deleteIcon)
	private List<WebElement> deleteIcon;
	
	@FindBy(xpath = Elements.tableHeaderOrCol)
	private List<WebElement> cols;

	@FindBy(xpath = Elements.tableRows)
	private List<WebElement> rows;
	@FindBy(xpath = Elements.shoppingCartEmpty)
	private WebElement shoppingCartEmpty;
	
	
	
	public WebElement getShoppingCartEmpty() {
		return shoppingCartEmpty;
	}
	public WebElement getProceedCheckOutSummary() {
		return proceedCheckOutSummary;
	}
	public void proceedCheckOutSummaryClick() {
		    System.out.println("proceedCheckOutSummaryClick");
			 proceedCheckOutSummary.click();
		
	}
	

	public List<WebElement> tableRows() {
		return rows;
	}

	public int noOftableRows() {
		return rows.size();
	}

	public List<WebElement> getdeleteIcon() {
		return deleteIcon;
	}
     public void deleteProduct(String productName){
    	 
     List<WebElement>tableRowsvalue=tableRows();
    	 for (WebElement row : tableRowsvalue) {			
 		
 				String actProductName=(row.findElement(By.xpath("//td//p[@class='product-name']//a"))).getText();
 				if (actProductName.trim().equalsIgnoreCase(productName)){
 					//table[@id='cart_summary']//tbody//tr//td[7]//div//a[@class='cart_quantity_delete']
 					row.findElement(By.xpath("//td//div//a[@class='cart_quantity_delete']")).click();;
 				}
 				
 			}
    	 }
     
	public boolean assertTotalQuantityAndPrice(List<WebElement> colValue) {
		System.out.println("colValue.get(4).getText()" + colValue.get(4).findElement(By.xpath("//span//span[@class='price']")).getText());
		 
		String priceValue=colValue.get(4).findElement(By.xpath("//span//span[@class='price']")).getText();
		String prodUnitPrice = priceValue.replaceAll("[^0-9]","");
		Float prodUnitPrice1=Float.parseFloat(prodUnitPrice);
		System.out.println("colValue.get(5).findElement(By.xpath : " + colValue.get(5).findElement(By.xpath("//input[contains(@name,'quantity')]")).getAttribute("value"));
		 
		String quantity=colValue.get(5).findElement(By.xpath("//input[contains(@name,'quantity')]")).getAttribute("value");
		Integer productQuant=Integer.parseInt(quantity);
		int productQuant1=productQuant.intValue();
		
		System.out.println("colValue.get(6).findElement(By.xpath : " + colValue.get(6).findElement(By.xpath("//span[contains(@id,'total_product_price')]")).getText());
		String total=colValue.get(6).findElement(By.xpath("//span[contains(@id,'total_product_price')]")).getText();
		String prodTotal = total.replaceAll("[^0-9]","");
		Float prodTotal1=Float.parseFloat(prodTotal);
		if(prodUnitPrice1*productQuant1==prodTotal1){
				return true;
		}else{
			return false;
		}
}
}
