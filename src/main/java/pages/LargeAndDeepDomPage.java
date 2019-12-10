package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {
    private WebDriver driver;
    private By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToTable() {
        WebElement tableElement = driver.findElement(table);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "arguments[0].scrollIntoView();";
        js.executeScript(script, tableElement);
    }
}
