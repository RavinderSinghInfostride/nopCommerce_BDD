package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By registerLink = By.xpath("//a[@class='ico-register']");
    String genderRadioButton = "//div[@class='gender']//span[@class='%s']//input[@name='Gender']";
    By firstNameInput = By.xpath("//input[@name='FirstName']");
    By lastNameInput = By.xpath("//input[@name='LastName']");
    By emailInput = By.xpath("//input[@name='Email']");
    By passwordInput = By.xpath("//input[@name='Password']");
    By confirmPasswordInput = By.xpath("//input[@name='ConfirmPassword']");
    By registerButton = By.xpath("//button[@name='register-button']");
    By registerContinueButton = By.xpath("//a[contains(@class,'register-continue-button')]");
    By searchInputBox = By.xpath("//input[contains(@class,'search-box-text')]");
    By searchButton = By.xpath("//button[contains(@class,'search-box-button')]");
    By productSearchedIsDisplayedVerify = By.xpath("//h2//a[contains(text(),'Apple MacBook Pro 13-inch')]");
    String navMenuOptions = "((//div[@class='header-menu']//ul[contains(@class,'top-menu')]//a[contains(text(),'%s')]))[1]";
    String computersSubCategoryOptions = "//div[@class='item-grid']//h2[@class='title']//a[contains(text(),' Desktops ')]";
    String allDesktopProducts = "//div[@class='item-grid']//div[@class='details']//h2//a[contains(text(),'%s')]";
    By addToWishlistButton = By.xpath("//div[@class='add-to-wishlist']//button[contains(@class,'add-to-wishlist-button')]");
    By addToWishlistSuccessNotification = By.xpath("//div[contains(@class,'success')]");
    By wishlistPageLink = By.xpath("//a[@class='ico-wishlist']");
    By productAddedToWishlistVerify = By.xpath("//a[contains(text(),'Digital Storm VANQUISH 3 Custom Performance PC')]");
    By addToCartButton = By.xpath("(//button[contains(@class,'add-to-cart-button')])[1]");
    By cartLink = By.xpath("//a[@class='ico-cart']");
    By productAddedToCartVerify = By.xpath("(//a[contains(text(),'Digital Storm VANQUISH 3 Custom Performance PC')])[2]");
    By termsAndConditionCheckbox = By.xpath("//input[@name='termsofservice']");
    By checkoutButton = By.xpath("//button[@name='checkout']");
    By countryDropdown = By.xpath("//select[@name='BillingNewAddress.CountryId']");
    By countryDropdownOption = By.xpath("//option[@value='133'][contains(text(),'India')]");
    By cityInputBox = By.xpath("//input[@name='BillingNewAddress.City']");
    By address1InputBox = By.xpath("//input[@name='BillingNewAddress.Address1']");
    By zidCodeInputBox = By.xpath("//input[@name='BillingNewAddress.ZipPostalCode']");
    By phoneNumberInputBox = By.xpath("//input[@name='BillingNewAddress.PhoneNumber']");
    By checkoutDetailsContinueButton = By.xpath("(//button[contains(@class,'new-address-next-step-button')])[1]");

    int randomNumber = (int) (Math.random() * (99 - 11 + 1) + 11);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void userNavigatesToRegisterPage() {
        driver.findElement(registerLink).click();
    }

    public void userRegisters() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//TestData.xlsx";
        FileInputStream testData = null;
        try {
            testData = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(testData);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String gender = sheet.getRow(2).getCell(0).getStringCellValue();
        String firstName = sheet.getRow(2).getCell(1).getStringCellValue();
        String lastName = sheet.getRow(2).getCell(2).getStringCellValue();
        String password = sheet.getRow(2).getCell(3).getStringCellValue();
        String email = firstName + lastName + randomNumber + "@mail.com";
        driver.findElement(By.xpath(String.format(genderRadioButton, gender))).click();
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    public void continueButtonClick() {
        driver.findElement(registerContinueButton).click();

    }

    public void searchProduct() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//TestData.xlsx";
        FileInputStream testData = null;
        try {
            testData = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(testData);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String productToSearch = sheet.getRow(5).getCell(0).getStringCellValue();
        driver.findElement(searchInputBox).sendKeys(productToSearch);
        driver.findElement(searchButton).click();
    }

    public void productSearchedIsDisplayedVerify() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//TestData.xlsx";
        FileInputStream testData = null;
        try {
            testData = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(testData);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String productSearchVerify = sheet.getRow(5).getCell(1).getStringCellValue();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productSearchedIsDisplayedVerify));
        String isProductSearchedDisplayed = driver.findElement(productSearchedIsDisplayedVerify).getText();
        Assert.assertEquals(productSearchVerify, isProductSearchedDisplayed);
    }

    public void navigateToDesktopPage() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//TestData.xlsx";
        FileInputStream testData = null;
        try {
            testData = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(testData);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String navMenuOptionToHover = sheet.getRow(8).getCell(0).getStringCellValue();
        String computersSubCategoryOption = sheet.getRow(8).getCell(1).getStringCellValue();
        driver.findElement(By.xpath(String.format(navMenuOptions, navMenuOptionToHover))).click();
        driver.findElement(By.xpath(String.format(computersSubCategoryOptions, computersSubCategoryOption))).click();
    }

    public void addDesktopToWishlist() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//TestData.xlsx";
        FileInputStream testData = null;
        try {
            testData = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(testData);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String desktopProductToAddToWishlist = sheet.getRow(8).getCell(2).getStringCellValue();
        driver.findElement(By.xpath(String.format(allDesktopProducts, desktopProductToAddToWishlist))).click();
        driver.findElement(addToWishlistButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(addToWishlistSuccessNotification));
        driver.findElement(wishlistPageLink).click();
        String isProductAddedToWishlistCorrect = driver.findElement(productAddedToWishlistVerify).getText();
        Assert.assertEquals(isProductAddedToWishlistCorrect, desktopProductToAddToWishlist);
    }

    public void addProductToCart() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//TestData.xlsx";
        FileInputStream testData = null;
        try {
            testData = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(testData);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String desktopProductToAddToCart = sheet.getRow(8).getCell(2).getStringCellValue();
        driver.findElement(By.xpath(String.format(allDesktopProducts, desktopProductToAddToCart))).click();
        driver.findElement(addToCartButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(addToWishlistSuccessNotification));
        driver.findElement(cartLink).click();
        String isProductAddedToCartCorrect = driver.findElement(productAddedToCartVerify).getText();
        Assert.assertEquals(desktopProductToAddToCart,isProductAddedToCartCorrect);
    }

    public void checkoutFromCart() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//TestData.xlsx";
        FileInputStream testData = null;
        try {
            testData = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(testData);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String city = sheet.getRow(11).getCell(0).getStringCellValue();
        String address1 = sheet.getRow(11).getCell(1).getStringCellValue();
        driver.findElement(termsAndConditionCheckbox).click();
        driver.findElement(checkoutButton).click();
        driver.findElement(countryDropdown).click();
        driver.findElement(countryDropdownOption).click();
        driver.findElement(cityInputBox).sendKeys(city);
        driver.findElement(address1InputBox).sendKeys(address1);
        driver.findElement(zidCodeInputBox).sendKeys("123456");
        driver.findElement(phoneNumberInputBox).sendKeys("9999999999");
        driver.findElement(checkoutDetailsContinueButton).click();
    }
}