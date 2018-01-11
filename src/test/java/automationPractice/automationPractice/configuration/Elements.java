package automationPractice.automationPractice.configuration;



public class Elements {
	//Main Home Object
	public static final String searchText ="search_query_top";
	public static final String searchButton ="submit_search";
	
	public static final String contactLink ="//div//a[@href='http://automationpractice.com/index.php?controller=contact' and @title='Contact Us']";
	public static final String signInLink ="//a[@class='login' and @title='Log in to your customer account']";
	public static final String dealLink ="//a[@href='http://automationpractice.com/' and @title='My Store']";
	public static final String returnHomeLink ="//a[@href='http://automationpractice.com/' and @title='Return to Home']//i";
	public static final String signInsignOut="//a[contains(text(),'Sign')]";
	
	public static final String cartCheckoutLink="//a[@id='button_order_cart']";
	public static final String CheckoutLinkAfterDelAddressUpdate="//button[@name='processAddress']";
	//Department obj
	public static final String womenLink ="//a[@class='sf-with-ul' and @title='Women']";
	public static final String tshirtLink ="(//a[@title='T-shirts'])[2]";
	public static final String dressLink ="(//a[@class='sf-with-ul' and @title='Dresses'])[2]";
	public static final String womenAssertionCheck ="(//h1[@class='page-heading product-listing']//span)[1]";
	//Sign In Object
	public static final String signInEmailText ="//div[contains(@class,'form-group')]//input[@id='email']";
	public static final String signInPasswdText ="passwd";
	public static final String forgotPaswdLink ="//a[@href='http://automationpractice.com/index.php?controller=password' and @title='Recover your forgotten password']";
	public static final String SubmitLoginButton ="//button[@id='SubmitLogin']";
	public static final String emailcreateText ="email_create";
	public static final String SubmitCreateButton ="SubmitCreate";
	public static final String signOut ="//a[@class='logout' and @title='Log me out']";
    public static final String invalidSignIn="//div[@class='alert alert-danger']";
    public static final String invalidSignInText= "//div[@class='alert alert-danger']/ol/li";

	//Women page
	public static final String dressLinkInWomen ="(//a[@class='sf-with-ul' and @title='Dresses'])[1]";
	public static final String tshirtMouseOverInWomen="(//a[contains(@href,'http://automationpractice.com/index.php?id_category=5&controller=category') and @title='T-shirts'])[1]";
	public static final String blouseMouseOverInWomen="//a[contains(@href,'http://automationpractice.com/index.php?id_category=7&controller=category')  and @title='Blouses']";
	public static final String eveningDressInWomenMouseOver="(//a[@title='Evening Dresses'])[1]";
    public static final String summerDressInWomenMouseOver="(//a[@title='Summer Dresses'])[1]";
    public static final String topsInWomen= "//a[@class='sf-with-ul' and @title='Tops']";
    public static final String casualDressInWomenMouseOver="(//a[@title='Casual Dresses'])[1]";
   
    public static final String tshirtMouseOverClickAssert="//div[@class='cat_desc']//span[@class='category-name' and contains(text(),T-shirts)]";
    public static final String blouseMouseOverClickAssert="//div[@class='cat_desc']//span[@class='category-name' and contains(text(),Blouses)]";
    public static final String casualDressClickAssert="//div[@class='cat_desc']//span[@class='category-name' and contains(text(),'Casual Dresses')]";
    public static final String dressesClickAssert="//div[@class='cat_desc']//span[@class='category-name' and contains(text(),'Dresses')]";
    public static final String eveningDressClickAssert="//div[@class='cat_desc']//span[@class='category-name' and contains(text(),'Evening Dresses')]";
    public static final String summerDressClickAssert="//div[@class='cat_desc']//span[@class='category-name' and contains(text(),'Summer Dresses')]";
    public static final String topClickAssert="//div[@class='cat_desc']//span[@class='category-name' and contains(text(),'Tops')]";
   
    public static final String itemName="//div[@class='product-container']//div//h5";
    public static final String summerDressInDress="(//a[@title='Summer Dresses'])[2]";
    public static final String eveningDressInDressClick="(//a[@title='Evening Dresses'])[2]";
    public static final String casualDressInDressClick="(//a[@title='Casual Dresses'])[2]";
   
    public static final String casualDressInSubcategory="(//a[@title='Casual Dresses'])[3]";
    public static final String summerDressInSubcategory="(//a[@title='Summer Dresses'])[3]";
    public static final String eveningDressInSubcategory="(//a[@title='Evening Dresses'])[3]";
  
    public static final String selectSize="//select[@id='group_1']";
    public static final String t_ShirtToShop="//a[@class='product_img_link' and @title='Faded Short Sleeve T-shirts']";
    
    
    
