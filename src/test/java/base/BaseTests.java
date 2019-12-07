package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(375, 812));
        System.out.println(driver.getTitle());

        WebElement linkInputs = driver.findElement(By.linkText("Inputs"));
        linkInputs.click();
        driver.quit();
    }

    public static void main(String[] args) {
        BaseTests baseTests = new BaseTests();
        baseTests.setUp();
    }
}
