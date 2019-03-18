package com.lesnyg.recyclerexam4.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lesnyg.recyclerexam4.R;
import com.lesnyg.recyclerexam4.models.CardItem;

import java.util.List;

public class Main3Adapter extends RecyclerView.Adapter<Main3Adapter.ViewHolder> {
    private List<CardItem> mList;
    public Main3Adapter(List<CardItem> list) {
        mList=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_basic,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        CardItem item = mList.get(i);
        viewHolder.imageView.setImageResource(item.getImage());
        viewHolder.title.setText(item.getTitle());
        viewHolder.contents.setText(String.valueOf(item.getRatingscore()));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView contents;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_poster);
            title = itemView.findViewById(R.id.title_text);
            contents = itemView.findViewById(R.id.contents_text);
        }
    }
}
