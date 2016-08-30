package com.naveen.effervescence.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager;
import com.hanks.htextview.HTextView;
import com.naveen.effervescence.R;
import com.naveen.effervescence.Utils.EventInfo;
import com.naveen.effervescence.Utils.EventList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterclever on 30/8/16.
 */
public class HorizontalPagerAdapter extends PagerAdapter{

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private final ArrayList[] EVENTS_BY_CATEGORIES = new ArrayList[]{
            EventList.onlineEventList,
            EventList.quizEventList,
            EventList.onlineEventList,
            EventList.onlineEventList,
            EventList.quizEventList
    };

    public HorizontalPagerAdapter(final Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return EVENTS_BY_CATEGORIES.length;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view = mLayoutInflater.inflate(R.layout.two_way_layout,container,false);

        final VerticalInfiniteCycleViewPager verticalInfiniteCycleViewPager =
                (VerticalInfiniteCycleViewPager) view.findViewById(R.id.vicvp);
        verticalInfiniteCycleViewPager.setAdapter(
                new VerticalPagerAdapter(mContext, EVENTS_BY_CATEGORIES[position])
        );
        TextView textView = (TextView) view.findViewById(R.id.event_category_textview);
        switch (position){
            case 0: textView.setText("Online"); break;
            case 1: textView.setText("Quiz"); break;
            case 2: textView.setText("Online"); break;
            case 3: textView.setText("Online"); break;
            case 4: textView.setText("Quiz"); break;
        }
        container.addView(view);
        return view;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }
}
