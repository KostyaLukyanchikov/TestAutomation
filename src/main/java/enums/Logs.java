package enums;

public enum Logs {

    WATER_BOX_ON ("Water: condition changed to true"),
    WIND_BOX_ON ("Wind: condition changed to true"),
    SELEN_RADIO_ON ("metal: value changed to Selen");

    private String buttonState;

    Logs(String buttonState) {
        this.buttonState = buttonState;
    }

    public String getButtonState() {
        return buttonState;
    }
}
