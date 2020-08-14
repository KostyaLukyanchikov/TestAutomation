package сase2;

import entities.User;
import enums.UserPiterChailovskii;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import сase2.steps.AssertionSteps;
import сase2.steps.HomePageLoginSteps;


public class EpamJdiLoginAndServicesTest extends BaseTest {

    AssertionSteps assertionSteps;
    HomePageLoginSteps homePageLoginSteps;

    @Override
    @BeforeMethod
    public void setUpBrowser() {
        super.setUpBrowser();
        assertionSteps = new AssertionSteps(driver);
        homePageLoginSteps = new HomePageLoginSteps(driver);
    }

    @Test
    public void servicesDiffrentElementsTest() {

        User user = new User(
                UserPiterChailovskii.USER_CREDENTIALS.getData(),
                UserPiterChailovskii.USER_NAME.getData(),
                UserPiterChailovskii.PASSWORD.getData()
        );

        homePageLoginSteps.loginAsUser(user);
        assertionSteps.homePageAssertion();
        assertionSteps.userNameAssersion(user);

    }

}
