package ui;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.MyAccountPage;
import steps.ui.MyAccountUISteps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("type:UI"),
        @WithTag("pattern:PageObject")
})
public class MyAccountUITest {
    @Managed
    WebDriver driver;

    @Managed
    MyAccountPage myAccountPage;

    @Managed
    LoginPage loginPage;

    @Steps
    MyAccountUISteps myAccountSteps;

    @Test
    public void validateMyAccountPageTitle() {

        loginPage.inputLoginInformation("igold@o.co", "password");
        myAccountPage.getMyAccountPage();
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void validateMAUITitle() {

        loginPage.inputLoginInformation("igold@o.co", "password");
        myAccountPage.getMyAccountPage();
        System.out.println(driver.getCurrentUrl());
    }


    @Test
    public void validate_MAUI_profile_header() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        WebElement clubOCallout = myAccountSteps.profileHeader();

        assertThat(clubOCallout.getText(), containsString("Club O Membership:"));
        System.out.println(clubOCallout.getText());
    }

    @Test
    public void validate_MAUI_mact_header_element() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        WebElement clubOCallout = myAccountSteps.mact_header_element();
        assertThat(clubOCallout.getText(), containsString(""));
        System.out.println(clubOCallout.getText());
    }

    @Test
    public void validate_MAUI_member_status_text() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        WebElement clubOCallout = myAccountSteps.member_status_text();
        assertThat(clubOCallout.getText(), containsString(""));
        System.out.println(clubOCallout.getText());
    }

    @Test
    public void validate_MAUI_club_o_balance() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        WebElement clubOCallout = myAccountSteps.club_o_balance();
        assertThat(clubOCallout.getText(), containsString(""));
        System.out.println(clubOCallout.getText());
    }

    @Test
    public void validate_MAUI_view_rewards() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        WebElement clubOCallout = myAccountSteps.view_rewards();
        assertThat(clubOCallout.getText(), containsString(""));
        System.out.println(clubOCallout.getText());
    }

    @Test
    public void validate_MAUI_balances_header() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        WebElement clubOCallout = myAccountSteps.balances_header();
        assertThat(clubOCallout.getText(), containsString(""));
        System.out.println(clubOCallout.getText());
    }

    @Test
    public void validate_MAUI_club_o_info_header() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        WebElement clubOCallout = myAccountSteps.club_o_info_header();
        assertThat(clubOCallout.getText(), containsString(""));
        System.out.println(clubOCallout.getText());
    }

    @Test
    public void validate_MAUI_orders_carousel_header_element() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        WebElement clubOCallout = myAccountSteps.orders_carousel_header_element();
        assertThat(clubOCallout.getText(), containsString(""));
        System.out.println(clubOCallout.getText());
    }

    @Test
    public void validate_MAUI_chat_header_element() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        WebElement clubOCallout = myAccountSteps.chat_header_element();
        assertThat(clubOCallout.getText(), containsString(""));
        System.out.println(clubOCallout.getText());
    }

    @Test
    public void validate_MAUI_left_rail_club_o_nav() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        WebElement clubOCallout = myAccountSteps.left_rail_club_o_nav();
        assertThat(clubOCallout.getText(), containsString(""));
        System.out.println(clubOCallout.getText());
    }

    @Test
    public void validate_MAUI_left_menu_club_ohrefs() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        WebElement clubOCallout = myAccountSteps.left_menu_club_ohrefs();
        System.out.println(clubOCallout.getText());
    }

    @Test
    public void validate_MAUI_left_menu_clubo() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        WebElement clubOCallout = myAccountSteps.left_menu_clubo();
        assertThat(clubOCallout.getText(), containsString(""));
        System.out.println(clubOCallout.getText());
    }
}