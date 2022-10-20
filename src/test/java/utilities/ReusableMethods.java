package utilities;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReusableMethods extends TestBaseRapor {


    static Faker faker;
    static Actions actions;
    static SoftAssert softAssert;
    static Select select;
    static WebElement ddm;

    //====== Faker ======//
    public static Faker getFaker() { // getFaker method
        return faker = new Faker();
    }

    //====== Actions ======//
    public static Actions getActions() { //getActions method
        return actions = new Actions(Driver.getDriver());
    }

    //====== Soft Assert ======//
    public static SoftAssert getSoftAssert() { //getSoftAssert method
        return softAssert = new SoftAssert();
    }

    //====== Select ======//
    public static Select select(WebElement ddm) {
        return select = new Select(ddm);
    }

    //====== js ======//
    public static void jsclick(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", webElement);
        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
            executor.executeScript("arguments[0].click();", webElement);
        }
    }

    //========ScreenShot(Syafanın resmini alma)=====//
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    //========ScreenShot Web Element(Bir webelementin resmini alma)=====//
    public static String getScreenshotWebElement(String name, WebElement element) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        File source = element.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String wElementSS = System.getProperty("user.dir") + "/target/WElementScreenshots/" + name + date + ".png";
        File finalDestination = new File(wElementSS);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return wElementSS;
    }

    //========Switching Window(Pencereler arası geçiş)=====//
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    //========Hover Over(Elementin üzerinde beklemek)=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    //==========Return a list of string given a list of Web Element====////
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //   HARD WAIT WITH THREAD.SLEEP
//   waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }

    }

    public static void signIn() {


        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("PearlyMarket sitesine gidildi");
        waitFor(5);
        Driver.getDriver().findElement(By.xpath("(//span[normalize-space()='Sign In'])[1]")).click();

        extentTest.info("Sign In butonuna tiklandi");
        waitFor(15);
        Driver.getDriver().findElement(By.xpath("(//input[@id='username'])[1]")).sendKeys(ConfigReader.getProperty("pearlyEmail"));

        extentTest.info("Gecerli mail yazildi");
        Driver.getDriver().findElement(By.xpath("(//input[@id='password'])[1]")).sendKeys(ConfigReader.getProperty("pearlyPassword"));

        extentTest.info("Gecerli password yazildi");
        waitFor(5);
        Driver.getDriver().findElement(By.xpath("//button[@name='login']")).click();

        extentTest.info("Basarili bir sekilde login olundu");
        waitFor(15);


    }


    public static void storeManager() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));
        extentTest.info("PearlyMarket sitesine gidildi");

        Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
        ReusableMethods.waitFor(5);

        extentTest.info("Sign In butonuna tiklandi");
        WebElement user = Driver.getDriver().findElement(By.xpath("//input[@id='username']"));
        user.sendKeys("testngteam06@hotmail.com");
        extentTest.info("Gecerli mail yazildi");
        WebElement pas = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        pas.sendKeys("Batch81");
        extentTest.info("Gecerli password yazildi");


        ReusableMethods.waitFor(3);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        WebElement sing = Driver.getDriver().findElement(By.xpath("//button[@name='login']"));
        extentTest.info("Basarili bir sekilde login olundu");

        try {
            sing.click();
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(sing));
            sing.click();

        }

        ReusableMethods.waitFor(3);

        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        WebElement account = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'My Account')]"));
        js.executeScript("arguments[0].click();", account);
        extentTest.info("My account butonuna basildi");

        Driver.getDriver().findElement(By.xpath("//a[normalize-space()='Store Manager']")).click();

        extentTest.info("Store Manager butonuna tiklandi");

    }
}