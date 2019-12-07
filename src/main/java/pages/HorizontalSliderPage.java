package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By slider = By.cssSelector(".sliderContainer input");
    private By range = By.cssSelector("span#range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveSlider(int howMany) {
        WebElement sliderInput = driver.findElement(slider);
        sliderInput.click();
        for (int i = 0; i < howMany; i++) {
            sliderInput.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public int getRange() {
        WebElement spanRange = driver.findElement(range);
        return Integer.parseInt(driver.findElement(range).getText());
    }

}
