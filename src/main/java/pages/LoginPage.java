package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://www.overstock.com/myaccount")
public class LoginPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"loginEmailInput\"]")
    public WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"loginPasswordInput\"]")
    public WebElement passwordField;

    @WhenPageOpens
    public void waitUntilLoginFormAppears() {
        element(usernameField).waitUntilVisible();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        open();
    }

    public void inputLoginInformation(String emailAddress, String password) {
        typeInto(usernameField, emailAddress);
        if (password.isEmpty())
            typeInto(passwordField, "password");
        typeInto(passwordField, password);

//        usernameField.sendKeys(emailAddress);
//        passwordField.sendKeys("password");

        passwordField.submit();

    }


}
