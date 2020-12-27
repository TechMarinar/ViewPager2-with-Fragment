package com.techmarinar.cashattest;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.techmarinar.cashattest.resource.TabList;
import com.techmarinar.cashattest.tabitemdata.TabItems;

import java.util.ArrayList;

public class TabsPagerAdapter extends FragmentStateAdapter  {
    //an ArrayList
    private ArrayList<TabItems>itemsArrayList= TabList.getItemsArrayList();
    private Context mContext;

    public TabsPagerAdapter(FragmentManager fragment, Context context, Lifecycle lifecycle){
        super(fragment,lifecycle);
        mContext=context;
    }

    @Override
    public Fragment createFragment(int position) {

        /***
         *
         * return fragment according to the position
         *
        ***/

        switch (position){
            case 0:
                return MessagesFragment.newInstance(position+1);

            default:
            return MarketFragment.newInstance(position+1);
        }
    }

    @Override
    public int getItemCount() {
        return itemsArrayList.size();
    }


}
