package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.overstock.com" + "/myaccount")
public class MyAccountPage extends PageObject {
    @FindBy(xpath = "//*[@id=\"re-mact-header\"]")
    public WebElement mact_header_element;

    @FindBy(xpath = "//*[@id=\"re-mact-header\"]//ul/li/a")
    public WebElement member_status_text;

    @FindBy(xpath = "//*[@class=\"clubo-balance\"]")
    public WebElement club_o_balance;

    @FindBy(xpath = "//*[@class=\"clubo-balance\"]")
    public WebElement view_rewards;

    @FindBy(xpath = "//*[@id=\"re-mact-header\"]//ul/li[@class=\"balance header-element\"]")
    public WebElement balances_header;

    @FindBy(xpath = "//*[@id=\"re-mact-header\"]//ul/li[@class=\"profile header-element\"]")
    public WebElement profile_header;

    @FindBy(xpath = "//*[@id=\"re-mact-header\"]//ul/li[@class=\"club-o header-element\"]")
    public WebElement club_o_info_header;

    @FindBy(xpath = "//*[@id=\"re-mact-header\"]//ul/li[@class=\"orders-carousel header-element\"]")
    public WebElement orders_carousel_header_element;

    @FindBy(xpath = "//*[@id=\"re-mact-header\"]//ul/li[@class=\"chat header-element\"]")
    public WebElement chat_header_element;

    @FindBy(xpath = "//span[text()=\"Club O\"]")
    public WebElement left_rail_club_o_nav;

    @FindBy(xpath = "//*[@id=\"left-menu\"]//span[text()=\"Club O\"]/../ul/li/a")
    public WebElement left_menu_club_ohrefs;

    @FindBy(xpath = "//*[@id=\"left-menu\"]//span[text()=\"Club O\"]")
    public WebElement left_menu_clubo;

    public MyAccountPage myAccountPage() {
        return new MyAccountPage();
    }

    @FindBy(xpath = ".//*[@id='left-menu']//span[text()='Club O']")
    WebElement leftNav_ClubO;

    @FindBy(xpath = ".//*[contains(text(),'Perks')]")
    WebElement leftNav_Perks;

    @FindBy(xpath = ".//*[contains(text(),'Extra Rewards Store')]")
    WebElement leftNav_Extra_Reward;

    @FindBy(xpath = ".//*[contains(text(),'Rewards Summary')]")
    WebElementFacade leftNav_RewardSummary;

    @FindBy(xpath = ".//*[contains(text(),'Club O Rewards MasterCard')]")
    WebElement leftNav_Rewards_MC;

    @FindBy(id = "userName")
    WebElement txt_welcomemessage;

    @FindBy(xpath = ".//*[@id='breadCrumbs']//*[text()='Back to My Account']")
    WebElement btn_backtoMyAcct;

    @FindBy(xpath = ".//h1[contains(text(),'My Rewards')]")
    WebElementFacade txt_myRewards;

    @FindBy(xpath = ".//*[text()='Payment Settings']")
    WebElement paymentsetting;

    public void click_clubo_perks() {
        leftNav_ClubO.click();
        leftNav_Perks.click();
    }

    public void click_clubo_RewardsStore() {

        leftNav_Extra_Reward.click();
    }

    public void click_clubo_Rewards_MC() {

        leftNav_Rewards_MC.click();
    }

    public boolean Click_RewardSummary() {
        leftNav_RewardSummary.click();
        return txt_myRewards.isVisible();
    }

    public boolean IscluboRewards_loaded() {
        return txt_myRewards.isVisible();
    }
}
