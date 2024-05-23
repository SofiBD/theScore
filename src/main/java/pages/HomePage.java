package pages;

import enums.PlayerSubTabs;
import enums.TeamSubTabs;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import utils.Constants;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass {

    private By scoreImage = AppiumBy.className("android.widget.ImageView");
    //  private By getStartedButton = By.id("com.fivemobile.thescore:id/btn_primary");
    private By titleText = By.id("com.fivemobile.thescore:id/title_onboarding");
    private By profileImage = AppiumBy.className("android.widget.ImageButton");
    private By teamText = By.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/label' and @text='TOR']");
    private By LeagueText = By.xpath("//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/label' and @text='NHL']");
    private By popupDismissIcon = By.id("com.fivemobile.thescore:id/dismiss_modal");
    private By searchBar = AppiumBy.className("android.widget.AutoCompleteTextView");
    private By playerHeaderTitle = By.id("com.fivemobile.thescore:id/txt_player_name");
    private By subPlayerTabs = By.xpath("//android.widget.HorizontalScrollView[contains(@resource-id,'tabLayout')]//android.widget.LinearLayout//android.widget.TextView");
    private By teamHeaderTitle = By.id("com.fivemobile.thescore:id/team_name");
    private By backButton = AppiumBy.accessibilityId("Navigate up");


    public boolean userIsOnStartScreen() throws Exception {
        Thread.sleep(5000);
        return isElementPresent(scoreImage);
    }

    public void clickButton(String button) {
        click(By.xpath("(//android.widget.TextView[@text='" + button + "'])"));
    }

    public void clickAllowNotifications(String button) {
        click(By.xpath("(//android.widget.Button[@text='" + button + "'])"));
    }

    public String getTitle() {
        return getText(titleText);
    }

    public void selectLeagueAndTeam(String name) {
        click(By.xpath("//android.widget.TextView[contains(@text,'" + name + "')]//following-sibling::android.widget.ImageView"));
    }

    public void clickOnProfileView(String icon) {
        click(AppiumBy.accessibilityId("" + icon + ""));
    }

    public boolean userIsOnDashboardPage() {
        return isElementPresent(profileImage);
    }

    public String getTeamText() {
        return getText(teamText);
    }

    public String getLeagueText() {
        return getText(LeagueText);
    }

    public void handlePopup() {
        if (isElementPresent(popupDismissIcon)) {
            click(popupDismissIcon);
        }
    }

    public void userAtDashboardPage() throws Exception {
        userIsOnStartScreen();
        clickButton("Get Started");
        selectLeagueAndTeam("NHL");
        clickButton("Continue");
        clickButton("Maybe Later");
        selectLeagueAndTeam("Tor");
        clickButton("Continue");
        clickButton("Continue");
        clickButton("Maybe Later");
        clickAllowNotifications("Allow");
        handlePopup();
        userIsOnDashboardPage();
    }

    public void userSelectsFromSearchBar(String selection) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(By.id("com.fivemobile.thescore:id/search_bar_text_view"));
        sendKeys(searchBar, selection);
        click(By.xpath("//android.widget.TextView[contains(@text,'" + selection + "')]"));
    }

    public void verifyHeaderTitle(String header) {
        if (header.contains(Constants.playerName)) {
            getText(playerHeaderTitle);
        } else if (header.contains(Constants.teamName)) {
            getText(teamHeaderTitle);
        }

    }

    public boolean comparePlayerSubTabs(String selection) {
        PlayerSubTabs array[] = PlayerSubTabs.values();
        TeamSubTabs array1[] = TeamSubTabs.values();
        ArrayList<String> enumList = new ArrayList<String>();
        ArrayList<String> subTabs = new ArrayList<String>();
        if (selection.contains(Constants.playerName)) {
            for (int i = 0; i < array.length; i++) {
                enumList.add(array[i].getSubTab());
            }

        } else if (selection.contains(Constants.teamName)) {
            for (int i = 0; i < array1.length; i++) {
                enumList.add(array1[i].getSubTab());
            }
        }
        subTabs = getSubTabs(subPlayerTabs);
        System.out.println("Enum list: " + enumList);
        System.out.println("Arraylist is: " + subTabs);
        return enumList.equals(subTabs);
    }

    public void clickSubTab(String tab) {
        click(By.xpath("//android.widget.TextView[contains(@text,'" + tab + "')]"));
    }

    public boolean validateBackButton() {
        return isElementPresent(backButton);
    }

    public boolean validateUserAtSearchBarPage() {
        return isElementPresent(searchBar);
    }

}
