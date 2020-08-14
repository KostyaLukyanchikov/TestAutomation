package сase2;

import entities.User;
import enums.UIElements;
import enums.UserPiterChailovskii;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import сase2.steps.AssertionSteps;
import сase2.steps.HomePageSteps;


public class EpamJdiLoginAndServicesTest extends BaseTest {

    AssertionSteps assertionSteps;
    HomePageSteps homePageLoginSteps;

    @Override
    @BeforeMethod
    public void setUpBrowser() {
        super.setUpBrowser();
        assertionSteps = new AssertionSteps(driver);
        homePageLoginSteps = new HomePageSteps(driver);
    }

    @Test
    public void servicesDifferentElementsTest() {

        assertionSteps.browserTitleAssertion(UIElements.HOME_PAGE.getUiElement());

        User user = new User(
                UserPiterChailovskii.USER_CREDENTIALS.getData(),
                UserPiterChailovskii.USER_NAME.getData(),
                UserPiterChailovskii.PASSWORD.getData()
        );

        homePageLoginSteps.loginAsUser(user);

        assertionSteps.userNameAssertion(user);

    }

}
