package com.ruth.myrestaurant.ui;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.Query;
import com.ruth.myrestaurant.R;
import com.ruth.myrestaurant.adapters.SavedRestaurantsAdapter;

import butterknife.BindView;

public class SavedRestaurantListActivity extends AppCompatActivity  {
    private Query mRestaurantReference;
    //private FirebaseRecyclerAdapter<Restaurant, FirebaseRestaurantViewHolder> mFirebaseAdapter;
    private SavedRestaurantsAdapter mAdapter;
    private ItemTouchHelper mItemTouchHelper;
    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;



    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private ChildEventListener mChildEventListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
//        ButterKnife.bind(this);
//
//        //mRestaurantReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RESTAURANTS);
//
//
//        final ArrayList<Business> restaurants = new ArrayList<>();
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//        mRestaurantReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RESTAURANTS).child(uid).orderByChild(Constants.FIREBASE_QUERY_INDEX);
//        mRestaurantReference.addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    restaurants.add(snapshot.getValue(Business.class));
//                }
//                mAdapter=new SavedRestaurantsAdapter(SavedRestaurantListActivity.this,restaurants);
//                mRecyclerView.setAdapter(mAdapter);
//                RecyclerView.LayoutManager layoutManager =
//                        new LinearLayoutManager(SavedRestaurantListActivity.this);
//                mRecyclerView.setLayoutManager(layoutManager);
//                mRecyclerView.setHasFixedSize(true);
//                ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
//                mItemTouchHelper = new ItemTouchHelper(callback);
//                mItemTouchHelper.attachToRecyclerView(mRecyclerView);
//                showRestaurants();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//        mChildEventListener=mRestaurantReference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
////                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
////                    restaurants.add(snapshot.getValue(Business.class));
////                }
//                restaurants.add(dataSnapshot.getValue(Business.class));
//                mAdapter=new SavedRestaurantsAdapter(SavedRestaurantListActivity.this,restaurants);
//                mRecyclerView.setAdapter(mAdapter);
//                RecyclerView.LayoutManager layoutManager =
//                        new LinearLayoutManager(SavedRestaurantListActivity.this);
//                mRecyclerView.setLayoutManager(layoutManager);
//                mRecyclerView.setHasFixedSize(true);
//                ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
//                mItemTouchHelper = new ItemTouchHelper(callback);
//                mItemTouchHelper.attachToRecyclerView(mRecyclerView);
//                showRestaurants();
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

    }

//    private void showRestaurants() {
//
//        mRecyclerView.setVisibility(View.VISIBLE);
//        mProgressBar.setVisibility(View.GONE);
//    }
//
//
//    @Override
//    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
//        mItemTouchHelper.startDrag(viewHolder);
//
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//       }
}