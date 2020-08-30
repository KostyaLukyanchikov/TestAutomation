package selenide.cases.case4;

import entities.MetalsAndColorsForm;
import entities.MetalsAndColorsForm.FormBuilder;
import enums.LoginUser;
import enums.UIElements;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenide.cases.BaseTest;
import selenide.cases.case4.steps.ActionSteps;
import selenide.cases.case4.steps.AssertionsSteps;

import java.util.List;

public class EpamJdiLoginAndMetalAndColorsTest extends BaseTest {

    private ActionSteps actionSteps;
    private AssertionsSteps assertionsSteps;

    @Override
    @BeforeMethod
    public void setUp() {
        super.setUp();
        this.actionSteps = new ActionSteps();
        this.assertionsSteps = new AssertionsSteps();
    }

    @DataProvider(name = "metalsAndColorsForms")
    public Object[][] builder() {
        return new Object[][]{
                {new FormBuilder()
                        .setElementsCheckBoxes("Earth")
                        .setColorsDropDownValue("Yellow")
                        .setMetalsDropDownValue("Gold")
                        .build()},
                {new FormBuilder()
                        .setOddRadioButton("3")
                        .setEvenRadioButton("8")
                        .setVegetablesDropDownCheckBoxes("Cucumber", "Tomato")
                        .build()},
                {new FormBuilder()
                        .setElementsCheckBoxes("Water", "Wind", "Fire")
                        .setOddRadioButton("3")
                        .setEvenRadioButton("2")
                        .setMetalsDropDownValue("Bronze")
                        .setVegetablesDropDownCheckBoxes("Onion")
                        .build()},
                {new FormBuilder()
                        .setElementsCheckBoxes("Water")
                        .setEvenRadioButton("6")
                        .setOddRadioButton("5")
                        .setColorsDropDownValue("Green")
                        .setMetalsDropDownValue("Selen")
                        .setVegetablesDropDownCheckBoxes("Cucumber", "Tomato", "Vegetables", "Onion")
                        .build()},
                {new FormBuilder()
                        .setElementsCheckBoxes("Fire")
                        .setColorsDropDownValue("Blue")
                        .setVegetablesDropDownCheckBoxes("Cucumber", "Tomato", "Vegetables")
                        .build()}
        };
    }

    @Test(dataProvider = "metalsAndColorsForms")
    public void epamJdiLoginAndMetalAndColorsTest(MetalsAndColorsForm form) {

        //Login test
        assertionsSteps.pageTitleAssertion(UIElements.HOME_PAGE);
        actionSteps.loginAsUser(LoginUser.PITER_CHAILOVSKII);
        assertionsSteps.userNameAssertion(LoginUser.PITER_CHAILOVSKII);

        //Navigate to MetalsAndColors page
        actionSteps.navigateToMetalsAndColorsPage();
        assertionsSteps.pageTitleAssertion(UIElements.METALS_AND_COLORS);

        //Fill the form
        actionSteps.fillTheForm(form);
        actionSteps.submitMetalsAndColorsForm();

        //Check results
        List<String> actualResults = actionSteps.getActualResults();
        assertionsSteps.resultLogsAssert(form, actualResults);

    }

}
