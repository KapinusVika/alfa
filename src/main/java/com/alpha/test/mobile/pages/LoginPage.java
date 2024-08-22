package com.alpha.test.mobile.pages;

import com.alpha.test.mobile.utils.TimeConstant;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @ExtendedFindBy(text = "Вход в Alfa-Test")
    private ExtendedWebElement loginPageTitle;

    @FindBy(id = "com.alfabank.qapp:id/etUsername")
    private ExtendedWebElement loginInputField;

    @FindBy(id = "com.alfabank.qapp:id/etPassword")
    private ExtendedWebElement passwordInputField;

    @FindBy(id = "com.alfabank.qapp:id/btnConfirm")
    private ExtendedWebElement loginButton;

    @ExtendedFindBy(text = "Введены неверные данные")
    private ExtendedWebElement errorMessage;

    @ExtendedFindBy(accessibilityId = "Show password")
    private ExtendedWebElement showHidePasswordButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return loginPageTitle.isElementPresent(TimeConstant.PAGE_OPENING_TIMEOUT);
    }

    public void typeLogin(String login) {
        loginInputField.type(login);
    }

    public String getLoginText() {
        return loginInputField.getText();
    }

    public void typePassword(String password) {
        passwordInputField.type(password);
    }

    public String getPasswordText() {
        return passwordInputField.getText();
    }

    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(getDriver());
    }

    public HomePage login(String login, String password) {
        typeLogin(login);
        typePassword(password);
        return clickLoginButton();
    }

    public void clickShowHidePasswordButton() {
        showHidePasswordButton.click();
    }

    public boolean isPasswordHidden() {
        return Boolean.parseBoolean(passwordInputField.getAttribute("password"));
    }

    public boolean isErrorMessagePresent() {
        return errorMessage.isElementPresent(TimeConstant.SHORT_TIMEOUT);
    }
}
