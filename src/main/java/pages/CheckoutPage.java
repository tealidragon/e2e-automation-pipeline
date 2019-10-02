package pages;

import framework.JsonReader;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.overstock.com/checkout")
public class CheckoutPage extends PageObject {


    @FindBy(xpath = "//*[@id=\"clubo-gold-upgrade\"]")
    public WebElement clubo_check_box;

    @FindBy(xpath = "//*[contains(text(), \"Earned this Order\")]")
    public WebElement rewards_earned_this_order;

    @FindBy(xpath = "//*[contains(text(), \"Can Earn this Order\")]")
    public WebElement rewards_can_earn_this_order;

    @FindBy(xpath = "//*[contains(text(), \"Available to Apply\")]")
    public WebElementFacade rewards_available_to_apply;

    public CheckoutPage checkoutPage() {
        return new CheckoutPage();
    }


    private void checkCluboMessagingIsVisible() {

        //TODO -- Get to CHECKOUT from cart by adding things to the cart

        rewards_available_to_apply.isVisible();
    }

    private String getCluboEarnMessaging() {
        String earnMessaging;
        boolean earn = true;

        earnMessaging = earn ? rewards_can_earn_this_order.getText() : rewards_earned_this_order.getText();

        return earnMessaging;
    }

    static void getCheckoutJsonCheck() {

        try {
            JSONObject jsonObject = JsonReader.readJsonFromUrl("https://www.overstock.com/checkout?json=true");

            System.out.println(jsonObject.toString(2));

        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
