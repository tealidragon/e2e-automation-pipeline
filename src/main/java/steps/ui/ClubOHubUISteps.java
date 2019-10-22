package steps.ui;

import com.overstock.clubo.common.enums.ClubType;
import net.thucydides.core.annotations.Step;
import pages.ClubOHubPage;

public class ClubOHubUISteps {
    public ClubOHubPage clubOHubPage;

    public ClubOHubPage customerMessage(ClubType clubtype, String message) {
        clubOHubPage.hub();
        return new ClubOHubPage();
    }

}