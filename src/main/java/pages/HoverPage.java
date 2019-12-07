package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoverPage {
    private WebDriver driver;
    private By figure = By.cssSelector(".row .figure");
    private By boxCaption = By.className("figcaption");

    public HoverPage(WebDriver driver) {
        this.driver = driver;
    }

    public FigureCaption hoverOnFigure(int index) {
        List<WebElement> figures = driver.findElements(figure);
        WebElement figure = figures.get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).build().perform();
        return new FigureCaption(figure.findElement(boxCaption));
    }

    public class FigureCaption {

        private WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        public boolean isCaptionDisplayed() {
            return caption.isDisplayed();
        }

        public String getTitle() {
            return caption.findElement(header).getText();
        }

        public String getLink() {
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText() {
            return caption.findElement(link).getText();
        }
    }
}
