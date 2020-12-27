package com.techmarinar.cashattest;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.techmarinar.cashattest.resource.TabList;
import com.techmarinar.cashattest.tabitemdata.TabItems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    //widget
    private TabLayout tabs;
    private ViewPager2 viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding widgets
        tabs=(TabLayout) findViewById(R.id.mtablayout);
        viewPager=(ViewPager2) findViewById(R.id.mviewPager);

        //set up tab items
        setUpTabsItems(tabs);

        //get the fragment manager
        FragmentManager fm = getSupportFragmentManager();

        //tabs items adapter
        TabsPagerAdapter tabsAdapter=new TabsPagerAdapter(fm, MainActivity.this,getLifecycle());

        //set Up tabs(fragment) adapter With View Pager
        viewPager.setAdapter(tabsAdapter);

        //set a Listener when Tab item is Selected
        setUpOnTabItemSelected(tabs , viewPager);

        //Change Tab when swiping
        setUpSwipingMode(tabs , viewPager);

    }



    //Connecting TabLayout to Adapter
    private void setUpOnTabItemSelected(TabLayout tabs, ViewPager2 viewPager) {

        //on tab item selected => adding the listener
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Connecting TabLayout to Adapter
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                Toast.makeText(MainActivity.this, "tab un selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

//                Toast.makeText(MainActivity.this, "tab re selected", Toast.LENGTH_SHORT).show();

            }
        });

    }


    //Change Tab when swiping
    private void setUpSwipingMode(TabLayout tabs, ViewPager2 viewPager) {
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //finding the tab at the positions
                tabs.selectTab(tabs.getTabAt(position));
            }
        });
    }

    //set up tab list item names and icon
    private void setUpTabsItems(TabLayout tabs) {

        //list of tab items object.
        ArrayList<TabItems> mTabItems=TabList.getItemsArrayList();

        /** get tabs name <to String> ***/
        //getting items from the TabItem class
        String chat=mTabItems.get(0).getTabName();
        String market=mTabItems.get(1).getTabName();
        String services=mTabItems.get(2).getTabName();
        String calc=mTabItems.get(3).getTabName();

        //adding tab Items names
        tabs.addTab(tabs.newTab().setText(chat));
        tabs.addTab(tabs.newTab().setText(market));
        tabs.addTab(tabs.newTab().setText(services));
        tabs.addTab(tabs.newTab().setText(calc));

        //set icon to each tab items
        tabs.getTabAt(0).setIcon(R.drawable.ic_baseline_message_24);
        tabs.getTabAt(1).setIcon(R.drawable.ic_baseline_shop_24);
        tabs.getTabAt(2).setIcon(R.drawable.ic_baseline_loyalty_24);
        tabs.getTabAt(3).setIcon(R.drawable.ic_baseline_insert_chart_24);

        //set up background color


    }
}