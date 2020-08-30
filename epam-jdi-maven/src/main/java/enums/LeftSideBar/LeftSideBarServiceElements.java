package enums.LeftSideBar;

import java.util.Arrays;
import java.util.List;

public enum LeftSideBarServiceElements {

    SUPPORT ("Support"),
    DATES ("Dates"),
    COMPLEX_TABLE ("Complex Table "),
    SIMPLE_TABLE ("Simple Table"),
    SEARCH ("Search"),
    USER_TABLE ("User Table"),
    TABLE_WITH_PAGES ("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE ("Performance");

    private String leftSideBarServiceElement;

    LeftSideBarServiceElements(String leftSideBarServiceElement) {
        this.leftSideBarServiceElement = leftSideBarServiceElement;
    }

    public String getLeftSideBarServiceElement() {
        return leftSideBarServiceElement;
    }

    public static List<String> getElementsServiceFromLeftSideBarShouldContain() {
        return Arrays.asList(
                SUPPORT.getLeftSideBarServiceElement(),
                DATES.getLeftSideBarServiceElement(),
                COMPLEX_TABLE.getLeftSideBarServiceElement(),
                SIMPLE_TABLE.getLeftSideBarServiceElement(),
                TABLE_WITH_PAGES.getLeftSideBarServiceElement(),
                DIFFERENT_ELEMENTS.getLeftSideBarServiceElement());
    }

}
