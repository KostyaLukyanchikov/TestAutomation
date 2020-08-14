package enums.Header;

public enum HeaderServiceElements {

    SUPPORT ("SUPPORT"),
    DATES ("DATES"),
    SEARCH ("SEARCH"),
    COMPLEX_TABLE ("COMPLEX TABLE"),
    SIMPLE_TABLE ("SIMPLE TABLE"),
    USER_TABLE ("USER_TABLE"),
    TABLE_WITH_PAGES ("TABLE WITH PAGES"),
    DIFFERENT_ELEMETNTS("DIFFERENT ELEMENTS"),
    PERFORMANCE ("PERFORMANCE");

    private String headerServiceElement;

    HeaderServiceElements(String headerServiceElement) {
        this.headerServiceElement = headerServiceElement;
    }

    public String getHeaderServiceElement() {
        return headerServiceElement;
    }
}
