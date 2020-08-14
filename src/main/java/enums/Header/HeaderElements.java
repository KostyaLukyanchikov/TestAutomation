package enums.Header;

public enum HeaderElements {

    HEADER_HOME("HOME"),
    HEADER_CONTACT_FORM("CONTACT FORM"),
    HEADER_SERVICE("SERVICE"),
    HEADER_METALS_COLORS("METALS & COLORS");

    private String headerElement;

    HeaderElements(String headerElement) {
        this.headerElement = headerElement;
    }

    public String getHeaderElement() {
        return headerElement;
    }

}
