package keys;

import basetest.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

import static org.testng.Assert.assertEquals;

public class KeysTests extends BaseTests {

    @Test
    public void testKeys() {
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPressesPage.getResultText(), "You entered: BACK_SPACE");
    }

    @Test
    public void testPi() {
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
        keyPressesPage.enterPi();
    }
}
