package enums.Header;

import java.util.Arrays;
import java.util.List;

public enum HeaderServiceElements {

    SUPPORT("SUPPORT"),
    DATES("DATES"),
    SEARCH("SEARCH"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    USER_TABLE("USER_TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS"),
    PERFORMANCE("PERFORMANCE");

    private String headerServiceElement;

    HeaderServiceElements(String headerServiceElement) {
        this.headerServiceElement = headerServiceElement;
    }

    public String getHeaderServiceElement() {
        return headerServiceElement;
    }

    public static List<String> getElementsServiceFromHeaderShouldContain() {
        return Arrays.asList(
                SUPPORT.getHeaderServiceElement(),
                DATES.getHeaderServiceElement(),
                COMPLEX_TABLE.getHeaderServiceElement(),
                SIMPLE_TABLE.getHeaderServiceElement(),
                TABLE_WITH_PAGES.getHeaderServiceElement(),
                DIFFERENT_ELEMENTS.getHeaderServiceElement());
    }

}

