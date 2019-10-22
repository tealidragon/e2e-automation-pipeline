package steps.ui;

import com.overstock.clubo.common.enums.ClubType;
import pages.CartPage;
import pages.ClubOHubPage;

public class CartUISteps {
    public CartPage cartPage;

    public CartPage customerMessage(ClubType clubtype, String message) {
        cartPage.cart();
        return new CartPage();
    }

}