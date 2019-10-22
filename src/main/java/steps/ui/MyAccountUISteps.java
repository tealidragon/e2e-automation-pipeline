package steps.ui;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import pages.MyAccountPage;

public class MyAccountUISteps {
    public MyAccountPage myAccountPage;

    @Step("Get the profile Header webElement.")
    public WebElement profileHeader() {
        return myAccountPage.profile_header;
    }

    @Step("Get the My Account Header webElement.")
    public WebElement mact_header_element() {
        return myAccountPage.mact_header_element;
    }

    @Step("Get the member status text")
    public WebElement member_status_text() {
        return myAccountPage.member_status_text;
    }

    @Step("Get the profile Header webElement.")
    public WebElement club_o_balance() {
        return myAccountPage.club_o_balance;
    }

    @Step("Get the profile Header webElement.")
    public WebElement view_rewards() {
        return myAccountPage.view_rewards;
    }

    @Step("Get the profile Header webElement.")
    public WebElement balances_header() {
        return myAccountPage.balances_header;
    }

    @Step("Get the profile Header webElement.")
    public WebElement profile_header() {
        return myAccountPage.profile_header;
    }

    public WebElement club_o_info_header() {
        return myAccountPage.club_o_info_header;
    }

    @Step("Get the profile Header webElement.")
    public WebElement orders_carousel_header_element() {
        return myAccountPage.orders_carousel_header_element;
    }

    public WebElement chat_header_element() {
        return myAccountPage.chat_header_element;
    }

    @Step("Get the profile Header webElement.")
    public WebElement left_rail_club_o_nav() {
        return myAccountPage.left_rail_club_o_nav;
    }

    @Step("Get the profile Header webElement.")
    public WebElement left_menu_club_ohrefs() {
        return myAccountPage.left_menu_club_ohrefs;
    }

    @Step("Get the profile Header webElement.")
    public WebElement left_menu_clubo() {
        return myAccountPage.left_menu_clubo;
    }

    @Step("Get the profile Header webElement.")
    public void clickCluboMenuLeft() {
        left_rail_club_o_nav().click();
    }

}