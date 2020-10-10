package com.example.marketstask.ui.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketstask.R;
import com.example.marketstask.data.remote.models.PublicRepository;
import com.example.marketstask.databinding.RowLayoutBinding;
import com.example.marketstask.ui.HomeActivity;
import com.example.marketstask.ui.ui.dashboard.HomeDetailsFragment;

public class HomeListAdapter extends PagedListAdapter<PublicRepository, HomeListAdapter.MyViewHolder> {

    Activity activity;

    protected HomeListAdapter(Activity activity) {
        super(PublicRepository.DIFF_CALLBACK);
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RowLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_layout, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.binding.setModel(getItem(position));
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        RowLayoutBinding binding;

        MyViewHolder(RowLayoutBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
            binding.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle =  new Bundle();
                    bundle.putParcelable("REPO", binding.getModel());
                    HomeDetailsFragment fragment = new HomeDetailsFragment();
                    fragment.setArguments(bundle);
                    ((HomeActivity) HomeListAdapter.this.activity).pushFragment(new HomeDetailsFragment(), bundle, HomeDetailsFragment.TAG, true);
                }
            });
        }

    }

}
