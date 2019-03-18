package com.lesnyg.recyclerexam4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.lesnyg.recyclerexam4.adapter.Main3Adapter;
import com.lesnyg.recyclerexam4.models.CardItem;
import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        List<CardItem> list = new ArrayList<>();
        list.add(new CardItem(R.drawable.marble, "캡틴마블", "4.5"));
        list.add(new CardItem(R.drawable.don, "돈", "3.5"));
        list.add(new CardItem(R.drawable.hero, "우상", "별3.0"));
        list.add(new CardItem(R.drawable.escape, "이스케이프 룸", "별3.0"));
        list.add(new CardItem(R.drawable.image11, "군도", "별3.5"));
        list.add(new CardItem(R.drawable.marble, "캡틴마블", "별4.0"));
        list.add(new CardItem(R.drawable.don, "돈", "별3.5"));
        list.add(new CardItem(R.drawable.hero, "우상", "별3.0"));
        list.add(new CardItem(R.drawable.escape, "이스케이프 룸", "별3.0"));
        list.add(new CardItem(R.drawable.image11, "군도", "별3.5"));
        list.add(new CardItem(R.drawable.marble, "캡틴마블", "별4.0"));
        list.add(new CardItem(R.drawable.don, "돈", "별3.5"));
        list.add(new CardItem(R.drawable.hero, "우상", "별3.0"));
        list.add(new CardItem(R.drawable.escape, "이스케이프 룸", "별3.0"));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        Main3Adapter adapter = new Main3Adapter(list);
        recyclerView.setAdapter(adapter);

    }
}
