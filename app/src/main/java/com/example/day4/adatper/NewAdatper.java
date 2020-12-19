package com.example.day4.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day4.R;
import com.example.day4.bean.NewBean;

import java.util.ArrayList;

import retrofit2.http.GET;

public class NewAdatper extends RecyclerView.Adapter<NewAdatper.ViewHolder> {

    private Context context;
    private ArrayList<NewBean.NewsBean> list;


    public NewAdatper(Context context, ArrayList<NewBean.NewsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_rel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewBean.NewsBean newsBean = list.get(position);
        holder.rewTile.setText(newsBean.getTile());
        holder.newContent.setText(newsBean.getContent());
        Glide.with(context).load(newsBean.getImageUrl()).into(holder.newImageUrl);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView newImageUrl;
        private TextView rewTile;
        private TextView newContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newImageUrl = itemView.findViewById(R.id.new_imageUrl);
            rewTile = itemView.findViewById(R.id.rew_tile);
            newContent = itemView.findViewById(R.id.new_content);
        }
    }
}
