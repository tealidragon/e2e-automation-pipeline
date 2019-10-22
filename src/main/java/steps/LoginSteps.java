package steps;

import net.thucydides.core.annotations.Step;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    @Step
    public void enterLoginData(String username, String password) {
        loginPage.inputLoginInformation(username, "");
    }

}