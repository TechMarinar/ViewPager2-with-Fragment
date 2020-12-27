package com.techmarinar.cashattest.tabitemdata;

public class TabItems {
    private String tabName;
    private  int tabIcon;


    public TabItems(String tabName , int icon) {
        this.tabName = tabName;
        tabIcon=icon;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public int getTabIcon() {
        return tabIcon;
    }

    public void setTabIcon(int tabIcon) {
        this.tabIcon = tabIcon;
    }
}
