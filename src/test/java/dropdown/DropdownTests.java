package dropdown;

import basetest.ParallelTests;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends ParallelTests {

    @Test
    public void testDropdownSelectOption() {
        DropdownPage dropdownPage = homePage.clickLinkDropdown();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        List<String> selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option was not selected");
    }
}
