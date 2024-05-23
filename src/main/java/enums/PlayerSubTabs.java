package enums;

public enum PlayerSubTabs {
        SUB_TAB1("NEWS"),
        SUB_TAB2("SEASON"),
        SUB_TAB3("GAME LOG"),
        SUB_TAB4("INFO");

        private String subTabs;
        private PlayerSubTabs(String subTabs){
                this.subTabs= subTabs;
        }

        public String getSubTab(){
                return subTabs;
        }
}
