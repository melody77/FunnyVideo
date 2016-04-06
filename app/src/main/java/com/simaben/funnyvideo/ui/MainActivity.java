package com.simaben.funnyvideo.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.simaben.funnyvideo.R;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.IconPageIndicator;
import com.viewpagerindicator.LinePageIndicator;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitlePageIndicator;
import com.viewpagerindicator.UnderlinePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    CollectionPagerAdapter pagerAdapter;
    static List<TitleTab> allFragments = new ArrayList<>();

    @Bind(R.id.indicator)
    UnderlinePageIndicator indicator;
    @Bind(R.id.pager)
    ViewPager viewPager;

    static {
        allFragments.clear();
        allFragments.add(new TitleTab(ItemFragment.newInstance(2), "糗百"));
        allFragments.add(new TitleTab(ItemFragment.newInstance(1), "直播"));
        allFragments.add(new TitleTab(ItemFragment.newInstance(1), "本地"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        pagerAdapter = new CollectionPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        indicator.setViewPager(viewPager);
        indicator.setFades(false);
        indicator.setOnPageChangeListener(this);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class CollectionPagerAdapter extends FragmentStatePagerAdapter {
        public CollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return allFragments.get(i).f;
        }

        @Override
        public int getCount() {
            return allFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return allFragments.get(position).title;
        }
    }

    static class TitleTab {
        Fragment f;
        String title;

        public TitleTab(Fragment f, String title) {
            this.f = f;
            this.title = title;
        }
    }

}
