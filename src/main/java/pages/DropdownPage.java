package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromDropdown(String option) {
        findDropdownElement(dropdown).selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> elements = findDropdownElement(dropdown).getAllSelectedOptions();
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private Select findDropdownElement(By element) {
        return new Select(driver.findElement(element));
    }
}
