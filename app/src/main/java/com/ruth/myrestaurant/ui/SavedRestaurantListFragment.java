package com.ruth.myrestaurant.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.ruth.myrestaurant.Constants;
import com.ruth.myrestaurant.R;
import com.ruth.myrestaurant.adapters.SavedRestaurantsAdapter;
import com.ruth.myrestaurant.models.Business;
import com.ruth.myrestaurant.util.OnStartDragListener;
import com.ruth.myrestaurant.util.SimpleItemTouchHelperCallback;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SavedRestaurantListFragment extends Fragment implements OnStartDragListener {
    private Query mRestaurantReference;
    //private FirebaseRecyclerAdapter<Restaurant, FirebaseRestaurantViewHolder> mFirebaseAdapter;
    private SavedRestaurantsAdapter mAdapter;
    private ItemTouchHelper mItemTouchHelper;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;



    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private ChildEventListener mChildEventListener;


    public SavedRestaurantListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_restaurant_list, container, false);
        ButterKnife.bind(this, view);
        setUpFirebaseAdapter();
        return view;
    }

    private void setUpFirebaseAdapter() {
        final ArrayList<Business> restaurants = new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        mRestaurantReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RESTAURANTS).child(uid).orderByChild(Constants.FIREBASE_QUERY_INDEX);
        mRestaurantReference.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    restaurants.add(snapshot.getValue(Business.class));
                }
                mAdapter=new SavedRestaurantsAdapter(getContext(),restaurants);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                    @Override
                    public void onItemRangeInserted(int positionStart, int itemCount) {
                        super.onItemRangeInserted(positionStart, itemCount);
                        mAdapter.notifyDataSetChanged();
                    }
                });
                RecyclerView.LayoutManager layoutManager =
                        new LinearLayoutManager(getContext());
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);
                ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
                mItemTouchHelper = new ItemTouchHelper(callback);
                mItemTouchHelper.attachToRecyclerView(mRecyclerView);
                showRestaurants();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void showRestaurants() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
    @Override
    //method is now public
    public void onDestroy() {
        super.onDestroy();
//        mAdapter.cleanup();

    }


}
