package com.techmarinar.cashattest.resource;

import com.techmarinar.cashattest.R;
import com.techmarinar.cashattest.tabitemdata.TabItems;

import java.util.ArrayList;

public class TabList {
    private static ArrayList<TabItems> itemsArrayList= new ArrayList<TabItems>(){
        {
            add(new TabItems("msg", R.drawable.ic_baseline_message_24));
            add(new TabItems("market",R.drawable.ic_baseline_shop_24));
            add(new TabItems("service",R.drawable.ic_baseline_loyalty_24));
            add(new TabItems("profile",R.drawable.ic_baseline_insert_chart_24));
        }
    };

    public static ArrayList<TabItems> getItemsArrayList() {
        return itemsArrayList;
    }
}
