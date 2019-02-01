package com.futurepastapps.notificationapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by HP on 24-01-2019.
 */

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slideimages =  {

            R.drawable.add,
            R.drawable.check,
            R.drawable.add

    };

    public String[] descriptions = {

            "asdf",
            "sdfdfdf",
            "sdfdf"
    };
    @Override
    public int getCount() {
        return slideimages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout , container , false);

        ImageView imageview = view.findViewById(R.id.descriptionImage);
        TextView textView = view.findViewById(R.id.descriptionText);

        imageview.setImageResource(slideimages[position]);
        textView.setText(descriptions[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }

    //slide
}