    public static final String productTitle ="//h1[@itemprop='name']";
    public static final String quantityPlus= "//a[@class='btn btn-default button-plus product_quantity_up']//span//i[@class='icon-plus']";
    public static final String quantityDown= "//a[@class='btn btn-default button-minus product_quantity_down']//span//i[@class='icon-minus']";
    public static final String quantityWanted= "//input[@id='quantity_wanted']";
    public static final String moreLink="//a//span[text()='More']";
    public static final String colorPickList= "//ul[@id='color_to_pick_list']//li//a";
    public static final String addToCart="//button[@class='exclusive']//span[text()='Add to cart']";
    public static final String itemPrice="//div[@class='price']//p[@class='our_price_display']//span[@id='our_price_display']";
    //My Account page
	public static final String myAccSubHeaderlabel ="//p[@class='info-account']";	
	public static final String myAccHeaderlabel="//h1[@class='page-heading']";
	//BuyProduct Page
	public static final String productQuantity= "//div[@class='layer_cart_product_info']//span[@id='layer_cart_product_quantity']";
    public static final String productColorAndsize= "//div[@class='layer_cart_product_info']//span[@id='layer_cart_product_attributes']";
    public static final String prroductTitle="//div[@class='layer_cart_product_info']//span[@id='layer_cart_product_title']";
    public static final String prroductTotal="//div[@class='layer_cart_product_info']//span[@id='layer_cart_product_price']";    
    public static final String proceedCheckout="//a[@title='Proceed to checkout' and contains(@href,'http://automationpractice.com/index.php?controller=order')]//span";
  public static final String proceedCheckoutLink2="//a[contains(@href,'http://automationpractice.com/index.php?controller=order&step=1')]//span";
  public static final String proceedCheckoutDiv="//div[@id='layer_cart']";
    public static final String continueShopping="//a[@title='Continue shopping']";
    
    
    //Shopping cart Summary
    public static final String proceedCheckOutSummary="//a[@class='button btn btn-default standard-checkout button-medium' and @title='Proceed to checkout']//span";
    public static final String tableHeaderOrCol="//td";
    public static final String tableRows="//table[@id='cart_summary']//tbody//tr";
    public static final String prodTitleinTable="//table[@id='cart_summary']//tbody//tr//td//p[@class='product-name']//a";
    public static final String shoppingCartEmpty="//p[@class='alert alert-warning']";
    public static final String deleteIcon= "//a[@class='cart_quantity_delete']";
    
   // CartObj
    public static final String cartEmptyText ="//div//a[@href='http://automationpractice.com/index.php?controller=order' and @title='View my shopping cart']//span[@class='ajax_cart_no_product']";
    public static final String cart ="//div//a[@href='http://automationpractice.com/index.php?controller=order' and @title='View my shopping cart']";
    //Address
    public static final String proceedCheckoutButton="//p//button[@name='processAddress']//span//i";
    public static final String addressSelectBox= "//select[@id='id_address_delivery']";
    public static final String addressUseCheckbox="//input[@id='addressesAreEquals' and @type='checkbox']";
    public static final String billingAddressUpdate="//ul[@id='address_invoice']//li//a[@title='Update']";
    public static final String deliveryAddressUpdate="//ul[@id='address_delivery']//li//a[@title='Update']";
    public static final String addNewAddress= "//p[@class='address_add submit']//a[@title='Add']";
    public static final String addNewAddressOnSelectUncheck= "//div[@id='address_invoice_form']//a[@title='Add']";
    public static final String comments ="//textarea[@name='message']";
    public static final String billingAddressSelectBox="//select[@id='id_address_invoice']";
    public static final String backToAddressPage="//a//span[text()=' Back to your addresses']//i";
    public static final String deleteButtonInBackToAddressPage="//a[@title='Delete']";
    public static final String addressnotAvailableText="//p[contains(text(),'No addresses are available')]";
    public static final String yourAddressText= "//h1[text()='Your addresses']";
    public static final String addressnotAvailablePara= "//div[@id='center_column']/p[2]";
    public static final String addressAvailablePara= "//div[@class='addresses']/p[1]";

    //Shipping obj
    public static final String agreeTermCheckbox ="//input[@id='cgv' and @type='checkbox']";
    public static final String shippingProceedCheckout="//button[@name='processCarrier' ]";
    public static final String closeButtonAlertBox="//a[@class='fancybox-item fancybox-close']";
    public static final String readAgreement ="//a[@class='iframe']";
    public static final String closeAgreementAlertBox="//a[@class='fancybox-item fancybox-close']";
    //Payment Object  
    public static final String bankWirePayment="//a[@class='bankwire']";
    public static final String cheque="//a[@class='cheque']";
    public static final String confirmOrder="//button[@type='submit']//span[text()='I confirm my order']";
    
    public static final String otherPaymethods="Other payment methods";
    //create acc
    public static final String updateAddress= "//button[@id='submitAddress']";
    public static final String backAddress="//a[contains(@href,'http://automationpractice.com/index.php?controller=addresses')][1]";
    
    //My Account
    public static final String myAddresslink= "//a[@title='Addresses']";
    public static final String addMyAddresslink="//a[@title='Add my first address']";
    public static final String addNewAddressButton="//a[@title='Add an address']";


    //contact us page
    public static final String subjectHeading="//div[@id='uniform-id_contact']/select[@id='id_contact']";
    public static final String contactEmail="//input[@id='email']";
    public static final String contactOrderreference="//input[@id='id_order']";
    public static final String fileUploadText="//div[@id='uniform-fileUpload']/span[@class='filename']";
    public static final String fileUploadButton="//div[@id='uniform-fileUpload']/span[@class='action']";
    public static final String sendButton="//button[@id='submitMessage']";
    public static final String messageTextarea="//textarea[@id='message']";
    public static final String succesMessage="//p[@class='alert alert-success']";
    public static final String Homelink="//ul[@class='footer_links clearfix']/li/a[@class='btn btn-default button button-small']";
    public static  final String errorParagraph="//div[@class='alert alert-danger']";
    public static  final String errorParacontent="//div[@class='alert alert-danger']/ol/li";
}
