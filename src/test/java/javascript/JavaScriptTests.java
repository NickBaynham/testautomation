package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollDownToElement() {
        homePage.clickLargeAndDeepDom().scrollToTable();
    }
}
