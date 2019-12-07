package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.util.List;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        setupDriver(false);
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void reset() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
        driver = null;
    }

    public static void main(String[] args) {
        BaseTests baseTests = new BaseTests();
        baseTests.findingElements();
    }

    private void findingElements() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(375, 812));
        System.out.println(driver.getTitle());

        WebElement linkInputs = driver.findElement(By.linkText("Inputs"));
        linkInputs.click();

        // Count the links on the page

        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> allLinksOnThePage = driver.findElements(By.tagName("a"));
        System.out.println("Page has " + allLinksOnThePage.size() + " links.");

        // No Such Element Exception

        try {
            WebElement linkScott = driver.findElement(By.linkText("Scott"));
        } catch (NoSuchElementException e) {
            System.out.println("Sorry bud, that element does not exist!");
        }

        // shifting Menu Element Counter

        driver.get("https://the-internet.herokuapp.com/");
        WebElement linkShiftingContent = driver.findElement(By.linkText("Shifting Content"));
        linkShiftingContent.click();

        WebElement linkExample1MenuElement = driver.findElement(By.linkText("Example 1: Menu Element"));
        linkExample1MenuElement.click();
        List<WebElement> menuItems = driver.findElements(By.cssSelector("div li a"));
        System.out.println("Menu has " + menuItems.size() + " items");

        driver.quit();

    }

    public void setupDriver(boolean mobile) {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        if (mobile) driver.manage().window().setSize(new Dimension(375, 812));
        else driver.manage().window().maximize();
        System.out.println(driver.getTitle());
    }
}
