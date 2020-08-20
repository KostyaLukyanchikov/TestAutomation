package selenide.cases.case3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.conditions.Visible;
import enums.Header.HeaderServiceElements;
import enums.LeftSideBar.LeftSideBarServiceElements;
import enums.LoginUser;
import enums.UIElements;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.objects.fluents.HomePage;
import page.objects.fluents.TableWithPagesPage;
import selenide.cases.BaseTest;

import java.util.List;

import static org.testng.Assert.*;

public class EpamJdiLoginAndServiceTableWithPagesTest extends BaseTest {

    private HomePage homePage;
    private TableWithPagesPage tableWithPagesPage;

    private List<String> elementsServiceFromHeaderShouldContain = HeaderServiceElements
            .getElementsServiceFromHeaderShouldContain();

    private List<String> elementsServiceFromLeftSideBarShouldContain = LeftSideBarServiceElements
            .getElementsServiceFromLeftSideBarShouldContain();

    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        homePage = new HomePage();
    }

    @Test
    public void epamJdiElementsLoginTest() {

        //Login test
        pageTitleAssertion(UIElements.HOME_PAGE);
        homePage.login(LoginUser.PITER_CHAILOVSKII);
        userNameAssersion(LoginUser.PITER_CHAILOVSKII);

        //Service DropDown Content Test
        List<String> actualServiceDropDownElementsFromHeader = homePage.grabServiceElementsFromHeader();
        List<String> actualServiceDropDownElementsFromLeftSideBar = homePage.grabServiceElementsFromLeftSideBar();
        serviceContentAssertion(actualServiceDropDownElementsFromHeader, elementsServiceFromHeaderShouldContain);
        serviceContentAssertion(actualServiceDropDownElementsFromLeftSideBar, elementsServiceFromLeftSideBarShouldContain);

        //Service TableWithPages Page Test
        tableWithPagesPage = homePage.refresh().headerServiceTableWithPagesClick();
        tableWithPagesPage.getDropDown().shouldHave(Condition.text("5"));
        tableWithPagesPage.getLeftSection().shouldBe(Condition.exist);
        tableWithPagesPage.getRightSection().shouldBe(Condition.exist);

        tableWithPagesPage.setDropDownValue("10");
        String actualDropDownLog = tableWithPagesPage.getDropDownLog();
        assertEquals(actualDropDownLog,"10");

        List<SelenideElement> searchList = tableWithPagesPage.getSearchList();
        assertEquals(searchList.size(), 10);

        tableWithPagesPage.setSearchValue("Custom");
        String actualSearchLog = tableWithPagesPage.getSearchLog();
        assertEquals(actualSearchLog,"Custom");

        List<SelenideElement> searchElementsNowSectionList = tableWithPagesPage.getSearchElementsNowSectionList();
        SoftAssert softAssert = new SoftAssert();
        searchElementsNowSectionList
                .stream()
                .forEach(row -> softAssert.assertTrue(row.getText().contains("Custom")));
        softAssert.assertAll();
    }

}
