package selenide.cases.case4.steps;

import entities.MetalsAndColorsForm;
import page.objects.fluents.HomePage;
import page.objects.fluents.MetalsAndColorsPage;

public abstract class BaseSteps {

    protected HomePage homePage;
    protected MetalsAndColorsPage metalsAndColorsPage;
    protected MetalsAndColorsForm form;

    public BaseSteps() {
        homePage = new HomePage();
    }

}
