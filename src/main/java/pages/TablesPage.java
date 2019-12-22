package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.w3schools.com/bootstrap/bootstrap_tables.asp
public class TablesPage {
    private WebDriver driver;

    private By table = By.xpath("(//h3[text()='Example'])[1]");

    public TablesPage(WebDriver driver) {
        this.driver = driver;
    }

    private List<Map<String,String>> getTableData() {
        List<Map<String,String>> data = new ArrayList<>();
        List<String> headers = new ArrayList<>();
        List<WebElement> headings = driver.findElement(table).findElements(By.tagName("th"));
        for (WebElement heading : headings) {
            String header = heading.getText();
            headers.add(header);
        }
        List<WebElement> rows = driver.findElement(table).findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<String> rowData = new ArrayList<>();
            List<WebElement> columns = row.findElements(By.tagName("td"));
            for (WebElement column: columns) {
                String cellValue = column.getText();
                rowData.add(cellValue);
            }
            // add a row as a map
            Map<String,String> nextRow = new HashMap<>();
            for (int i = 0; i < headers.size(); i++) {
                nextRow.put(headers.get(i), rowData.get(i));
            }
            data.add(nextRow);
        }
        return data;
    }

    public String getEmail(String firstName, String lastName) {
        for (Map<String,String> row : getTableData()) {
            if (row.get("Firstname").equalsIgnoreCase(firstName) && row.get("Lastname").equalsIgnoreCase(lastName)) {
                return row.get("Email");
            }
        }
        return null;
    }
}
