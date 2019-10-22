package ui;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ClubOHubPage;
import pages.LoginPage;
import steps.ui.ClubOHubUISteps;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("type:UI"),
        @WithTag("pattern:PageObject")
})
public class ClubOHubPageTest {
    @Managed
    WebDriver driver;

    @Managed
    ClubOHubPage clubOHubPage;

    @Steps
    ClubOHubUISteps findFlightsUISteps;

    @Managed
    LoginPage loginPage;

    @Test
    public void validateHubPageTitle() {

        loginPage.inputLoginInformation("igold@o.co", "");
//        Assert.assertEquals(clubOHubPage.getTitle(), "Overstock.com: Online Shopping - Bedding, Furniture, Electronics, Jewelry, Clothing & more");
    }

    @Test
    public void validateMainHeroButton() {
        loginPage.inputLoginInformation("igold@o.co", "");
//        loginSteps.loginUser();
        clubOHubPage.open();

        SoftAssertions softass = new SoftAssertions();
        System.out.println(clubOHubPage.mainHero.getText());
        System.out.println(clubOHubPage.ostkLoyaltyProgram_MainHerobutton.getText());

        Assert.assertEquals(clubOHubPage.mainHero.getText(), "Club O Rewards\n" +
                "Overstock's Loyalty Program\n" +
                "Start your 30-day free trial. Only $19.95 / year after\n" +
                "Cancel trial anytime\n" +
                "Start Free Trial Membership\n" +
                "∮ Terms & Conditions apply.");
        Assert.assertEquals(clubOHubPage.ostkLoyaltyProgram_MainHerobutton.getText(), "Start Free Trial Membership\n" +
                "∮ Terms & Conditions apply.");
    }


}