package com.ruth.myrestaurant.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ruth.myrestaurant.R;
import com.ruth.myrestaurant.adapters.RestaurantListAdapter;
import com.ruth.myrestaurant.models.Business;

import java.util.List;

import butterknife.BindView;

//import okhttp3.Callback;


public class RestaurantListActivity extends AppCompatActivity {

    private static final String TAG = RestaurantListActivity.class.getSimpleName();

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    private SharedPreferences mSharedPreferences;
    private String mRecentAddress;
    private SharedPreferences.Editor mEditor;

    private RestaurantListAdapter mAdapter;

    public List<Business> restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
//        ButterKnife.bind(this);
//
//        Intent intent = getIntent();
//        String location = intent.getStringExtra("location");
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
////        Log.d("Shared Pref Location", mRecentAddress);
//
//        YelpApi client = YelpClient.getClient();
//        //YelpService client = new YelpService();
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
//        if (mRecentAddress != null) {
//            //getRestaurants(mRecentAddress);
//
//        }
//
//        Call<YelpBusinessesSearchResponse> call = client.getRestaurants(location, "restaurants");
//
//        call.enqueue(new Callback<YelpBusinessesSearchResponse>() {
//
//
//
//            @Override
//            public void onResponse(Call<YelpBusinessesSearchResponse> call, Response<YelpBusinessesSearchResponse> response) {
//                hideProgressBar();
//
//                if (response.isSuccessful()) {
//                    restaurants = response.body().getBusinesses();
//                    mAdapter = new RestaurantListAdapter(RestaurantListActivity.this, restaurants);
//                    mRecyclerView.setAdapter(mAdapter);
//                    RecyclerView.LayoutManager layoutManager =
//                            new LinearLayoutManager(RestaurantListActivity.this);
//                    mRecyclerView.setLayoutManager(layoutManager);
//                    mRecyclerView.setHasFixedSize(true);
//
//                    showRestaurants();
//                } else {
//                    showUnsuccessfulMessage();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<YelpBusinessesSearchResponse> call, Throwable t) {
//                hideProgressBar();
//                showFailureMessage();
//            }
//
//        });


    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_search, menu);
//        ButterKnife.bind(this);
//
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();
//
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                addToSharedPreferences(query);
//                YelpApi client = YelpClient.getClient();
//                Call<YelpBusinessesSearchResponse> call = client.getRestaurants(query, "restaurants");
//
//                call.enqueue(new Callback<YelpBusinessesSearchResponse>() {
//
//
//
//                    @Override
//                    public void onResponse(Call<YelpBusinessesSearchResponse> call, Response<YelpBusinessesSearchResponse> response) {
//                        hideProgressBar();
//
//                        if (response.isSuccessful()) {
//                            restaurants = response.body().getBusinesses();
//                            mAdapter = new RestaurantListAdapter(RestaurantListActivity.this, restaurants);
//                            mRecyclerView.setAdapter(mAdapter);
//                            RecyclerView.LayoutManager layoutManager =
//                                    new LinearLayoutManager(RestaurantListActivity.this);
//                            mRecyclerView.setLayoutManager(layoutManager);
//                            mRecyclerView.setHasFixedSize(true);
//
//                            showRestaurants();
//                        } else {
//                            showUnsuccessfulMessage();
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<YelpBusinessesSearchResponse> call, Throwable t) {
//                        hideProgressBar();
//                        showFailureMessage();
//                    }
//
//                });
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//
//        });
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }
//    private void addToSharedPreferences(String location) {
//        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
//    }
//
//    private void showFailureMessage() {
//        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void showUnsuccessfulMessage() {
//        mErrorTextView.setText("Something went wrong. Please try again later");
//        mErrorTextView.setVisibility(View.VISIBLE);
//    }
//
//    private void showRestaurants() {
//        mRecyclerView.setVisibility(View.VISIBLE);
//    }
//
//    private void hideProgressBar() {
//        mProgressBar.setVisibility(View.GONE);
//    }
}
