package com.softwarearch.shoppingapplication.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class IntroSliderAdapter extends PagerAdapter {
    private LayoutInflater layoutInflater;
    private Context mContext;
    private int[] dots;

    public IntroSliderAdapter(Context mContext, int[] dots) {
        this.mContext = mContext;
        this.dots = dots;
    }

    @Override
    public int getCount() {
        return dots.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(dots[position], container, false);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == object;


    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
