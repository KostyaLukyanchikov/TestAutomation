package page.objects.fluents;

import enums.LoginUser;

public class HomePage extends BasePage {

    public HomePage login(LoginUser user) {
        userIconButton.click();
        userNameInputField.sendKeys(user.getName());
        userPasswordInputField.sendKeys(user.getPassword());
        loginSubmitButton.click();
        return this;
    }

}
