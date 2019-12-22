package utils;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {
    public static List<String> getItemsStartingWith(List<String> list, String startsWith) {
        return list.stream().filter(item -> item.startsWith(startsWith)).collect(Collectors.toList());
    }

    public static List<String> getSortedList(List<String> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }

    public static List<String> toLower(List<String> list) {
        return list.stream().map(String::toLowerCase).collect(Collectors.toList());
    }

    public static List<String> getValues(List<WebElement> list) {
        return list.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public static WebElement findByText(List<WebElement> list, String value) {
        return list.stream().filter(item->item.getText().equalsIgnoreCase(value)).findFirst().get();
    }
}
