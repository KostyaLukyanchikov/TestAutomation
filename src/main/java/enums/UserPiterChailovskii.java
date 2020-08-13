package enums;

public enum UserPiterChailovskii {

    USER_CREDENTIALS ("PITER CHAILOVSKII"),
    USER_NAME ("epam"),
    PASSWORD ("1234");

    private String assertion;

    UserPiterChailovskii(String assertion) {
        this.assertion = assertion;
    }

    public String getData() {
        return assertion;
    }
}
