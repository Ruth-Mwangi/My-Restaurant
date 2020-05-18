package com.ruth.myrestaurant;

import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;


@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup(){
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent(){
        TextView appNameTextView = activity.findViewById(R.id.appNameTextView);
        Assert.assertTrue("MyRestaurants".equals(appNameTextView.getText().toString()));
    }
}
