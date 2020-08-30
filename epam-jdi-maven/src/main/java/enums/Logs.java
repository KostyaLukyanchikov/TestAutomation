package enums;

public enum Logs {

    //Different Elements Page
    WATER_BOX_ON ("Water: condition changed to true"),
    WIND_BOX_ON ("Wind: condition changed to true"),
    WATER_BOX_OFF ("Water: condition changed to false"),
    WIND_BOX_OFF ("Wind: condition changed to false"),
    SELEN_RADIO_ON ("metal: value changed to Selen"),
    YELLOW_DROP_DOWN_ON ("Colors: value changed to Yellow");

    private String buttonState;

    Logs(String buttonState) {
        this.buttonState = buttonState;
    }

    public String getButtonState() {
        return buttonState;
    }
}
