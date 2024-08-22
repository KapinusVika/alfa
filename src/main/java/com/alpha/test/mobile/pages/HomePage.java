package com.alpha.test.mobile.pages;

import com.alpha.test.mobile.utils.TimeConstant;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    @ExtendedFindBy(text = "Вход в Alfa-Test выполнен")
    private ExtendedWebElement homePageTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return homePageTitle.isElementPresent(TimeConstant.PAGE_OPENING_TIMEOUT);
    }
}
