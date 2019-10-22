package steps.ui;

import com.overstock.clubo.common.enums.ClubType;
import pages.CheckoutPage;
import pages.ClubOHubPage;

public class CheckoutUISteps {
    public CheckoutPage checkoutPage;

    public CheckoutPage customerMessage(ClubType clubtype, String message) {
        checkoutPage.checkoutPage();
        return new CheckoutPage();
    }

}