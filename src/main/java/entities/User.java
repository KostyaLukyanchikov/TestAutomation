package entities;

import enums.LoginUser;

public class User {

    private String userCredentials;
    private String userName;
    private String password;

    public User(LoginUser loginUser) {
        this.userCredentials = loginUser.getCredentials();
        this.userName = loginUser.getName();
        this.password = loginUser.getPassword();
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
