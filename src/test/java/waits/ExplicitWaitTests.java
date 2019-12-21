package waits;

import basetest.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicallyLoadedElementsPage;

import static org.testng.Assert.assertEquals;

public class ExplicitWaitTests extends BaseTests {

    @Test
    public void testDynamicLoading() {
        DynamicallyLoadedElementsPage dynamicallyLoadedElementsPage = homePage.clickDynamicLoading().clickLinkExample1();
        dynamicallyLoadedElementsPage.clickButtonStart();
        assertEquals(dynamicallyLoadedElementsPage.getLoadedText(), "Hello World!");
    }
}
