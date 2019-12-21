package hover;

import basetest.BaseTests;
import org.testng.annotations.Test;
import pages.HoverPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTests {

    @Test
    public void testHover() {
        HoverPage hoverPage = homePage.clickHovers();
        HoverPage.FigureCaption figureCaption = hoverPage.hoverOnFigure(0);
        assertTrue(figureCaption.isCaptionDisplayed());
        assertEquals(figureCaption.getLinkText(), "View profile");
        assertEquals(figureCaption.getTitle(), "name: user1");
        assertTrue(figureCaption.getLink().endsWith("/users/1"));
    }
}
