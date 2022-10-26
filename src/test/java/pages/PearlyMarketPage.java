package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;


public class PearlyMarketPage {

    public PearlyMarketPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    //Tugba Gunes

    @FindBy(xpath = "//*[@class='register inline-type']")
    public WebElement registerr;
    @FindBy(xpath = "(//*[@href='https://pearlymarket.com/vendor-register/'])[2]")
    public WebElement becomeVendor;
    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement emaill;
    @FindBy(xpath = "//*[@id='passoword']")
    public WebElement passwordd;
    @FindBy(xpath = "//*[@name='password_strength']")
    public WebElement strongSifre;
    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']")
    public WebElement girisYapilamadi;
    @FindBy(xpath = "//span[normalize-space()='Sign In']")
    public WebElement signİn;

    //US002
    @FindBy(xpath = "//*[@class='woocommerce-Input woocommerce-Input--text input-text']")
    public WebElement signİnEmail;
    @FindBy(xpath = "//*[@autocomplete='current-password']")
    public WebElement signİnPassword;
    @FindBy(xpath = "//*[@class='woocommerce-button button woocommerce-form-login__submit']")
    public WebElement signİnButton;
    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(css = ".woocommerce-MyAccount-navigation")
    public List<WebElement> dashboardList;
    @FindBy(xpath = "(//span[normalize-space()='Register'])[1]")
    public WebElement pearlyRegister;

    @FindBy(xpath = "(//*[@id='reg_username'])[1]")
    public WebElement pearlyRegisterUsername;

    @FindBy(xpath = "(//*[@id='reg_email'])[1]")
    public WebElement pearlyRegisterMail;

    @FindBy(xpath = "(//*[@id='reg_password'])[1]")
    public WebElement registerPassword;

    @FindBy(xpath = "(//*[@class='woocommerce-Button woocommerce-button button woocommerce-form-register__submit'])[1]")
    public WebElement registerSignUp;

    @FindBy(xpath = "//*[text()='Become a Vendor']")
    public WebElement becomeAVendor;

    //register sonrasi become a vendor kismi
    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement userEmail;

    @FindBy(xpath = "//*[@id='confirm_pwd']")
    public WebElement confirmPass;

    @FindBy(xpath = "//*[@id='wcfm_membership_register_button']")
    public WebElement registerButton;

