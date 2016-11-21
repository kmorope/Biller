package com.biller.appe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ingenian on 21/11/2016.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {
    private List<Category> categoryList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, date,value;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            date = (TextView) view.findViewById(R.id.date);
            value = (TextView) view.findViewById(R.id.value);
            image = (ImageView) view.findViewById(R.id.imageLogo);
        }
    }

    public CategoriesAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cat_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Category movie = categoryList.get(position);
        holder.title.setText(movie.getTitle());
        holder.date.setText(movie.getDate());
        if(movie.getValue() != null){
            holder.value.setText(movie.getValue());
        }
        else{
            holder.value.setText("$0");
        }

        if(movie.getImage() != null){
            holder.image.setImageDrawable(movie.getImage());
        }

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}

