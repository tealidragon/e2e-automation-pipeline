package steps.ui;

import org.openqa.selenium.WebElement;
import pages.ProductPage;

public class ProductPageUISteps {
    public ProductPage productPage;

    public ProductPage customerMessage() {
        productPage.open();
        productPage.getProductPage();
        return new ProductPage();
    }

    public WebElement getClubOPerksMessage() {
        productPage.open();
        productPage.getProductPage();

        return productPage.freeShippingFreeReturnsrenew;
    }

    public WebElement getClubOProductOffer() {
        productPage.open();
        productPage.getProductPage();

        return productPage.cluboproductoffer;
    }

    public ProductPage clubOProductCallout() {
        productPage.open();
        productPage.getProductPage();
        productPage.waitUntilPageLoads();
        String cluboProductOffered = productPage.cluboproductoffer.getText();
        System.out.println("Club O product offered: " + cluboProductOffered);
        return new ProductPage();
    }

}