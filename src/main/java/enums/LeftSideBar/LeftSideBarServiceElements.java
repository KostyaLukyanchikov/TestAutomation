package enums.LeftSideBar;

public enum LeftSideBarServiceElements {

    SUPPORT ("Support"),
    DATES ("Dates"),
    COMPLEX_TABLE ("Complex Table"),
    SIMPLE_TABLE ("Simple Table"),
    SEARCH ("Search"),
    USER_TABLE ("User Table"),
    TABLE_WITH_PAGES ("Table with pages"),
    DIFFERENT_ELEMTNTS ("Different elements"),
    PERFORMANCE ("Performance");

    private String leftSideBarServiceElement;

    LeftSideBarServiceElements(String leftSideBarServiceElement) {
        this.leftSideBarServiceElement = leftSideBarServiceElement;
    }



    public String getLeftSideBarServiceElement() {
        return leftSideBarServiceElement;
    }
}
