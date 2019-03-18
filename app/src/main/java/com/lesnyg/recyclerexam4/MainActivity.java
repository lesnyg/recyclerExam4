package com.lesnyg.recyclerexam4;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lesnyg.recyclerexam4.MainActivity.MyAdapter.MyOnClickListener;
import com.lesnyg.recyclerexam4.models.Practice;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Practice> mDataList;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataList = new ArrayList<>();
        mDataList.add(new Practice("다섯번째 연습", Main2Activity.class));
        mDataList.add(new Practice("여섯번째 연습", Main3Activity.class));
        mDataList.add(new Practice("일곱번째 연습", Main4Activity.class));
        mDataList.add(new Practice("프레그먼트 연습", ExamFragmantActivity.class));


        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setItems(mDataList);
        mAdapter.notifyDataSetChanged();

        mAdapter.setMyOnClickListener(new MyOnClickListener() {
            @Override
            public void onSelected(Practice practice) {
                Class cls = practice.getCls();
                Intent intent = new Intent(MainActivity.this, cls);
                startActivity(intent);
            }
        });
    }


    public static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        public interface MyOnClickListener {
            void onSelected(Practice practice);
        }

        private MyOnClickListener mListener;

        public void setMyOnClickListener(MyOnClickListener listener) {
            mListener = listener;
        }


        List<Practice> mList = new ArrayList<>();


        public void setItems(List<Practice> items) {
            mList = items;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_main, viewGroup, false);

            final ViewHolder viewHolder = new ViewHolder(view);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        Practice practice = mList.get(viewHolder.getAdapterPosition());
                        mListener.onSelected(practice);
                    }
                }
            });

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyAdapter.ViewHolder viewHolder, int i) {
            final Practice practice = mList.get(i);
            viewHolder.title.setText(practice.getList());


        }


        @Override
        public int getItemCount() {
            return mList.size();
        }

//        private void addItem(List<Practice> items) {
//            mDataList.addAll(items);
//        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView title;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.list_text);


            }
        }
    }
}
