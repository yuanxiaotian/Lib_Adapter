package com.cangmaomao.recyclerview.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("存" + i);
        }


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        TestAdater adater = new TestAdater(R.layout.item_activity_main, list);


        recyclerView.setAdapter(adater);


        View view = View.inflate(this, R.layout.item_activity_main_foot, null);

        adater.addHeadView(view);

        adater.addFootView(view);
    }
}
