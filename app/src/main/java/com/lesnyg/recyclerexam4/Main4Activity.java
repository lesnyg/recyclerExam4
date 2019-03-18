package com.lesnyg.recyclerexam4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lesnyg.recyclerexam4.R;
import com.lesnyg.recyclerexam4.adapter.ContactAdapter;
import com.lesnyg.recyclerexam4.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity implements ContactAdapter.MyOnClickListener {

    private ContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        List<Contact> datalist = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datalist.add(new Contact("아무개"+(i+1)+"호"));
        }

        //Adapter
        mAdapter = new ContactAdapter();

        //View
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(mAdapter);

        //나중에 데이터 갱신하는 방법
        mAdapter.setItems(datalist);
        mAdapter.notifyDataSetChanged();

        mAdapter.setMyOnClickListener(this);
    }

    @Override
    public void MyOnClick(View view, Contact contact, int position) {
        Toast.makeText(this, position+" : "+contact, Toast.LENGTH_SHORT).show();
    }
}
