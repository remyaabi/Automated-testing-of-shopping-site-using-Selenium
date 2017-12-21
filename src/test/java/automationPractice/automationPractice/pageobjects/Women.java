package automationPractice.automationPractice.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import automationPractice.automationPractice.configuration.Elements;

public class Women {
	static Logger logger = Logger.getLogger(Women.class.getName());
	@FindBy(xpath=Elements.womenLink)
	private WebElement womenLink;
	@FindBy(xpath=Elements.tshirtMouseOverInWomen) 
	private WebElement tshirtMouseOverInWomen;
	
	@FindBy(xpath=Elements.tshirtMouseOverClickAssert) 
	private WebElement tshirtMouseOverClickAssert;
	@FindBy(xpath=Elements.blouseMouseOverInWomen) 
	private WebElement blouseMouseOverInWomen;
	
	@FindBy(xpath=Elements.blouseMouseOverClickAssert) 
	private WebElement blouseMouseOverClickAssert;
	@FindBy(xpath=Elements.casualDressClickAssert) 
	private WebElement casualDressClickAssert;
	@FindBy(xpath=Elements.dressLink)
	private WebElement dressLink;
	@FindBy(xpath=Elements.casualDressInDressClick)
	private WebElement casualDressInDress;
	
	@FindBy(xpath=Elements.addToCart)
	private WebElement addToCart;
	@FindBy(xpath=Elements.itemPrice)
	private WebElement itemPrice;
	@FindBy(xpath=Elements.colorPickList)
	private List<WebElement> colorPickList;
	
	@FindBy(xpath=Elements.productTitle)
	private WebElement productTitle;
	@FindBy(xpath=Elements.t_ShirtToShop)
	private WebElement 	t_ShirtToShop;
	@FindBy(xpath=Elements.moreLink)
	private List<WebElement>moreLink;
	@FindBy(xpath=Elements.	quantityPlus)
	private WebElement 	quantityPlus;
	@FindBy(xpath=Elements.	quantityDown)
	private WebElement 	quantityDown;
	
	@FindBy(xpath=Elements.quantityWanted)
	private WebElement 	quantityWanted;
	@FindBy(xpath=Elements.selectSize)
	private WebElement 	selectSize;
	@FindBy(xpath=Elements.eveningDressInDressClick)
	private WebElement 	eveningDressInDressClick;
	@FindBy(xpath=Elements.eveningDressInWomenMouseOver)
	private WebElement 	eveningDressInWomenMouseOver;
	@FindBy(xpath=Elements.eveningDressInSubcategory)	
	private WebElement 	eveningDressInSubcategory;
	
	@FindBy(xpath=Elements.dressLinkInWomen)	
	private WebElement 	dressLinkInWomen;
	
	@FindBy(xpath=Elements.topsInWomen)	
	private WebElement 	topsInWomen;
	@FindBy(xpath=Elements.casualDressInWomenMouseOver)	
	private WebElement 	casualDressInWomenMouseOver;
	@FindBy(xpath=Elements.summerDressInDress)	
	private WebElement 	summerDressInDress;
	@FindBy(xpath=Elements.casualDressInSubcategory)	
	private WebElement 	casualDressInSubcategory;
	
	@FindBy(xpath=Elements.summerDressInSubcategory)	
	private WebElement 	summerDressInSubcategory;
	@FindBy(xpath=Elements.summerDressInWomenMouseOver)	
	private WebElement 	summerDressInWomenMouseOver;
	
	@FindBy(xpath=Elements.dressesClickAssert)	
	private WebElement 	dressesClickAssert;
	@FindBy(xpath=Elements.eveningDressClickAssert)	
	private WebElement 	eveningDressClickAssert;
	@FindBy(xpath=Elements.summerDressClickAssert)	
	private WebElement 	summerDressClickAssert;
	@FindBy(xpath=Elements.topClickAssert)	
	private WebElement 	topClickAssert;
	@FindBy(xpath=Elements.itemName)	
	private List<WebElement> itemName;
	
	public void quantityDownClick(){
		quantityDown.click();
	}
	
	public List<WebElement> getItemNameList(){
		return  itemName;
	}
	
	public String getCasualDressClickAssertText(){
		return  casualDressClickAssert.getText();
	}
	public String getDressesClickAssertText(){
		return  dressesClickAssert.getText();
	}
	public String getEveningDressClickAssertText(){
		return  eveningDressClickAssert.getText();
	}
	public String getSummerDressClickAssert(){
		return  summerDressClickAssert.getText();
	}
	public String getTopClickAssert(){
		return  topClickAssert.getText();
	}
	public String getTshirtMouseOverClickAssertText(){
		return  tshirtMouseOverClickAssert.getText();
	}
	public String getBlouseMouseOverClickAssertText(){
		return  blouseMouseOverClickAssert.getText();
	}
	
	
	public List<WebElement> getSelectedProductColorList(){
		List<WebElement> SelectedProdcolorList=new ArrayList<WebElement>();
		System.out.println("colorPickList" + colorPickList.size());
		for(WebElement colorlist: colorPickList){
			if(colorlist.getLocation().getX()!=0 && colorlist.getLocation().getY()!=0){
				SelectedProdcolorList.add(colorlist);
			}
		}
		return SelectedProdcolorList;
			
		
	}
	
