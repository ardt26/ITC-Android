package com.example.playstore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PlaystoreAdapter extends RecyclerView.Adapter<PlaystoreAdapter.ViewHolder> {
    private ArrayList<Playstore> playStore;
    private Context context;

    public PlaystoreAdapter(ArrayList<Playstore> playStore, Context context) {
        this.playStore = playStore;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_app, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Playstore playstore = playStore.get(position);
        Glide.with(holder.itemView.getContext())
                .load(playstore.getsPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.ivPhoto);
        holder.tvName.setText(playstore.getsName());
        holder.tvDetail.setText(playstore.getsDetail());

        holder.cvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name", playstore.getsName());
                intent.putExtra("detail", playstore.getsDetail());
                intent.putExtra("photo", playstore.getsPhoto());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return playStore.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDetail;
        ImageView ivPhoto;
        CardView cvCardView;
        LinearLayout llLinearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvDetail = itemView.findViewById(R.id.tv_detail);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
            cvCardView = itemView.findViewById(R.id.cv_cardview);
            llLinearLayout = itemView.findViewById(R.id.ll_linear);
        }
    }
}
