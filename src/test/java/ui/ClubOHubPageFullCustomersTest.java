package ui;

import com.overstock.clubo.common.enums.ClubType;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ClubOHubPage;
import pages.LoginPage;
import steps.ui.ClubOHubUISteps;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
@WithTags({
        @WithTag("type:UI"),
        @WithTag("pattern:PageObject")
})
@Concurrent
public class ClubOHubPageFullCustomersTest {
    @Managed WebDriver driver;

    @Managed ClubOHubPage clubOHubPage;
    @Managed
    LoginPage loginPage;

    ClubOHubUISteps steps;

    @TestData
    public static Collection<Object[]> testCustomers(){
        return Arrays.asList(new Object[][]{
            {ClubType.CLUBO, "Start Free Trial Membership\n" +
                    "∮ Terms & Conditions apply."},
                {ClubType.CLUBO_FREE_TRIAL, "Start Free Trial Membership\n" +
                    "∮ Terms & Conditions apply."}
        });
    }

    private final ClubType clubType;
    private final String message;

    public ClubOHubPageFullCustomersTest(ClubType clubType, String message) {
        this.clubType=clubType;
        this.message=message;
    }
    @Test
    public void  validateHubPageTitle() {

//        new com.overstock.clubo.common.builders.CustBuilder()
//                .setNewClubO(clubType)
//                .withOptInStatus(OptInStatus.N)
//                .withCloActualEndPlusOrMinusDays(-2)
//                .withMemberStatus(MemberStatus.EXPIRED)
//                .buildDto();
        loginPage.inputLoginInformation("igold@o.co","");
        clubOHubPage.open();
        steps.customerMessage(clubType, message);


        Assert.assertEquals(clubOHubPage.getTitle(), "Overstock.com: Online Shopping - Bedding, Furniture, Electronics, Jewelry, Clothing & more");
    }

    @Test
    public void  validateMainHeroButton() {
        clubOHubPage.open();

        SoftAssertions softass = new SoftAssertions();
        System.out.println(clubOHubPage.mainHero.getText());
        System.out.println(clubOHubPage.ostkLoyaltyProgram_MainHerobutton.getText());

        Assert.assertEquals(clubOHubPage.mainHero.getText(),"Club O Rewards\n" +
                "Overstock's Loyalty Program\n" +
                "Start your 30-day free trial. Only $19.95 / year after\n" +
                "Cancel trial anytime\n" +
                "Start Free Trial Membership\n" +
                "∮ Terms & Conditions apply.");
        Assert.assertEquals(clubOHubPage.ostkLoyaltyProgram_MainHerobutton.getText(), "Start Free Trial Membership\n" +
                "∮ Terms & Conditions apply.");
    }


}