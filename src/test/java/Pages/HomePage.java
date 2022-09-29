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
}