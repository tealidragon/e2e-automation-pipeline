package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.overstock.com/club-o-rewards-program")
public class ClubOHubPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"clubOHubRoot\"]//*[@class=\"hero\"]")
    public WebElement mainHero;

    @FindBy(xpath = "//*[@id=\"clubOHubRoot\"]//div[@class=\"perks\"]/h1")
    public WebElement header1;

    @FindBy(xpath = "//*[@id=\"clubOHubRoot\"]//div[@class=\"perks\"]/h1")
    public WebElementFacade headerFacade;

    @FindBy(xpath = "//*[@id=\"clubOHubRoot\"]//div[@class=\"title\"]")
    public WebElement getMoreWithClubO;

    @FindBy(xpath = "//*[@id=\"clubOHubRoot\"]//div[@class=\"callout\"]")
    public WebElement hotelsCallout;

    @FindBy(xpath = "//*[@id=\"clubOHubRoot\"]//div[@class=\"callout\"]/following-sibling::div")
    public WebElement ostkLoyaltyProgram_HotelsDescription;

    @FindBy(xpath = "//*[@id=\"clubOHubRoot\"]//div[@class=\"callout\"]/following-sibling::button")
    public WebElement ostkLoyaltyProgram_HotelsButton;

    @FindBy(xpath = "//*[@id=\"clubOHubRoot\"]//div[@class=\"callout\"]/../..//../*[@alt=\"hotels by Overstock™\"]")
    public WebElement ostkLoyaltyProgram_hotelsByOverstock;

    @FindBy(xpath = "//*[@id=\"freeShippingIcon\"]")
    public WebElement ostkLoyaltyProgram_FreeShipping;

    @FindBy(xpath = "//*[@id=\"freeShippingIcon\"]//..//*[@class=\"description\"]")
    public WebElement ostkLoyaltyProgram_FreeShippingText;

    @FindBy(xpath = "//*[@id=\"rewardsBackIcon\"]")
    public WebElement ostkLoyaltyProgram_5PercentRewards;

    @FindBy(xpath = "//*[@id=\"rewardsBackIcon\"]//..//*[@class=\"description\"]")
    public WebElement ostkLoyaltyProgram_5PercentRewardsText;

    @FindBy(xpath = "//*[@id=\"employeeRewardsBackIcon\"]")
    public WebElement ostkLoyaltyProgram_10PercentRewards;

    @FindBy(xpath = "//*[@id=\"freeReturnsIcon\"]")
    public WebElement ostkLoyaltyProgram_FreeReturns;

    @FindBy(xpath = "//*[@id=\"freeReturnsIcon\"]//..//*[@class=\"description\"]")
    public WebElement ostkLoyaltyProgram_FreeReturnsText;

    @FindBy(xpath = "//*[@id=\"priceMatchIcon\"]")
    public WebElement ostkLoyaltyProgram_PriceMatchGuarantee;

    @FindBy(xpath = "//*[@id=\"priceMatchIcon\"]//..//*[@class=\"description\"]")
    public WebElement ostkLoyaltyProgram_PriceMatchGuaranteeText;

    @FindBy(xpath = "//*[@id=\"ExtraRewardsStoreIcon\"]")
    public WebElement ostkLoyaltyProgram_ExtraRewardsStore;

    @FindBy(xpath = "//*[@id=\"ExtraRewardsStoreIcon\"]//..//*[@class=\"description\"]")
    public WebElement ostkLoyaltyProgram_ExtraRewardsStoreText;

    @FindBy(xpath = "//*[@id=\"rewardsForReviewsIcon\"]")
    public WebElement ostkLoyaltyProgram_RewardsForReviews;

    @FindBy(xpath = "//*[@id=\"rewardsForReviewsIcon\"]//..//*[@class=\"description\"]")
    public WebElement ostkLoyaltyProgram_RewardsForReviewsText;

    @FindBy(xpath = "//*[@id=\"clubOHubRoot\"]//*[@class=\"hero\"]//*[@class=\"club-o-button\"]")
    public WebElement ostkLoyaltyProgram_MainHerobutton;

    @FindBy(xpath = "//*[@id=\"clubOHubRoot\"]//*[@class=\"hero\"]//*[@class=\"club-o-button\"]//*[@class=\"terms\"]")
    public WebElement ostkLoyaltyProgram_TsandCs;

    @WhenPageOpens
    public void waitUntilPageLoads(){
        element(mainHero).waitUntilVisible();
    }

    public ClubOHubPage hub(){
        return new ClubOHubPage();
    }

    public void checkThatHeaderIsVisible(){
        headerFacade.isVisible();
        headerFacade.shouldBeVisible();
        headerFacade.isCurrentlyVisible();
    }
}
