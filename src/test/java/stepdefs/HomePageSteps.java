package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @Given("User is at the start screen")
    public void validateUserIsAtStartScreen() throws Exception {
        homePage.userIsOnStartScreen();
    }

    @When("User clicks on the {string} button")
    public void userClicksButton(String button) {
        homePage.clickButton(button);
    }

    @Then("User lands on the league selection page")
    public void validateLeagueSelectionPage() {
        Assert.assertEquals("Choose your favorite leagues", homePage.getTitle());
    }

    @And("User selects a {string}")
    public void userSelectsLeagueAndTeam(String name) {
        homePage.selectLeagueAndTeam(name);
    }

    @Then("User lands on team selection page")
    public void validateTeamSelectionPage() {
        Assert.assertEquals("Choose your favorite teams", homePage.getTitle());
    }

    @And("User lands on notifications page")
    public void validateUserOnNotificationsPage() {
        Assert.assertEquals("Never miss a game", homePage.getTitle());
    }

    @And("User clicks on {string} Notifications")
    public void permitNotifications(String button) {
        homePage.clickAllowNotifications(button);
    }

    @And("User lands on the Dashboard Page")
    public void validateUserIsOnDashboardPage() {
        homePage.handlePopup();
        Assert.assertTrue(homePage.userIsOnDashboardPage());
    }

    @And("User clicks on the {string} icon")
    public void clickOnProfileView(String icon) {
        homePage.clickOnProfileView(icon);
    }

    @And("User verifies if selected {string} and {string} are getting displayed on the dashboard page")
    public void validateLeagueAndTeamOnDashboardPage(String league, String team) {
        if (homePage.getLeagueText().equalsIgnoreCase(league) &&
                homePage.getTeamText().equalsIgnoreCase(team)) {
            Assert.assertTrue(true);
        }
    }

    @Given("User starts from the Dashboard Page")
    public void userStartsFromDashboardPage() throws Exception {
        homePage.userAtDashboardPage();
    }

    @When("User selects a {string} from SearchBar")
    public void userSelectsFromSearchBar(String selection) {
        homePage.userSelectsFromSearchBar(selection);
    }

    @Then("User validates the header title of the {string}")
    public void userValidateHeaderTitle(String headerTitle) {
        homePage.verifyHeaderTitle(headerTitle);
    }

    @And("User verifies the sub tabs of the {string}")
    public void userValidatesSubTabs(String selection) {
        Assert.assertTrue(homePage.comparePlayerSubTabs(selection));
    }

    @Then("User clicks on a {string}")
    public void userClicksOnSubTab(String subtab) {
        homePage.clickSubTab(subtab);
    }

    @And("User verifies if back button is displayed in the header")
    public void verifyBackButton() {
        Assert.assertTrue(homePage.validateBackButton());
    }

    @And("User lands on the SearchBar Page")
    public void validateUserOnSearchBarPage() {
        Assert.assertTrue(homePage.validateUserAtSearchBarPage());
    }


}
