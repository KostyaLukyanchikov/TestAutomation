package сase2;

import entities.User;
import enums.Header.HeaderServiceElements;
import enums.UIElements;
import enums.UserPiterChailovskii;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import сase2.steps.AssertionSteps;
import сase2.steps.HomePageSteps;

import java.util.Arrays;
import java.util.List;


public class EpamJdiLoginAndServicesTest extends BaseTest {

    AssertionSteps assertionSteps;
    HomePageSteps homePageSteps;

    User user = new User(
            UserPiterChailovskii.USER_CREDENTIALS.getData(),
            UserPiterChailovskii.USER_NAME.getData(),
            UserPiterChailovskii.PASSWORD.getData()
    );

    @Override
    @BeforeMethod
    public void setUpBrowser() {
        super.setUpBrowser();
        assertionSteps = new AssertionSteps(driver);
        homePageSteps = new HomePageSteps(driver);
    }

    @Test
    public void loginTest() {

        assertionSteps.browserTitleAssertion(UIElements.HOME_PAGE.getUiElement());

        homePageSteps.loginAsUser(user);

        assertionSteps.userNameAssertion(user);

    }

    @Test
    public void serviceSubCategoryFromHeaderTest() {

        homePageSteps.loginAsUser(user);
        assertionSteps.userNameAssertion(user);

        homePageSteps.openServiceDropDownMenu();

        List<String> elementsServiceShouldContain= Arrays.asList(
                HeaderServiceElements.SUPPORT.getHeaderServiceElement(),
                HeaderServiceElements.DATES.getHeaderServiceElement(),
                HeaderServiceElements.COMPLEX_TABLE.getHeaderServiceElement(),
                HeaderServiceElements.SIMPLE_TABLE.getHeaderServiceElement(),
                HeaderServiceElements.TABLE_WITH_PAGES.getHeaderServiceElement(),
                HeaderServiceElements.DIFFERENT_ELEMETNTS.getHeaderServiceElement());


        List<String> actualServiceElements = homePageSteps.getServiceElementsFromHeader();
        assertionSteps.headerServiceAssertion(actualServiceElements, elementsServiceShouldContain);
    }

}
