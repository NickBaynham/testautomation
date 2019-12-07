package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;

    private By buttonJSAlert = By.xpath("//button[text()='Click for JS Alert']");
    private By buttonJSConfirm = By.xpath("//button[text()='Click for JS Confirm']");
    private By buttonJSPrompt = By.xpath("//button[text()='Click for JS Prompt']");
    private By result = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonJSAlert() {
        driver.findElement(buttonJSAlert).click();
    }

    public void clickButtonJSConfirm() {
        driver.findElement(buttonJSConfirm).click();
    }

    public void clickButtonJSPrompt() {
        driver.findElement(buttonJSPrompt).click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void enterAlertText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public String getResultText() {
        return driver.findElement(result).getText();
    }
}
