package selenide.cases.case4.steps;

import com.codeborne.selenide.SelenideElement;
import entities.MetalsAndColorsForm;
import enums.LoginUser;
import enums.UIElements;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.AssertJUnit.assertEquals;

public class AssertionsSteps extends BaseSteps {

    public void pageTitleAssertion(UIElements uiElement) {
        assertEquals(title(), uiElement.getUiElement());
    }

    public void userNameAssertion(LoginUser loginUser) {
        assertEquals(element(By.id("user-name")).getText(), loginUser.getCredentials());
    }

    public void resultLogsAssert(MetalsAndColorsForm form) {
        List<String> formValuesList = form.getValuesList();
        List<String> values = new ArrayList<>();
        for (String value : formValuesList) {
            if (!(value.equals("null"))) {
                values.add(value);
            }
        }
        System.out.println(values);
    }

}
