package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicallyLoadedElementsPage {
    private WebDriver driver;
    private By buttonStart = By.xpath("//button[text()='Start']");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.id("finish");

    public DynamicallyLoadedElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonStart() {
        driver.findElement(buttonStart).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }
}
