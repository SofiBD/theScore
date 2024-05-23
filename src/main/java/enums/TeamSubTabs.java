package enums;

public enum TeamSubTabs {
    SUB_TAB1("NEWS"),
    SUB_TAB2("CHAT"),
    SUB_TAB3("TEAM STATS"),
    SUB_TAB4("SCHEDULE"),
    SUB_TAB5("PLAYER STATS");

    private String subTabs;
    private TeamSubTabs(String subTabs){
        this.subTabs= subTabs;
    }

    public String getSubTab() {
        return subTabs;
    }

}
