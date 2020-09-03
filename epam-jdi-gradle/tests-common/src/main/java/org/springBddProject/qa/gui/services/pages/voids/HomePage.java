package org.springBddProject.qa.gui.services.pages.voids;

import org.openqa.selenium.By;
import org.springBddProject.qa.gui.annotations.PageObject;
import org.springframework.beans.factory.annotation.Value;

@PageObject
public class HomePage extends BasePage {

    @Value("${site.url}")
    protected String epamUrl;

    public void open() {
        driver.get(this.epamUrl);
    }

    public String getUserNameShown(){
       return driver.findElement(By.id("user-name")).getText();
    }

}
