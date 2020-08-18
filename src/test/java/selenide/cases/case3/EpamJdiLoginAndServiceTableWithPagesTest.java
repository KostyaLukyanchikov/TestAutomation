package selenide.cases.case3;

import enums.Header.HeaderServiceElements;
import enums.LeftSideBar.LeftSideBarServiceElements;
import enums.LoginUser;
import enums.UIElements;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.fluents.HomePage;
import page.objects.fluents.TableWithPagesPage;
import selenide.cases.BaseTest;

import java.util.List;

public class EpamJdiLoginAndServiceTableWithPagesTest extends BaseTest {

    HomePage homePage;
    TableWithPagesPage tableWithPagesPage;

    List<String> elementsServiceFromHeaderShouldContain = HeaderServiceElements
            .getElementsServiceFromHeaderShouldContain();

    List<String> elementsServiceFromLeftSideBarShouldContain = LeftSideBarServiceElements
            .getElementsServiceFromLeftSideBarShouldContain();

    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        homePage = new HomePage();
    }

    @Test
    public void epamJdiElementsLoginTest() {
        pageTitleAssertion(UIElements.HOME_PAGE);
        homePage.login(LoginUser.PITER_CHAILOVSKII);
        userNameAssersion(LoginUser.PITER_CHAILOVSKII);
    }

    @Test
    public void serviceDropDownContentTest() {
        homePage.login(LoginUser.PITER_CHAILOVSKII);
        List<String> actualServiceDropDownElementsFromHeader = homePage.grabServiceElementsFromHeader();
        List<String> actualServiceDropDownElementsFromLeftSideBar = homePage.grabServiceElementsFromLeftSideBar();

        serviceContentAssertion(actualServiceDropDownElementsFromHeader, elementsServiceFromHeaderShouldContain);
        serviceContentAssertion(actualServiceDropDownElementsFromLeftSideBar, elementsServiceFromLeftSideBarShouldContain);
    }

    @Test
    public void serviceTableWithPagesPageTest() {
        homePage.login(LoginUser.PITER_CHAILOVSKII);
        homePage.headerServiceTableWithPagesClick();

    }

}
