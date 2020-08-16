package enums.Header;

import java.util.Arrays;
import java.util.List;

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

    public static List<String> getHeaderElements() {
        return Arrays.asList(
                HEADER_HOME.getHeaderElement(), HEADER_CONTACT_FORM.getHeaderElement(),
                HEADER_SERVICE.getHeaderElement(), HEADER_METALS_COLORS.getHeaderElement());
    }

}
