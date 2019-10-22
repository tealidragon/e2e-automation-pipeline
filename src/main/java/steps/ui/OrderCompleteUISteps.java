package steps.ui;

import com.overstock.clubo.common.enums.ClubType;
import pages.ClubOHubPage;
import pages.OrderCompletePage;

public class OrderCompleteUISteps {
    public OrderCompletePage orderCompletePage;

    public OrderCompletePage customerMessage(ClubType clubtype, String message) {
        orderCompletePage.getCluboRewardsEarned();
        return new OrderCompletePage();
    }

}