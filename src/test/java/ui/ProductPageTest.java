package ui;

import com.overstock.clubo.common.builders.CustDto;
import com.overstock.clubo.common.enums.ClubType;
import com.overstock.clubo.common.enums.MemberStatus;
import com.overstock.clubo.common.enums.OptInStatus;
import data.CustomerGenerator;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductPage;
import steps.ui.ProductPageUISteps;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag("type:UI"),
        @WithTag("pattern:PageObject")
})
public class ProductPageTest {
    @Managed
    WebDriver driver;

    @Managed
    ProductPage productPage;

    @Managed
    LoginPage loginPage;

//    @TestData
//    public static Collection<Object[]> testData() {
//        return Arrays.asList(new Object[][]{
//                {activeMemberCustomers.get(0)},
//                {activeMemberCustomers.get(1)}
//        });
//    }

//    public static List<CustDto> activeMemberCustomers = new CustomerGenerator().activeMembers();
//    public static CustDto customerUnderTest = new com.overstock.clubo.common.builders.CustBuilder()
//            .setNewClubO(ClubType.CLUBO)
//            .withOptInStatus(OptInStatus.N)
//            .withCloActualEndPlusOrMinusDays(-2)
//            .withMemberStatus(MemberStatus.EXPIRED)
//            .buildDto();

//    public ProductPageTest(CustDto customerUnderTest) {
//        this.customerUnderTest = customerUnderTest;
//    }

    @Steps
    ProductPageUISteps productPageUISteps;

    @Test
    public void validateProductPageTitleForAll() {

        loginPage.inputLoginInformation("igold@o.co", "password123");
        productPage.getProductPage();
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void validateProductPageTitle() {

        loginPage.inputLoginInformation("igold@o.co", "password");
        productPage.getProductPage();
        System.out.println(driver.getCurrentUrl());
    }


    @Test
    public void validateClubOPerksMessaging() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        String clubOCallout = productPageUISteps.getClubOPerksMessage().getText();
//        String clubOCallout = productPage.getProductPage().cluboproductoffer.getText();
//        loginSteps.loginUser();
//        productPage.open("product.page", PageObject.withParameters(new FriscProductIds().getNOTFREERETURN_PRODUCT_WITH_CLUBO_REWARDS_GREATERTHAN10_AND_PRICEGREATERTHAN45().getProductId().toString()));

        assertThat(clubOCallout, containsString("Free Shipping"));
        System.out.println(clubOCallout);

    }

    @Test
    public void validateClubOProductOffered() {
        loginPage.inputLoginInformation("igold@o.co", "password");

        String clubOProductOffer = productPageUISteps.getClubOProductOffer().getText();
        assertThat(clubOProductOffer, containsString("$19.95"));
        System.out.println("Club O product offered: " + clubOProductOffer);
    }


}