package data;

import com.overstock.arch.automation.WebDriverProvider;
import com.overstock.clubo.common.builders.CustDto;
import com.overstock.clubo.common.enums.ClubType;
import com.overstock.clubo.common.enums.MemberStatus;
import com.overstock.clubo.common.enums.OptInStatus;
import com.overstock.datatypes.Money;
import com.overstock.framework.Bordello;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CustomerGenerator {

    //Aka: Guest (never been to our site before, that we know of based off their information, which is not Logged In)

    public List<CustDto> activeMembers() {
        List<CustDto> activeCustomerIdsList = new ArrayList<>();

        ClubType.activeClubTypesStream().forEach(clubType -> activeCustomerIdsList.add(new com.overstock.clubo.common.builders.CustBuilder()
                .setNewClubO(clubType)
                .withCloActualStartPlusOrMinusDays(-2)
                .withOptInStatus(OptInStatus.N)
                .buildDto()
        ));
        return activeCustomerIdsList;
    }

    public List<CustDto> expiredMembers() {
        List<CustDto> expiredClubOCustomers = new ArrayList<>();
        ClubType.activeClubTypesStream().forEach(clubType -> expiredClubOCustomers.add(new com.overstock.clubo.common.builders.CustBuilder()
                .setNewClubO(clubType)
                .withOptInStatus(OptInStatus.N)
                .withCloActualEndPlusOrMinusDays(-2)
                .withMemberStatus(MemberStatus.EXPIRED)
                .buildDto()
        ));

        return expiredClubOCustomers;
    }

    public List<CustDto> expiringMembers() {
        List<CustDto> expiringClubOCustomers = new ArrayList<>();

        ClubType.activeClubTypesStream().forEach(clubType -> expiringClubOCustomers.add(new com.overstock.clubo.common.builders.CustBuilder()
                .setNewClubO(clubType)
                .withOptInStatus(OptInStatus.N)
                .withCloActualEndPlusOrMinusDays(7)
                .buildDto()
        ));
        return expiringClubOCustomers;
    }
    public List<CustDto> activeMembersWithRewards() {
        List<CustDto> activeCustomerIdsList = new ArrayList<>();

        ClubType.activeClubTypesStream().forEach(clubType -> activeCustomerIdsList.add(new com.overstock.clubo.common.builders.CustBuilder()
                .setNewClubO(clubType)
                .withInsertedEarnedRewards(new Money(10000))
                .withCloActualStartPlusOrMinusDays(-2)
                .withOptInStatus(OptInStatus.N)
                .buildDto()
        ));
        return activeCustomerIdsList;
    }

    public List<CustDto> expiredMembersWithRewards() {
        List<CustDto> expiredClubOCustomers = new ArrayList<>();

        ClubType.activeClubTypesStream().forEach(clubType -> expiredClubOCustomers.add(new com.overstock.clubo.common.builders.CustBuilder()
                .setNewClubO(clubType)
                .withInsertedEarnedRewards(new Money(10000))
                .withOptInStatus(OptInStatus.N)
                .withCloActualEndPlusOrMinusDays(-2)
                .withMemberStatus(MemberStatus.EXPIRED)
                .buildDto()
        ));
        return expiredClubOCustomers;
    }

    public List<CustDto> expiringMembersWithRewards() {
        List<CustDto> expiringClubOCustomers = new ArrayList<>();

        ClubType.activeClubTypesStream().forEach(clubType -> expiringClubOCustomers.add(new com.overstock.clubo.common.builders.CustBuilder()
                .setNewClubO(clubType)
                .withInsertedEarnedRewards(new Money(10000))
                .withOptInStatus(OptInStatus.N)
                .withCloActualEndPlusOrMinusDays(7)
                .buildDto()
        ));
        return expiringClubOCustomers;
    }

}
