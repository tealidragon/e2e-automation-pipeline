package pages;

import com.overstock.automation.db.tables.product.Product;
import com.overstock.clubo.common.builders.helper.ProOptIds;
import com.overstock.clubo.common.util.ProductUtils;
import com.overstock.model.Id;
import com.overstock.model.ids.ProductId;
import framework.JsonReader;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class ProductPage extends PageObject {

    public static final Product NOTFREERETURN_PRODUCT_WITH_CLUBO_REWARDS_LESSTHAN10_AND_PRICELESSTHAN45 = ProOptIds.getProductIds().get("productNQ4FR_CORLessThan10PriceLessThan45");
    public static final Product NOTFREERETURN_PRODUCT_WITH_CLUBO_REWARDS_LESSTHAN10_AND_PRICEGREATERTHAN45 = ProOptIds.getProductIds().get("productNQ4FR_CORLessThan10PriceGreaterThan45");
    public static final Product NOTFREERETURN_PRODUCT_WITH_CLUBO_REWARDS_GREATERTHAN10_AND_PRICELESSTHAN45 = ProOptIds.getProductIds().get("productNQ4FR_CORGreaterThan10PriceLessThan45");
    public static final Product NOTFREERETURN_PRODUCT_WITH_CLUBO_REWARDS_GREATERTHAN10_AND_PRICEGREATERTHAN45 = ProOptIds.getProductIds().get("productNQ4FR_CORGreaterThan10PriceGreaterThan45");
    public static final Product FREERETURN_PRODUCT_WITH_CLUBO_REWARDS_LESSTHAN10_AND_PRICE_LESSTHAN45 = ProOptIds.getProductIds().get("productQ4FR_CORLessThan10PriceLessThan45");
    public static final Product FREERETURN_PRODUCT_WITH_CLUBO_REWARDS_LESSTHAN10_AND_PRICE_GREATERTHAN45 = ProOptIds.getProductIds().get("productQ4FR_CORLessThan10PriceGreaterThan45");
    public static final Product FREERETURN_PRODUCT_WITH_CLUBO_REWARDS_GREATERTHAN10_AND_PRICELESSTHAN45 = ProOptIds.getProductIds().get("productQ4FR_CORGreaterThan10PriceLessThan45");
    public static final Product FREERETURN_PRODUCT_WITH_CLUBO_REWARDS_GREATERTHAN10_AND_PRICEGREATERTHAN45 = ProOptIds.getProductIds().get("productQ4FR_CORGreaterThan10PriceGreaterThan45");

    private static final String CLUBOMEMBER_ACTIVE_CLUBOCALLOUTLINEONE = "Club O member:";
    private static final String TRYCLUBO_JOINMESSAGE_CLUBOCALLOUTLINETWO = "Club O membership is only $19.95/year. Learn More";
    private static final String TRYCLUBO_FTMESSAGE_CLUBOCALLOUTLINETWO = "Try Club O free for 30 days. Only $19.95/year after. Learn More";
    private static final String RENEWCLUBO_RENEWMESSAGE_CLUBOCALLOUTLINETWO = "Renew Club O membership for only $19.95/year. Learn More";


    private Map<String, String> data;
    private int timeout = 15;


    @FindBy(xpath = "//*[@id=\"clubo-container\"]")
    public WebElementFacade cluboContainer;

    @FindBy(xpath = "//*[@class = \"clubo-callout-line-one\"]")
    public WebElementFacade cluboCalloutLineOne;

    @FindBy(xpath = "//*[@class = \"clubo-callout-line-two\"]")
    public WebElementFacade cluboCalloutLineTwo;

    @FindBy(xpath = "//*[@type=\"checkbox\"]")
    public WebElementFacade cluboCheckBox;

    @FindBy(xpath = "//*[@id=\"clubOModal\"]")
    public WebElementFacade clubOModal;

    @FindBy(xpath = "//*[@href=\"#clubOModal\"]")
    public WebElementFacade cluboLearnMoreLink;

    @FindBy(xpath = "//*[@id=\"clubOModal\"]//*[@class=\"perk-subheader-text\"]")
    public WebElementFacade clubOModalHeader;

    @FindBy(xpath = "//*[@id=\"clubOModal\"]//*[@class=\"perk-container\"]")
    public WebElementFacade clubOModalPerkContainer;

    @FindBy(xpath = "//*[@id=\"clubOModal\"]//*[contains(text(), 'Shipping')]/../..//../*[@class= \"perk-description\"]")
    public WebElementFacade clubOModalShipping;

    @FindBy(xpath = "//*[@id=\"clubOModal\"]//*[contains(text(), 'Returns')]/../..//../*[@class= \"perk-description\"]")
    public WebElementFacade clubOModalReturns;

    @FindBy(xpath = "//*[@id=\"clubOModal\"]//*[contains(text(), '% Rewards')]/../..//../*[@class= \"perk-description\"]")
    public WebElementFacade clubOModal5percent;

    @FindBy(xpath = "//*[@id=\"clubOModal\"]//*[contains(text(), 'Extra')]/../..//../*[@class= \"perk-description\"]")
    public WebElementFacade clubOModalExtraRewards;

    @FindBy(xpath = "//*[@id=\"clubOModal\"]//*[@class= \"perk-footer\"]//*")
    public WebElementFacade clubOModalFooter;

    @FindBy(id = "addCartMain_addCartButton")
    @CacheLookup
    private WebElement addToCart;

    @FindBy(id = "addToRegistryBtn")
    @CacheLookup
    private WebElement addToRegistry;

    @FindBy(css = "input.actn-block-email")
    @CacheLookup
    private WebElement captchaAnswer1;

    @FindBy(css = "input.product-alerts-captcha-input")
    @CacheLookup
    private WebElement captchaAnswer2;

    @FindBy(css = "a[href='https://www.overstock.com/Eyeshadow,/brand,/results.html']")
    @CacheLookup
    private WebElement eyeshadow;

    @FindBy(css = "button.os-btn.btn-md.default.heart-button")
    @CacheLookup
    private WebElement favorites;

    @FindBy(id = "clubo-gold-upgrade")
    @CacheLookup
    private WebElement getFreeShippingAndFreeReturns;

    @FindBy(css = "#optbreakout div.option-breakout. div:nth-of-type(1) div:nth-of-type(2) button:nth-of-type(3)")
    @CacheLookup
    private WebElement l;

    @FindBy(css = "a.learn-more-btn")
    @CacheLookup
    private WebElement learnMore1;

    @FindBy(css = "a.clubo-modal-link")
    @CacheLookup
    private WebElement learnMore2;

    @FindBy(css = "button.promo-cta-btn")
    @CacheLookup
    private WebElement learnMore3;

    @FindBy(css = "#clubOModal div:nth-of-type(3) div:nth-of-type(3) a")
    @CacheLookup
    private WebElement learnMoreAboutClubO;

    @FindBy(css = "#optbreakout div.option-breakout. div:nth-of-type(1) div:nth-of-type(2) button:nth-of-type(2)")
    @CacheLookup
    private WebElement m;

    private final String pageLoadedText = "This glossary is here to help you decipher online shopping descriptions, so you can buy clothes that are right for you";

    private final String pageUrl = "/Clothing-Shoes/Womens-Eyeshadow-Casual-Polka-Dot-Top-with-Tiered-Ruffle-Sleeves/28059580/product.html";

    @FindBy(id = "ship-zip")
    @CacheLookup
    private WebElement pleaseEnterAValidZipCode;

    @FindBy(css = "a[href='https://api.overstock.com/help/article/privacy-and-security-policy']")
    @CacheLookup
    private WebElement privacyPolicy;

    @FindBy(css = "a.review-average-product-info")
    @CacheLookup
    private WebElement reviewThisItem;

    @FindBy(css = "#optbreakout div.option-breakout. div:nth-of-type(1) div:nth-of-type(2) button:nth-of-type(1)")
    @CacheLookup
    private WebElement s;

    @FindBy(id = "addqty28059580")
    @CacheLookup
    private WebElementFacade size4chooseSizemlxlpleaseSelectAnOption;

    @FindBy(css = "a.add-to-cart")
    @CacheLookup
    private WebElement startFreeTrialMembership;

    @FindBy(css = "a.os-btn.btn-sm.info.actn-block-email-btn")
    @CacheLookup
    private WebElement submit;

    @FindBy(css = "a[href='https://api.overstock.com/help/article/terms-and-conditions']")
    @CacheLookup
    private WebElement termsConditions;

    @FindBy(css = "a.clubo-terms-conditions-link")
    @CacheLookup
    private WebElement termsConditionsApply;

    @FindBy(css = "#shipping-estimates-form div.input-wrapper.sm.zipcode-input button.os-btn.btn-sm.form-disable,.gray")
    @CacheLookup
    private WebElement update;

    @FindBy(css = "#optbreakout div.option-breakout. div:nth-of-type(1) div:nth-of-type(2) button:nth-of-type(4)")
    @CacheLookup
    private WebElement xl;

    @WhenPageOpens
    public void waitUntilPageLoads() {
        element(pageLoadedText).waitUntilVisible();
    }

    private String regexMatchingDollarAmount = "\\$[0-9,\\.]*";
    private String regexMatchingDollarAmountWithSurroundingParentheses = "\\(\\$[0-9,\\.]*\\)";
    private String regexMatchingZeroDollarAmount = "$0.00";
    private String clubOMember_Active_ItemLessThan45_NFR_Message = String.format("You get Free Shipping\\* and %s in Rewards on this item.", regexMatchingDollarAmount);
    private String clubOMember_Active_ItemGreaterThan45_NFR_Message = String.format("You get %s in Rewards on this item.", regexMatchingDollarAmount);
    private String clubOMember_Active_ItemLessThan45_Q4FR_Message = String.format("You get Free Shipping and Free Returns\\*, plus %s in Rewards on this item.", regexMatchingDollarAmount);
    private String clubOMember_Active_ItemGreaterThan45_Q4FR_Message = String.format("You get Free Returns\\* and %s in Rewards on this item.", regexMatchingDollarAmount);

    public ProductPage productPage() {
        return new ProductPage();
    }

    private String getCluboCalloutlineone() {
        String cluboCalloutLineOneText = "";
        if (cluboCalloutLineOne.isVisible())
            cluboCalloutLineOneText = cluboCalloutLineOne.getText();
        return cluboCalloutLineOneText;
    }

    private String getCluboCalloutlineTwo() {
        String cluboCalloutLineTwoText = "";
        if (cluboCalloutLineTwo.isVisible())
            cluboCalloutLineTwoText = cluboCalloutLineTwo.getText();
        return cluboCalloutLineTwoText;
    }

    void verifyProductPagetCluboCheckBox() {
        //Verify Checkbox functionality
//        WebElement clubOCheckBox = driver.findElement(By.xpath(cluboCheckBox));
//        softAssertions.assertThat(new WebDriverWait(driver, 10).until(ExpectedConditions.elementSelectionStateToBe(clubOCheckBox, false))).as("Checkbox isn't selected:").isTrue();
//        clubOCheckBox.click();
//        softAssertions.assertThat(new WebDriverWait(driver, 10).until(ExpectedConditions.elementSelectionStateToBe(clubOCheckBox, true))).as("Checkbox is selected:").isTrue();

    }


    void getProductPageJson(Id<ProductId> proId) {

        try {
            JSONObject jsonObject = JsonReader.readJsonFromUrl("https://www.overstock.com/" + "/blah/blah/" + proId + "/product.html?json=t");

            System.out.println(jsonObject.toString(2));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Click on Add To Cart Button.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickAddToCartButton() {
        addToCart.click();
        return this;
    }

    /**
     * Click on Add To Registry Button.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickAddToRegistryButton() {
        addToRegistry.click();
        return this;
    }

    /**
     * Click on Eyeshadow Link.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickEyeshadowLink() {
        eyeshadow.click();
        return this;
    }

    /**
     * Click on Favorites Button.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickFavoritesButton() {
        favorites.click();
        return this;
    }

    /**
     * Click on L Button.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickLButton() {
        l.click();
        return this;
    }

    /**
     * Click on Learn More Link.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickLearnMore1Link() {
        learnMore1.click();
        return this;
    }

    /**
     * Click on Learn More Link.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickLearnMore2Link() {
        learnMore2.click();
        return this;
    }

    /**
     * Click on Learn More Button.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickLearnMore3Button() {
        learnMore3.click();
        return this;
    }

    /**
     * Click on Learn More About Club O Link.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickLearnMoreAboutClubOLink() {
        learnMoreAboutClubO.click();
        return this;
    }

    /**
     * Click on M Button.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickMButton() {
        m.click();
        return this;
    }

    /**
     * Click on Privacy Policy Link.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickPrivacyPolicyLink() {
        privacyPolicy.click();
        return this;
    }

    /**
     * Click on Review This Item Link.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickReviewThisItemLink() {
        reviewThisItem.click();
        return this;
    }

    /**
     * Click on S Button.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickSButton() {
        s.click();
        return this;
    }

    /**
     * Click on Start Free Trial Membership Link.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickStartFreeTrialMembershipLink() {
        startFreeTrialMembership.click();
        return this;
    }

    /**
     * Click on Submit Link.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickSubmitLink() {
        submit.click();
        return this;
    }

    /**
     * Click on Terms Conditions Apply Link.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickTermsConditionsApplyLink() {
        termsConditionsApply.click();
        return this;
    }

    /**
     * Click on Terms Conditions Link.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickTermsConditionsLink() {
        termsConditions.click();
        return this;
    }

    /**
     * Click on Update Button.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickUpdateButton() {
        update.click();
        return this;
    }

    /**
     * Click on Xl Button.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage clickXlButton() {
        xl.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage fill() {
        setSize4chooseSizemlxlpleaseSelectAnOptionDropDownListField();
        setGetFreeShippingAndFreeReturnsCheckboxField();
        setPleaseEnterAValidZipCodeTextField();
        setCaptchaAnswer1TextField();
        setCaptchaAnswer2TextField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Captcha Answer Text field.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage setCaptchaAnswer1TextField() {
        return setCaptchaAnswer1TextField(data.get("CAPTCHA_ANSWER_1"));
    }

    /**
     * Set value to Captcha Answer Text field.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage setCaptchaAnswer1TextField(String captchaAnswer1Value) {
        captchaAnswer1.sendKeys(captchaAnswer1Value);
        return this;
    }

    /**
     * Set default value to Captcha Answer Text field.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage setCaptchaAnswer2TextField() {
        return setCaptchaAnswer2TextField(data.get("CAPTCHA_ANSWER_2"));
    }

    /**
     * Set value to Captcha Answer Text field.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage setCaptchaAnswer2TextField(String captchaAnswer2Value) {
        captchaAnswer2.sendKeys(captchaAnswer2Value);
        return this;
    }

    /**
     * Set Get Free Shipping And Free Returns Plus Checkbox field.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage setGetFreeShippingAndFreeReturnsCheckboxField() {
        if (!getFreeShippingAndFreeReturns.isSelected()) {
            getFreeShippingAndFreeReturns.click();
        }
        return this;
    }

    /**
     * Set default value to Please Enter A Valid Zip Code Text field.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage setPleaseEnterAValidZipCodeTextField() {
        return setPleaseEnterAValidZipCodeTextField(data.get("PLEASE_ENTER_A_VALID_ZIP_CODE"));
    }

    /**
     * Set value to Please Enter A Valid Zip Code Text field.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage setPleaseEnterAValidZipCodeTextField(String pleaseEnterAValidZipCodeValue) {
        pleaseEnterAValidZipCode.sendKeys(pleaseEnterAValidZipCodeValue);
        return this;
    }

    /**
     * Set default value to Size 4choose Sizemlxlplease Select An Option Above Drop Down List field.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage setSize4chooseSizemlxlpleaseSelectAnOptionDropDownListField() {
        return setSize4chooseSizemlxlpleaseSelectAnOptionDropDownListField(data.get("SIZE_4CHOOSE_SIZEMLXLPLEASE_SELECT_AN_OPTION"));
    }

    /**
     * Set value to Size 4choose Sizemlxlplease Select An Option Above Drop Down List field.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage setSize4chooseSizemlxlpleaseSelectAnOptionDropDownListField(String size4chooseSizemlxlpleaseSelectAnOptionValue) {
        size4chooseSizemlxlpleaseSelectAnOption.selectByVisibleText(size4chooseSizemlxlpleaseSelectAnOptionValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage submit() {
        clickAddToCartButton();
        return this;
    }

    /**
     * Unset Get Free Shipping And Free Returns Plus Checkbox field.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage unsetGetFreeShippingAndFreeReturnsCheckboxField() {
        if (getFreeShippingAndFreeReturns.isSelected()) {
            getFreeShippingAndFreeReturns.click();
        }
        return this;
    }

    /**
     * Unset default value from Size 4choose Sizemlxlplease Select An Option Above Drop Down List field.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage unsetSize4chooseSizemlxlpleaseSelectAnOptionDropDownListField() {
        return unsetSize4chooseSizemlxlpleaseSelectAnOptionDropDownListField(data.get("SIZE_4CHOOSE_SIZEMLXLPLEASE_SELECT_AN_OPTION"));
    }

    /**
     * Unset value from Size 4choose Sizemlxlplease Select An Option Above Drop Down List field.
     *
     * @return the ProductPage class instance.
     */
    public ProductPage unsetSize4chooseSizemlxlpleaseSelectAnOptionDropDownListField(String size4chooseSizemlxlpleaseSelectAnOptionValue) {
        size4chooseSizemlxlpleaseSelectAnOption.deselectByVisibleText(size4chooseSizemlxlpleaseSelectAnOptionValue);
        return this;
    }

}
