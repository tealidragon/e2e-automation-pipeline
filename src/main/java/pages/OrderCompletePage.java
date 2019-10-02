package pages;

import com.overstock.arch.model.address.CoreContactAddress;
import com.overstock.webdev.test.page.ostk.OrderProcessedOrderItem;
import com.overstock.webdev.test.page.ostk.OrderProcessedPage;
import com.overstock.webdev.util.GenericsUtil;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.locators.WebElementFacadeListItemHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class OrderCompletePage extends PageObject {

    @FindBy(xpath = "/html/body/div[7]/div/div[2]/div/div/div[1]")
    WebElementFacade closeJoinOverstockPopup;

    @FindBy(xpath = "//*[@id=\"app\"]/main/section/div[6]/div/div[2]/div/section/div[1]")
    WebElementFacade closeJoinClubOPopup;

    @FindBy(xpath = "//*[@id=\"frame\"]/ul")
    WebElementFacade otherCustomersRecommendationsUnorderedList;

    @FindBy(xpath = "//*[@id=\"bottomRecs\"]/div/header/h2")
    WebElementFacade otherCustomersRecommendationsTitle;

    @FindBy(xpath = "//*[@id=\"app\"]/main/section/section[1]/section[1]/section[2]")
    WebElementFacade forgetSomethingRecommendationsUnorderedList;

    @FindBy(xpath = "//*[@id=\"app\"]/main/section/section[1]/section[1]/section[2]/div/h3")
    WebElementFacade forgetSomethingRecommendationsTitle;


    @FindBy(className = "invoice-id-link")
    private WebElement invoiceIdLink;

    @FindBy(css = "#customer-info .billing-info")
    private WebElement billingInfo;

    @FindBy(css = "#customer-info .shipping-info")
    private WebElement shippingInfo;

    @FindBy(id = "order-summary")
    private WebElement orderSummary;

    @FindBy(id = "orderTotalDisplayAmount")
    private WebElement orderTotalDisplayAmount;

    @FindBy(id = "shippingAmountDisplayAmount")
    private WebElement shippingDisplayAmount;

    @FindBy(className = "quantity")
    private WebElement quantity;

    @FindBy(className = "option-item")
    private WebElement optionItem;

    @FindBy(xpath = ".//div[@class='details']/div[@class='item-number']")
    private WebElement itemNumber;

    @FindBy(xpath = "//*[@id='customer-info']//*[contains(@class,'billing-info')]//span[last()]")
    private WebElement phoneNumber;

    @FindBy(xpath = "//div[@class='item']/div[@class='price']")
    private WebElement productSalePrice;

    @FindBy(id = "promotionalSavingsDisplayAmount")
    private WebElement promotionalSaveing;

    @FindBy(xpath = "//div[@class='item']/div[@class='price']")
    private WebElementFacadeListItemHandler productPrice;

    @FindBy(linkText = "My Account")
    private WebElement myAccount;

    @FindBy(xpath = "//*[@id='app']/main/section/section[1]/section[2]/section/div/button")
    private WebElement addToCartClubO;

    @FindBy(linkText = "Refer a Friend")
    private WebElement referAFriend;

    @FindBy(xpath = "//*[@id='app']/main/section/section[1]/section[2]/section/div/div/div[2]/div[1]/div[1]")
    private WebElement secondChanceText;

    @FindBy(className = "upgrade-benefits")
    private WebElement secondChanceRewards;

    @FindBy(className = "exit-clubo-popup")
    private WebElementFacade orderPopUp;

    @FindBy(className = "raf")
    private WebElement referAFriendText;

    @FindBy(xpath = ".//div[@id='registryWrapper']//a")
    private WebElement wishListName;

    @FindBy(xpath = ".//*[@id='registryWrapper']/span[2]")
    private WebElement wishListItem;

    @FindBy(className = "wl-address")
    private WebElement shippingInfoRegistry;

    @FindBy(id = "registryWrapper")
    private WebElement registryContainer;

    @FindBy(xpath = ".//input[@id='QAS_AcceptOriginal']")
    private WebElement qasSelectAddress;

    @FindBy(css = "#customer-info>div:nth-of-type(2)>div:nth-of-type(2)")
    private WebElement purchaserShippingAddress;

    @FindBy(id = "subtotalDisplayAmount")
    private WebElement subtotalDisplayAmount;

    @FindBy(id = "order-message")
    private WebElement messageOnOrderProcess;

    @FindBy(css = ".wl-name")
    private WebElement registryOwnerName;

    @FindBy(css = "#order-summary>#cart-container")
    private WebElement itemSummaryTable;

    @FindBy(css = "#app > main > section > section:nth-child(1) > section.col-xs-5.order-processed-desktop > section > div > div > div.innerMessage > div > div > span")
    private WebElement clubORewards;


    public OrderCompletePage orderCompletePage() {
        return new OrderCompletePage();
    }

//    public Id<InvoiceId> getInvoiceId() {
//        long invoiceLong = Long.parseLong(this.invoiceIdLink.getText().trim());
//        return new Id(invoiceLong);
//    }

    public String getCluboRewardsEarned() {
        clubORewards.isDisplayed();
        String result = this.clubORewards.getText();
        System.out.println("rewards: " + result);
        return result;
    }

    public String getSecondChanceText() {
        String result = this.secondChanceText.getText();
        System.out.println("secondChanceText: " + result);
        return result;
    }

    public String getSecondChanceRewards() {
        String result = this.secondChanceRewards.getText();
        System.out.println("secondChanceRewards: " + result);
        return result;
    }

    public String getReferAFriendText() {
        String result = this.referAFriendText.getText();
        System.out.println("referAFriendText: " + result);
        return result;
    }


    public void clickOnXConfirm() {
        orderPopUp.isVisible();
        this.orderPopUp.click();
    }

    public CartPage clickOnAddClubOToCart() {
        this.addToCartClubO.click();
        return new CartPage();
    }

    public CartPage clickOnReferAFriend() {
        this.referAFriend.click();
        return new CartPage();
    }

    public MyAccountPage clickOnMyAccount() {
        this.myAccount.click();
        return new MyAccountPage();
    }

    public String getSelectedDeliveryOptionForProductSku(long productSku) {
        List<WebElement> orderedItems = this.orderSummary.findElements(By.className("item"));
        Iterator var4 = orderedItems.iterator();

        WebElement currentItem;
        Long currentSku;
        do {
            if (!var4.hasNext()) {
                return "";
            }

            currentItem = (WebElement) var4.next();
            String foundSku = currentItem.findElement(By.className("item-number")).getText().replaceAll("[^\\d]", "");
            currentSku = Long.valueOf(foundSku);
        } while (currentSku != productSku);

        return currentItem.findElement(By.className("shipping")).getText();
    }

    public List<OrderProcessedOrderItem> getOrderItems() {
        List<OrderProcessedOrderItem> orderItemsList = new ArrayList();
        List<WebElement> rows = this.itemSummaryTable.findElements(By.className("item"));
        Iterator var3 = rows.iterator();

        while (var3.hasNext()) {
            WebElement row = (WebElement) var3.next();
            orderItemsList.add(new OrderProcessedOrderItem(row));
        }

        return orderItemsList;
    }

    public String getPhoneNumber() {
        return this.phoneNumber.getText();
    }

    public String getQuantity() {
        return this.quantity.getText();
    }

    public String getTotalPrice() {
        return this.orderTotalDisplayAmount.getText();
    }

    public String getShippingAmount() {
        return this.shippingDisplayAmount.getText();
    }

    public String getOptionItem() {
        return this.optionItem.getText();
    }

    public String getItemNumber() {
        return this.itemNumber.getText();
    }


    public CoreContactAddress getBillingAddress() {
        List<WebElement> span = this.billingInfo.findElements(By.tagName("span"));
        GenericsUtil.convertListFromAtoB(span, new GenericsUtil.ConversionInterface<WebElement, String>() {
            public String convertFromAtoB(WebElement originalObject) {
                return originalObject.getText();
            }
        });
        return CoreContactAddress.builder().build();
    }

    public String getProductSalePrice() {
        return this.productSalePrice.getText();
    }

    public String getPromotionalPrice() {
        return this.promotionalSaveing.getText();
    }

    public boolean isBillingPhoneDisplayed() {
        boolean isPhoneNmberPresent = false;

        try {
            if (this.phoneNumber.isDisplayed()) {
                isPhoneNmberPresent = true;
            }
        } catch (NoSuchElementException var3) {
            isPhoneNmberPresent = false;
        }

        return isPhoneNmberPresent;
    }

    public boolean isItemMarkedAsWishListItem() {
        return this.wishListItem.isDisplayed();
    }


    public WebElement getsubtotalDisplayAmount() {
        return this.subtotalDisplayAmount;
    }

    public String getSubTotalAmount() {
        String subTotalAmount = null;

        try {
            subTotalAmount = this.subtotalDisplayAmount.getText();
        } catch (Exception var3) {
            System.out.println("SubTotal amount not found");
        }

        return subTotalAmount;
    }

    public OrderProcessedPage clickSelectAddressButtonAndSubmitOrder() {
        qasSelectAddress.click();
        return new OrderProcessedPage();
    }

}

