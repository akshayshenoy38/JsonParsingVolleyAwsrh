package com.example.akshay.jsonparsingvolleyawsrh.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.akshay.jsonparsingvolleyawsrh.activities.AnimeActivity;
import com.example.akshay.jsonparsingvolleyawsrh.models.Anime;
import com.example.akshay.jsonparsingvolleyawsrh.R;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Anime> mData;
    RequestOptions options;

    public MyRecyclerViewAdapter(Context mContext, List<Anime> mData) {
        this.mContext = mContext;
        this.mData = mData;

        options = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvRating;
        TextView tvStudio;
        TextView tvCategory;
        ImageView ivThumbnail;
        LinearLayout llContainer;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvRowName);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            tvStudio = (TextView) itemView.findViewById(R.id.tvStudio);
            tvCategory = (TextView) itemView.findViewById(R.id.tvCategorie);
            ivThumbnail = (ImageView) itemView.findViewById(R.id.ivThumbnail);
            llContainer = (LinearLayout) itemView.findViewById(R.id.llContainer);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_item_row,parent,false);

        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.llContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, AnimeActivity.class);
                i.putExtra("anime_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("anime_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("anime_studio",mData.get(viewHolder.getAdapterPosition()).getStudio());
                i.putExtra("anime_category",mData.get(viewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("anime_nb_episode",mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("anime_rating",mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("anime_img",mData.get(viewHolder.getAdapterPosition()).getImage_url());

                mContext.startActivity(i);
            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(mData.get(position).getName());
        holder.tvRating.setText(mData.get(position).getRating());
        holder.tvStudio.setText(mData.get(position).getStudio());
        holder.tvCategory.setText(mData.get(position).getCategorie());

        // load image from the internet using Glide
        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(options).into(holder.ivThumbnail);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


}