	public WebElement getSummerDressInWomenMouseOver(){
		return summerDressInWomenMouseOver;
	}
	public void summerDressInWomenMouseOverClick(){
		summerDressInWomenMouseOver.click();
	}
	public WebElement getDressLinkInWomen(){
		return dressLinkInWomen;
	}
	public void dressLinkInWomenClick(){
		dressLinkInWomen.click();
	}
	public WebElement getTopsInWomen(){
		return topsInWomen;
	}
	public void summerDressInSubcategoryClick(){
		summerDressInSubcategory.click();
	}
	public WebElement getSummerDressInSubcategory(){
		return summerDressInSubcategory;
	}
	public void casualDressInSubcategoryClick(){
		casualDressInSubcategory.click();
	}
	public WebElement getcasualDressInSubcategory(){
		return casualDressInSubcategory;
	}
	public void topsInWomenClick(){
		topsInWomen.click();
	}
	
	public WebElement getsummerDressInDress(){
		return summerDressInDress;
	}
	public void summerDressInDressClick(){
		summerDressInDress.click();
	}
	public WebElement getCasualDressInWomenMouseOver(){
		return casualDressInWomenMouseOver;
	}
	public void casualDressInWomenMouseOverClick(){
		casualDressInWomenMouseOver.click();
	}
	public WebElement getEveningDressInDressClick(){
		return eveningDressInDressClick;
	}
	public WebElement getEveningDressInWomenMouseOver(){
		return eveningDressInWomenMouseOver;
	}
	public WebElement getEveningDressInSubcategory(){
		return eveningDressInSubcategory;
	}
	public void eveningDressInDressClick(){
		 eveningDressInDressClick.click();;
	}
	public void eveningDressInWomenMouseOverClick(){
		eveningDressInWomenMouseOver.click();;
	}
	public void eveningDressInSubcategoryClick(){
		 eveningDressInSubcategory.click();
	}
	
	public float getItemPrice(){
		try{
		String priceValue=itemPrice.getText().trim();
		String prodPrice = priceValue.replaceAll("[^0-9]","");
		Float prodPrice1=Float.parseFloat(prodPrice);
		return prodPrice1.floatValue();
		}catch (NumberFormatException e) {
			e.printStackTrace();
			return 0f;
		}
	}
	public WebElement getBlouseMouseOverClickAssert(){
		return blouseMouseOverClickAssert;
	}
	public Integer getQuantitywanted(){
		return Integer.parseInt(quantityWanted.getAttribute("value"));
	}
	public String getProductTitle(){
		System.out.println("getProductTitle" +productTitle.getText().trim());
		return productTitle.getText().trim();
	}
	public WebElement getCasualDressInDress(){
		return casualDressInDress;
	}
	
	public WebElement getCasualDressClickAssert(){
		return casualDressClickAssert;
	}
	public WebElement getTshirtMouseOverClickAssert(){
		return tshirtMouseOverClickAssert;
	}
	public WebElement getDressLink(){
		return dressLink;
	}
	public void dressLinkClick(){
		dressLink.click();
	}
	
	public WebElement getWomenLink(){
		return womenLink;
	}
	public void casualDressInDressClick(){
		casualDressInDress.click();
	}
	public void tshirtMouseOverInWomenClick(){
		tshirtMouseOverInWomen.click();
	}
	public void quantityPlusClick(){
		quantityPlus.click();
	}
	
	public void addToCartClick(){
		addToCart.click();
	}
	public WebElement getTshirtLinkInWomen(){
		return tshirtMouseOverInWomen;
	}
	public void blouseMouseOverInWomenClick(){
		blouseMouseOverInWomen.click();
	}
	public WebElement getBlouseInWomenLink(){
		return blouseMouseOverInWomen;
	}
	public WebElement getTshirtShop(){
		return t_ShirtToShop;
	}
	public WebElement visibleMoreLink(List<WebElement> moreWebelements){
		WebElement retWebelement=null;
		for(WebElement moreWebelement:moreWebelements){
			if(moreWebelement.getLocation().getX()!=0 && moreWebelement.getLocation().getY()!=0){
				retWebelement=moreWebelement;
				break;
			}
		}
		return retWebelement;
	}
	public void womenLinkClick(){
		womenLink.click();
	}
	public List<WebElement> getMoreLink(){
		return moreLink;
	}
	public WebElement getSelectSize(){
		return selectSize;
	}
	public void selectSize(String sizeInput){
		Select select=new Select(selectSize);	
		List <WebElement> sizeList=select.getOptions();
		for (WebElement size: sizeList){
			logger.info(size.getAttribute("title"));
			if (size.getAttribute("title").trim().equalsIgnoreCase(sizeInput)){
				select.selectByVisibleText(size.getText());
				break;
			}
		}
	}
	
