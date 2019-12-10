package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTests {
    private EventFiringWebDriver driver;
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
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
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
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        driver.get("https://the-internet.herokuapp.com/");
        if (mobile) driver.manage().window().setSize(new Dimension(375, 812));
        else driver.manage().window().maximize();
        System.out.println(driver.getTitle());
    }


    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("disable-infobars");
        return chromeOptions;
    }
}
