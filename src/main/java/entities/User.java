package entities;

public class User {

    private String userCredentials;
    private String userName;
    private String password;

    public User(String userCredentials, String userName, String password) {
        this.userCredentials = userCredentials;
        this.userName = userName;
        this.password = password;
    }

    public String getUserCredentials() {
        return userCredentials;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