	public void selectColor(String colorChoosen){
		for(WebElement color:colorPickList){
			if(color.getLocation().getX()!=0 && color.getLocation().getY()!=0){
			if(color.getAttribute("name").trim().equalsIgnoreCase(colorChoosen)){
				color.click();
			}
			}
		}
	}
	public void clickMainCategory(String catName){
		if (catName.trim().equalsIgnoreCase("Women")){
			womenLinkClick();
		}
		if (catName.trim().equalsIgnoreCase("Dress")){
			dressLinkClick();
		}
		if(catName.trim().equalsIgnoreCase("T-shirt")){
			tshirtMouseOverInWomenClick();
		}
		}
	public WebElement mouseOverMainCategory(String catName){
		WebElement retWebElement = null;
		if (catName.trim().equalsIgnoreCase("Women")){
			 retWebElement= womenLink;
		}
		if (catName.trim().equalsIgnoreCase("Dresses")){
			retWebElement= dressLink;
		}
		  return retWebElement;
		}
	public void clickSubCategoryInWomen(String subCatName){
		
		if (subCatName.trim().equalsIgnoreCase("Tops")){
			topsInWomenClick();
		}
		if (subCatName.trim().equalsIgnoreCase("Dresses")){
			dressLinkInWomenClick();
		}
		if (subCatName.trim().equalsIgnoreCase("casual")){
			casualDressInWomenMouseOverClick();
		}
		if (subCatName.trim().equalsIgnoreCase("Evening")){
			eveningDressInWomenMouseOverClick();
		}
		if (subCatName.trim().equalsIgnoreCase("summer")){
			summerDressInWomenMouseOverClick();
		}
		if (subCatName.trim().equalsIgnoreCase("Blouse")){
			blouseMouseOverInWomenClick();
		}
		if (subCatName.trim().equalsIgnoreCase("T-Shirt")){
			tshirtMouseOverInWomenClick();
		}
	}
	
	
	public WebElement mouseOverSubCategoryInWomen(String subCatName){
		WebElement retWebElement = null;
		if (subCatName.trim().equalsIgnoreCase("Tops")){
			 retWebElement= topsInWomen;
		}
		if (subCatName.trim().equalsIgnoreCase("Dresses")){
			retWebElement= dressLinkInWomen;
		}
		
	   if (subCatName.trim().equalsIgnoreCase("casual Dresses")){
		 retWebElement= casualDressInWomenMouseOver;
	  }
	  if (subCatName.trim().equalsIgnoreCase("Evening Dresses")){
		retWebElement= eveningDressInWomenMouseOver;
	  }
	  if (subCatName.trim().equalsIgnoreCase("summer Dresses")){
		 retWebElement= summerDressInWomenMouseOver;
	  }
	  if (subCatName.trim().equalsIgnoreCase("Blouse")){
		retWebElement= blouseMouseOverInWomen;
	  }
	  if (subCatName.trim().equalsIgnoreCase("T-Shirts")){
			retWebElement= tshirtMouseOverInWomen;
		  }
	  return retWebElement;
	}
	
	
	public WebElement selectItem(String itemNameVal){
		WebElement retWebElement = null;
		System.out.println("enetered selectItem");
		System.out.println("itemNameVal" + itemNameVal);
		List<WebElement> itemNameList=getItemNameList();
		for(WebElement itemName:itemNameList){
			System.out.println("itemName" + itemName.getText().trim());
			if(itemName.getText().trim().equalsIgnoreCase(itemNameVal)){
				
				retWebElement=itemName;
			}
		}
		return retWebElement;
	}
	
	public String getAssertLabel(String category){
		if (category.equalsIgnoreCase("Tops")){
			return getTopClickAssert();
		}
		if (category.equalsIgnoreCase("T-Shirts")){
			return getTshirtMouseOverClickAssertText();
		}
		if (category.equalsIgnoreCase("Blouse")){
			return getBlouseMouseOverClickAssertText();
		}
		if (category.equalsIgnoreCase("Dresses")){
			return getDressesClickAssertText();
		}
		if (category.equalsIgnoreCase("Summer Dresses")){
			return getSummerDressClickAssert();
		}
		if (category.equalsIgnoreCase("Evening Dresses")){
			return getEveningDressClickAssertText();
		}
		if (category.equalsIgnoreCase("casual Dresses")){
			return getCasualDressClickAssertText();
		}
		return null;
	}
}
	
	
	

