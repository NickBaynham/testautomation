package waits;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExplicitWaitTests extends BaseTests {

    @Test
    public void testDynamicLoading() {
        var dynamicallyLoadedElementsPage = homePage.clickDynamicLoading().clickLinkExample1();
        dynamicallyLoadedElementsPage.clickButtonStart();
        assertEquals(dynamicallyLoadedElementsPage.getLoadedText(), "Hello World!");
    }
}
