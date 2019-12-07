package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    private By inputUsername = By.id("username");
    private By inputPassword = By.id("password");
    private By buttonSubmit = By.cssSelector("#login button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public SecureAreaPage clickSubmit() {
        driver.findElement(buttonSubmit).click();
        return new SecureAreaPage(driver);
    }
}
