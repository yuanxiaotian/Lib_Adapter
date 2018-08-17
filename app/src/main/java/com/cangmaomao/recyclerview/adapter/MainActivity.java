package com.cangmaomao.recyclerview.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        TestAdater adater = new TestAdater(R.layout.item_activity_main);


        recyclerView.setAdapter(adater);


        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adater.addData("存" + i);
        }

        View view =    LayoutInflater.from(this).inflate(R.layout.item_activity_main_head, recyclerView, false);

        adater.addHeadView(view);

    }
}
