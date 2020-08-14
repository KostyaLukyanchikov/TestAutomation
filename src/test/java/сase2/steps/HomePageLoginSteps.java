package сase2.steps;

import entities.User;
import org.openqa.selenium.WebDriver;
import page_objects.HomePage;

public class HomePageLoginSteps {

    private WebDriver driver;
    private HomePage homePage;

    public HomePageLoginSteps(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }


    public void loginAsUser(User user) {
        homePage.login(user);
    }

}
