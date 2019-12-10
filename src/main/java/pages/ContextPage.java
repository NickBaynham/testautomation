package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextPage {
    private WebDriver driver;
    private By hotspot = By.id("hot-spot");


    public ContextPage(WebDriver driver) {
        this.driver = driver;
    }

    public void rightClickHotSpot() {
        WebElement hotspotElement = driver.findElement(hotspot);
        Actions actions = new Actions(driver);
        actions.contextClick(hotspotElement).build().perform();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
}
