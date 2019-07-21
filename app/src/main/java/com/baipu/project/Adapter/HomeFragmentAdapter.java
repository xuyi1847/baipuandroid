package com.baipu.project.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class HomeFragmentAdapter  extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragment_list;
    private ArrayList<String> tab_title_list;
    public HomeFragmentAdapter(FragmentManager fm, ArrayList<String> tab_title_list,ArrayList<Fragment> fragment_list) {
        super(fm);
        this.fragment_list = fragment_list;
        this.tab_title_list = tab_title_list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragment_list.get(position);
    }

    @Override
    public int getCount() {
        return fragment_list.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tab_title_list.get(position);
    }
}