    @FindBy(xpath = "//*[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement wrongEmail;

    @FindBy(xpath = "//*[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement errorEmail;

    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']")
    public WebElement atleastGood;

    @FindBy(xpath = "//*[@id='password_strength']")
    public WebElement goodPassword;

    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']")
    public WebElement NotSamePass;
    @FindBy(xpath = "(//*[text()='Orders'])[1]")
    public WebElement orders;

    @FindBy(xpath = "//*[@class='btn btn-dark btn-rounded btn-icon-right continue-shopping mb-4 mt-6']")
    public WebElement goShop;

    @FindBy(css = ".products.row.cols-lg-3.cols-md-3")
    public List<WebElement> urunList;

    @FindBy(css = ".product-details>h3>a")
    public List<WebElement> conList;


    @FindBy(xpath = "//*[@name='add-to-cart']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "(//*[@class='cart-count'])[1]")
    public WebElement sepetCount;

    @FindBy(xpath = "//*[@class='cart-toggle']")
    public WebElement cart;

    @FindBy(xpath = "//*[@class='button wc-forward']")
    public WebElement viewCart;

    @FindBy(xpath = "(//*[text()='Checkout'])[2]")
    public WebElement checkout;

    @FindBy(css = "#billing_first_name")
    public WebElement firstName;















































































    //Vendor Registiration















































































































    //Filiz Yilmaz































































































































































































    //Nida Yucedal

    @FindBy(xpath = "//span[normalize-space()='Register']")
    public WebElement register;

    @FindBy(xpath = "//span[normalize-space()='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement signPass;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement signlog;


    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    public WebElement myaccount;

    @FindBy(xpath = "//a[normalize-space()='Store Manager']")
    public WebElement storemanager;

    @FindBy(xpath = "(//span[normalize-space()='Products'])[1]")
    public WebElement productsnida;

    @FindBy(xpath = "//th[@aria-label='Status']")
    public WebElement status;

    @FindBy(xpath = "//th[@aria-label='Stock']")
    public WebElement stock;

    @FindBy(xpath = "//th[@aria-label='Price: activate to sort column ascending']")
    public WebElement price;

    @FindBy(xpath = "//th[@aria-label='Date: activate to sort column ascending']")
    public WebElement date;

    @FindBy(xpath = "//span[contains(text(),'Add New')]")
    public WebElement addnew;


    @FindBy(xpath = "//p[@class='description wcfm_title wcfm_ele virtual_ele_title checkbox_title simple booking non-variable-subscription non-job_package non-resume_package non-redq_rental non-accommodation-booking non-pw-gift-card']")
    public WebElement virtual;

    @FindBy(xpath = "//p[@class='description wcfm_title wcfm_ele downloadable_ele_title checkbox_title simple appointment non-variable-subscription non-job_package non-resume_package non-redq_rental non-accommodation-booking non-pw-gift-card']")
    public WebElement downloadable;

    @FindBy(xpath = "//input[@id='pro_title']")
    public WebElement productTitle;

    @FindBy(xpath = "//input[@id='regular_price']")
    public WebElement prices;

    @FindBy(xpath = "//input[@id='sale_price']")
    public WebElement salesPrice;

    @FindBy(xpath = "(//input[@id='pro_title'])[1]")
    public WebElement dress;

    @FindBy(xpath = "//img[@id='featured_img_display']")
    public WebElement addfoto;

    @FindBy(xpath = "//button[@id='__wp-uploader-id-1']")
    public WebElement selectfile;

    @FindBy(xpath = "//strong[normalize-space()='Short Description']")
    public WebElement shortDescrip;

    @FindBy(xpath = "//p[@class='description wcfm_title wcfm_full_ele wcfm_wpeditor']//strong[contains(text(),'Description')]")
    public WebElement description;

    @FindBy(xpath = "//iframe[@id='excerpt_ifr']")
    public WebElement iframe;

    @FindBy(xpath = "//iframe[@id='description_ifr']")
    public WebElement iframe2;

    @FindBy(xpath = "//button[normalize-space()='Select']")
    public WebElement addproductSelect;

    @FindBy(xpath = "//ul[@id='product_cats_checklist']")
    public WebElement categories;

    @FindBy(xpath = "//span[normalize-space()='Accessories']")
    public List<WebElement> cotegoriesNames;

    @FindBy(xpath = "(//input[@value='225'])[1]")
    public WebElement bestSellerButton;

    @FindBy(xpath = "//input[@value='293']")
    public WebElement amazonBasic;

    @FindBy(xpath = "//img[@id='gallery_img_gimage_0_display']")
    public WebElement addimage;

    @FindBy(xpath = "(//div[@class='thumbnail'])[1]")
    public WebElement imageSelect;


    @FindBy(xpath = "(//button[text()='Add to Gallery'])[2]")
    public WebElement addToGallery;

    @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button']")
    public WebElement submit;

    @FindBy(xpath = "(//*[text()='Short Description'])[1]")
    public WebElement shortDescriptionVisible;

    @FindBy(xpath = "//body[@data-id='excerpt']")
    public WebElement shortDescriptionText;

    @FindBy(xpath = "//body[@data-id='description']")
    public WebElement descriptionText;

    @FindBy(xpath = "(//*[text()='Description'])[1]")
    public WebElement descriptionVisible;

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signn;





















































    //Sena Yucedal


    @FindBy(xpath = "(//span[normalize-space()='Products'])[1]")
    public WebElement productSena;

    @FindBy(xpath = "//*[text()='Add New']")
    public WebElement addNewButtonSena;

    @FindBy(xpath = "(//*[text()='Product brands'])[1]")
    public WebElement productsBrands;

    @FindBy(xpath = "//li[@class='product_cats_checklist_item checklist_item_432']")
    public List<WebElement> brands;


    @FindBy(xpath = "(//*[text()='SKU'])[1]")
    public WebElement sku;

    @FindBy(xpath = "//*[@id='manage_stock']")
    public WebElement manageStock;

    @FindBy(xpath = "//*[@id='stock_qty']")
    public WebElement stockQty;

    @FindBy(xpath = "//*[text()='Allow Backorders?']")
    public WebElement allowBackorders;


    @FindBy(xpath = "//*[text()='Do not Allow']")
    public WebElement doNotAllow;

    @FindBy(xpath = "//*[text()='Allow, but notify customer']")
    public WebElement allowButNotifyCustomer;

    @FindBy(xpath = "//*[text()='Allow']")
    public WebElement allow;

    @FindBy(xpath = "(//*[text()='Sold Individually'])[1]")
    public WebElement soldIndividually;







































































































































































    //Zafer Tapikara




























































































































































































    //Zeynep Sarikaya

    @FindBy (xpath = "(//*[text()='Sign In'])[1]")
    public WebElement signInn;
    @FindBy (xpath = "//*[@id='username']")
    public WebElement userName;
    @FindBy (xpath = "//*[@id='password']")
    public WebElement password;
    @FindBy (xpath = "//*[@name='login']")
    public WebElement login;
    @FindBy (xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccount;
    @FindBy (xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy (xpath = "//*[@id='wcfm-orders_info']")
    public WebElement resultOrders;
    @FindBy (xpath = "(//*[@class='text'])[4]")
    public WebElement products;
    @FindBy (xpath = "//*[text()='20.00']")
    public WebElement discount;
    @FindBy (xpath = "(//*[@style='text-align:left;'])[1]")
    public WebElement billingAddress;
    @FindBy (xpath = "(//*[@style='text-align:left;'])[2]")
    public WebElement shippingAddress;
    @FindBy (xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-account']")
    public WebElement accountDetails;
    @FindBy (xpath = "//*[@id='account_last_name']")
    public WebElement lastName;
    @FindBy (xpath = "//*[@id='account_display_name']")
    public WebElement displayName;
    @FindBy (xpath = "//*[@id='account_email']")
    public WebElement accountDetailsEmail;
    @FindBy (xpath = "//*[@name='save_account_details']")
    public WebElement saveChanges;
    @FindBy (xpath = "//*[@class='wcfm_menu_items wcfm_menu_wcfm-coupons']")
    public WebElement coupons;
    @FindBy (xpath = "(//*[@class='text'])[18]")
    public WebElement couponAddNew;
    @FindBy (xpath = "//*[@id='title']")
    public WebElement code;
    @FindBy (xpath = "(//*[@class='wcfm-checkbox wcfm_ele'])[1]")
    public WebElement freeShipping;
    @FindBy (xpath = "//*[@id='show_on_store']")
    public WebElement showOnStore;















































































































































































































    //Nurullah Karakose



























































































































































































    //Yusuf Demir



















































































































































































































    //Kenan Agca













































































































































































































































































    //Mehmet Duman


@FindBy(xpath = "(//span[@class='text'])[14]")
    public WebElement reportsButton;

    @FindBy(xpath = "//*[text()='Year']")
    public WebElement yearReportButton;

    @FindBy(xpath = "//*[text()='Last Month']")
    public WebElement lastmonthReportButton;

    @FindBy(xpath = "(//*[text()='This Month'])[1]")
    public WebElement thismonthReportButton;

    @FindBy(xpath = "//*[text()='Last 7 Days']")
    public WebElement last7daysReportButton;

    @FindBy(xpath = "//*[@class=\"wcfm-date-range\"]")
    public WebElement choosedateReportButton;

    @FindBy(xpath = "//*[@id=\"chart-placeholder-canvas\"]")
    public WebElement choosedateReportTable;




















































































































}
