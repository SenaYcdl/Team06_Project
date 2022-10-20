package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class PearlyMarketPage {

    public PearlyMarketPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }



    //Tugba Gunes
















































































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

    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement email;

    @FindBy(xpath = "(//*[@href='https://pearlymarket.com/vendor-register/'])[2]")
    public WebElement becomeVendor;

    @FindBy(xpath ="//*[@id='passoword']")
    public WebElement password2;

    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']")
    public WebElement girisYapilamadi;

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signn;
























































    //Sena Yucedal














































































































































































































    //Zafer Tapikara




























































































































































































    //Zeynep Sarikaya
















































































































































































































    //Nurullah Karakose



























































































































































































    //Yusuf Demir



















































































































































































































    //Kenan Agca













































































































































































































































































    //Mehmet Duman


































































































































}
