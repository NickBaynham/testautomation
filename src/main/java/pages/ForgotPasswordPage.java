package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    WebDriver driver;
    By inputEmail = By.id("email");
    By buttonRetrievePassword = By.cssSelector("#forgot_password button");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmailAddress(String emailAddress) {
        driver.findElement(inputEmail).sendKeys(emailAddress);
    }

    public EmailSentPage clickButtonRetrievePassword() {
        driver.findElement(buttonRetrievePassword).click();
        return new EmailSentPage(driver);
    }
}
