package enums;

public enum LoginUser {

    PITER_CHAILOVSKII ("PITER CHAILOVSKII", "epam", "1234");

    private String credentials;
    private String name;
    private String password;

    LoginUser(String credentials, String name, String password) {
        this.credentials = credentials;
        this.name = name;
        this.password = password;
    }

    public String getCredentials() {
        return credentials;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}