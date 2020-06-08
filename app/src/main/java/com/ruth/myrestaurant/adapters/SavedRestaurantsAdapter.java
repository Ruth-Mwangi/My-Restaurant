package com.ruth.myrestaurant.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruth.myrestaurant.R;
import com.ruth.myrestaurant.models.Business;
import com.ruth.myrestaurant.util.ItemTouchHelperAdapter;
import com.ruth.myrestaurant.util.OnStartDragListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SavedRestaurantsAdapter extends RecyclerView.Adapter<SavedRestaurantsAdapter.SavedRestaurantViewHolder> implements ItemTouchHelperAdapter {
    private ArrayList<Business> mRestaurants;
    private Context mContext;
    private OnStartDragListener mOnStartDragListener;

    public SavedRestaurantsAdapter(Context mContext,ArrayList<Business> mRestaurants) {
        this.mRestaurants = mRestaurants;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SavedRestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_item_drag, parent, false);
        SavedRestaurantsAdapter.SavedRestaurantViewHolder viewHolder = new SavedRestaurantsAdapter.SavedRestaurantViewHolder(view);

        return viewHolder;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull SavedRestaurantViewHolder holder, int position) {

        holder.mRestaurantImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_UP) {
                    mOnStartDragListener.onStartDrag(holder);
                }
                return false;
            }
        });
        holder.bindRestaurant(mRestaurants.get(position));

    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {

    }

    public class SavedRestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.restaurantImageView)
        public ImageView mRestaurantImageView;
        @BindView(R.id.restaurantNameTextView)
        TextView mNameTextView;
        @BindView(R.id.categoryTextView)
        TextView mCategoryTextView;
        @BindView(R.id.ratingTextView)
        TextView mRatingTextView;
        private Context mContext;
        public SavedRestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindRestaurant(Business restaurant) {
            Picasso.get().load(restaurant.getImageUrl()).into(mRestaurantImageView);
            mNameTextView.setText(restaurant.getName());
            mCategoryTextView.setText(restaurant.getCategories().get(0).getTitle());
            mRatingTextView.setText("Rating: " + restaurant.getRating() + "/5");
        }

        @Override
        public void onClick(View v) {

        }
    }
}
