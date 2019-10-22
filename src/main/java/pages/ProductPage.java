package pages;

import com.overstock.automation.db.tables.product.Product;
import com.overstock.clubo.common.builders.helper.ProOptIds;
import com.overstock.clubo.common.util.ProductUtils;
import com.overstock.model.Id;
import com.overstock.model.ids.ProductId;
import data.FriscProductIds;
import framework.JsonReader;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.WhenPageOpens;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;

import java.util.Map;

@DefaultUrl("https://www.overstock.com/blah/blah/9809209/product.html")
@NamedUrls({
        @NamedUrl(name = "product.page", url = "https://www.overstock.com/blah/blah/{1}/product.html")
})
public class ProductPage extends PageObject {
    private String regexMatchingDollarAmount = "\\$[0-9,\\.]*";
    private String regexMatchingDollarAmountWithSurroundingParentheses = "\\(\\$[0-9,\\.]*\\)";
    private String regexMatchingZeroDollarAmount = "$0.00";
    private String clubOMember_Active_ItemLessThan45_NFR_Message = String.format("You get Free Shipping\\* and %s in Rewards on this item.", regexMatchingDollarAmount);
    private String clubOMember_Active_ItemGreaterThan45_NFR_Message = String.format("You get %s in Rewards on this item.", regexMatchingDollarAmount);
    private String clubOMember_Active_ItemLessThan45_Q4FR_Message = String.format("You get Free Shipping and Free Returns\\*, plus %s in Rewards on this item.", regexMatchingDollarAmount);
    private String clubOMember_Active_ItemGreaterThan45_Q4FR_Message = String.format("You get Free Returns\\* and %s in Rewards on this item.", regexMatchingDollarAmount);


    private static final String CLUBOMEMBER_ACTIVE_CLUBOCALLOUTLINEONE = "Club O member:";
    private static final String TRYCLUBO_JOINMESSAGE_CLUBOCALLOUTLINETWO = "Club O membership is only $19.95/year. Learn More";
    private static final String TRYCLUBO_FTMESSAGE_CLUBOCALLOUTLINETWO = "Try Club O free for 30 days. Only $19.95/year after. Learn More";
    private static final String RENEWCLUBO_RENEWMESSAGE_CLUBOCALLOUTLINETWO = "Renew Club O membership for only $19.95/year. Learn More";

    private Map<String, String> data;
    private int timeout = 20;

    @FindBy(css = "div.YG-yD6Q")
    @CacheLookup
    public WebElement freeShippingFreeReturnsrenew;

    @FindBy(css = "div._3VZrV9T")
    @CacheLookup
    public WebElement cluboproductoffer;

    @WhenPageOpens
    public void waitUntilPageLoads(){
        element(freeShippingFreeReturnsrenew).waitUntilVisible();
    }

    public ProductPage getProductPage() {
        return new ProductPage();

    }

}
