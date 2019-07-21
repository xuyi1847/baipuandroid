package com.baipu.project.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragment_list;
    public MainFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragment_list) {
        super(fm);
        this.fragment_list = fragment_list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragment_list.get(position);
    }

    @Override
    public int getCount() {
        return fragment_list.size();
    }
}
