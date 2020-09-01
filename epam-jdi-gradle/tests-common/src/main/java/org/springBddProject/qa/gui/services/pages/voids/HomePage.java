package org.springBddProject.qa.gui.services.pages.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springBddProject.qa.gui.annotations.PageObject;

@PageObject
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
