package com.live.haiwang.livegiftsample.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.live.haiwang.livegiftsample.R;

/**
 * Created by haiwang on 2017/7/9.
 */

public class GiftPagerLayout extends FrameLayout{

    private LayoutInflater mInflater;
    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;
    private String[] titles = {"热门" , "奢华" , "比赛"};

    public GiftPagerLayout(Context context) {
        super(context);
    }

    public GiftPagerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    {
        mInflater = LayoutInflater.from(getContext());
        mInflater.inflate(R.layout.gift_pager_layout, this);
        mPagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.gift_tabs);
        mViewPager = (ViewPager) findViewById(R.id.gift_tabs_port_pager);
        mViewPager.setAdapter(new TabAdapter());
        mPagerSlidingTabStrip.setViewPager(mViewPager);
    }

    private class TabAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            GiftViewPager viewPager = new GiftViewPager(getContext());
            container.addView(viewPager);
            return viewPager;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}
