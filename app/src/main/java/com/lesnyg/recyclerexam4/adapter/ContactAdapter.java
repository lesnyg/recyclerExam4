package com.lesnyg.recyclerexam4.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.lesnyg.recyclerexam4.R;
import com.lesnyg.recyclerexam4.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    //인터페이스=====================================================
    public interface MyOnClickListener{
        void MyOnClick(View view, Contact contact,int position);
    }
    private MyOnClickListener mListener;
    public void setMyOnClickListener(MyOnClickListener listener){
        mListener = listener;
    }
    //인터페이스=====================================================

    List<Contact> mList = new ArrayList<>();

    public void setItems(List<Contact> list){
        mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_contact,viewGroup,false);

        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    Contact contact = mList.get(viewHolder.getAdapterPosition());
                    mListener.MyOnClick(v,contact,viewHolder.getAdapterPosition());
                }
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Contact item = mList.get(i);
        viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
        viewHolder.nameText.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //viewHolder 레이아웃의 정보를 담는부분(이미지뷰,체크박스 텍스트뷰)
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView nameText;
        private CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameText = itemView.findViewById(R.id.textView);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
}
