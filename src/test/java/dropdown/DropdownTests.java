package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {

    @Test
    public void testDropdownSelectOption() {
        var dropdownPage = homePage.clickLinkDropdown();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option was not selected");
    }
}
