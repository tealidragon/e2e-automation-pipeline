package steps.ui;

import com.overstock.clubo.common.enums.ClubType;
import pages.ClubOHubPage;
import pages.MyAccountPage;

public class MyAccountUISteps {
    public MyAccountPage myAccountPage;

    public MyAccountPage customerMessage(ClubType clubtype, String message) {
        myAccountPage.profile_header.isDisplayed();
        return new MyAccountPage();
    }

}