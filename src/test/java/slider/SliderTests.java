package slider;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;

public class SliderTests extends BaseTests {

    @Test
    public void testSliderChange() {
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.moveSlider(8);
        assertEquals(horizontalSliderPage.getRange(), 5);
    }
}
