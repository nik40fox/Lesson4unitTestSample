package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegistrationPage;

/**
 * All possible tests for user Registration
 */
public class RegistrationTests {

    @Test
    public void registrationWithEmptyFieldsTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.open();
        registrationPage.fillAndSubmitRegistrationForm("","","","");
        Assert.assertEquals(registrationPage.getAlertText(), "Blah-blah-blah", "Expected message was not displayed");
    }

    @DataProvider(name = "emptyFieldsValuesCombination")
    public static Object[][] createData() {
        return new Object[][] {
                {"", "Last", "a@b.c", "P@ssword"},
                {"First", "", "a@b.c", "ssword"},
        };
    }


    @Test(dataProvider = "emptyFieldsValuesCombination")
    public void registrationAllEmptyFieldsCombination(String first, String last, String email, String password) {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.open();
        registrationPage.fillAndSubmitRegistrationForm("","","","");
        Assert.assertEquals(registrationPage.getAlertText(), "Blah-blah-blah", "Expected message was not displayed");
    }
}
