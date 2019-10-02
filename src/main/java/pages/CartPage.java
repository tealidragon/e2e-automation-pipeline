package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.json.JSONObject;
import org.openqa.selenium.support.FindBy;
import framework.JsonReader;

@DefaultUrl("https://www.overstock.com/cart")
public class CartPage extends PageObject {

    @FindBy(xpath = "//*[@class = \"rewards \"]/*[contains(text(), \"Earn\")]")
    public WebElementFacade earn_on_this_order_messaging;

    @FindBy(xpath = "//*[contains(text(), \"Available to Apply\")]")
    public WebElementFacade available_to_apply_messaging;

    public CartPage cart(){
        return new CartPage();
    }

    private void checkCluboMessagingIsVisible() {
        earn_on_this_order_messaging.isVisible();
        available_to_apply_messaging.isVisible();
    }

    private String getCluboEarnOnMessagain() {
        return earn_on_this_order_messaging.getText();
    }

    private String getCluboAvailableToApplyMessagain() {
        return available_to_apply_messaging.getText();
    }

    private void getCartJsonObject() {

        try {
            JSONObject jsonObject = JsonReader.readJsonFromUrl("http://www.overstock.com/api/cart.json");
            System.out.println(jsonObject.toString(2));

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
