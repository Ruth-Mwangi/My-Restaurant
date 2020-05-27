package com.ruth.myrestaurant.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class MyRestaurantsArrayAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mRestaurants;
    private String[] mCuisines;
    public MyRestaurantsArrayAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    public MyRestaurantsArrayAdapter(Context mContext, int resource, String[] mRestaurants, String[] mCuisines) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRestaurants = mRestaurants;
        this.mCuisines = mCuisines;
    }


    @Override
    public Object getItem(int position) {
        String restaurant = mRestaurants[position];
        String cuisine = mCuisines[position];
        return String.format("%s \nServes great : %s",restaurant,cuisine);
    }

    @Override
    public int getCount() {
        return mRestaurants.length;
    }
}
