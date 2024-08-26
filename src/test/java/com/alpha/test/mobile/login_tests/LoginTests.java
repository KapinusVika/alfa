package com.alpha.test.mobile.login_tests;

import com.alpha.test.mobile.pages.HomePage;
import com.alpha.test.mobile.pages.LoginPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends AbstractTest {

    private static final String USER_LOGIN = R.TESTDATA.get("user_login");
    private static final String USER_PASSWORD = R.TESTDATA.get("user_password");
    private static final String VALID_LOGIN_REGEX = "[A-Za-z .,/\'_\\-]*";
    private static final String RANDOM_VALUE = RandomStringUtils.randomAlphabetic(12);

    public LoginPage initialiseLoginPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened!");
        return loginPage;
    }

    @Test(description = "Verify user is able to login with valid credentials")
    public void verifyValidLoginTest() {
        LoginPage loginPage = initialiseLoginPage();
        HomePage homePage = loginPage.login(USER_LOGIN, USER_PASSWORD);
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
    }

    @Test(description = "Verify the login field accepts fewer than 50 valid characters")
    public void verifyIncorrectLoginValueTest() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = initialiseLoginPage();
        String invalidLogin = generateInvalidLogin();
        loginPage.typeLogin(invalidLogin);
        softAssert.assertEquals(loginPage.getLoginText().length(), 50,
                "Entered login was not truncated!");
        softAssert.assertTrue(loginPage.getLoginText().matches(VALID_LOGIN_REGEX),
                "Invalid characters were not removed! ");
        softAssert.assertTrue(loginPage.isErrorMessagePresent(),
                "Error message is not present for invalid login!");
        softAssert.assertAll();
    }

    @Test(description = "Verify it is possible to show and hide entered password")
    public void verifyUserCanHideAndShowPasswordTest() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = initialiseLoginPage();
        loginPage.typePassword(RANDOM_VALUE);
        loginPage.clickShowHidePasswordButton();
        softAssert.assertFalse(loginPage.isPasswordHidden(), "Entered password is not shown!");
        loginPage.clickShowHidePasswordButton();
        softAssert.assertTrue(loginPage.isPasswordHidden(), "Entered password is not hidden!");
        softAssert.assertAll();
    }

    @Test(description = "Verify the password field does not accept more than 50 characters")
    public void verifyIncorrectPasswordValueTest() {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = initialiseLoginPage();
        loginPage.typePassword(RandomStringUtils.randomAlphabetic(60));
        softAssert.assertEquals(loginPage.getPasswordText().length(), 50,
                "Entered password was not truncated!");
        softAssert.assertTrue(loginPage.isErrorMessagePresent(),
                "Error message is not present for invalid login!");
        softAssert.assertAll();
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginDataProvider() {
        return new Object[][]{
                {RANDOM_VALUE, RANDOM_VALUE},
                {RANDOM_VALUE, ""},
                {"", RANDOM_VALUE},
                {"", ""}
        };
    }

    @Test(dataProvider = "invalidLoginData", description = "Verify user is not able to login with invalid data")
    public void verifyInvalidLoginTest(String login, String password) {
        LoginPage loginPage = initialiseLoginPage();
        HomePage homePage = loginPage.login(login, password);
        Assert.assertTrue(loginPage.isErrorMessagePresent(), "Error message is not present!");
        Assert.assertFalse(homePage.isPageOpened(), "User is able to login with invalid data!");
    }

    public String generateInvalidLogin() {
        String invalidCharacters = "!@#$%^&*()+=<>?{}[]|\\~`";
        String validCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz .,/\'_- ";
        String combinedCharacters = validCharacters + invalidCharacters;
        return RandomStringUtils.random(60, combinedCharacters);
    }

}
