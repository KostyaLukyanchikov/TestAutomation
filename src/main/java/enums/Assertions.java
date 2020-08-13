package enums;

public enum Assertions {

    HOME_PAGE ("Home Page"),
    USER_NAME ("PITER CHAILOVSKII");

    private String assertion;

    Assertions(String assertion) {
        this.assertion = assertion;
    }

    public String getAssertion() {
        return assertion;
    }
}
