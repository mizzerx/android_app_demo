package com.android.minimalmanagement;

import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OverviewActivity extends AppCompatActivity {
    ImageView imgSetting;
    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String, List<String>> listItem;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        imgSetting = findViewById(R.id.img_Setting);
        expandableListView = findViewById(R.id.expandable_ListRoom);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(this, listGroup, listItem);
        expandableListView.setAdapter(adapter);

        imgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverviewActivity.this, SettingScreen.class);
                startActivity(intent);
            }
        });

        initListData();


    }

    private void initListData() {
        listGroup.add(getString(R.string.group));

        String[] arr;

        List<String> list = new ArrayList<>();
        arr = getResources().getStringArray(R.array.group);
        for (String item : arr) {
            list.add(item);
        }

        listItem.put(listGroup.get(0), list);
        adapter.notifyDataSetChanged();
    }
}
