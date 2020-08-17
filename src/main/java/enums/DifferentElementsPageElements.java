package enums;

public enum DifferentElementsPageElements {

    //CheckBoxes

    WATER_CHECKBOX ("Water"),
    WIND_CHECKBOX ("Wind");

    private String checkBoxText;

    DifferentElementsPageElements(String checkBoxText) {
        this.checkBoxText = checkBoxText;
    }

    public String getCheckBoxText() {
        return checkBoxText;
    }
}
