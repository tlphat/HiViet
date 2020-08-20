package com.hfad.hiviet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ListPlace extends AppCompatActivity {

    private GridView gridViewPlaces;
    private GridViewAdapter adapter;
    private List<Attraction> displayList;

    private AdapterView.OnItemClickListener gridViewOnItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(ListPlace.this, PlaceItemActivity.class);
            intent.putExtra("index", displayList.get(i).getId());
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_place);
        loadList();
        setupGridView();
        //TODO: ADD CATEGORY FEATURE
    }

    private void loadList() {
        displayList = AttractionList.builder().getList();
    }

    private void setupGridView() {
        gridViewPlaces = findViewById(R.id.gridViewPlace);
        adapter = new GridViewAdapter(this, R.layout.attraction_thumbnail, displayList);
        gridViewPlaces.setAdapter(adapter);
        gridViewPlaces.setOnItemClickListener(gridViewOnItemClick);
    }
}