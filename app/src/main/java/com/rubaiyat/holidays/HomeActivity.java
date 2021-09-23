package com.rubaiyat.holidays;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rubaiyat.holidays.controller.RecentsController;
import com.rubaiyat.holidays.controller.TopPlacesController;
import com.rubaiyat.holidays.model.RecentsData;
import com.rubaiyat.holidays.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    RecentsController recentsController;
    TopPlacesController topPlacesController;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("KUAKATA SEA BEACH", "BANGLADESH", "From $200", R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("SAINT MARTIN ISLAND", "BANGLADESH", "From $300", R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("Cox's Bazar Sea Beach", "BANGLADESH", "From $200", R.drawable.img1));
        recentsDataList.add(new RecentsData("Sajek Valley", "BANGLADESH", "From $300", R.drawable.img2));
        recentsDataList.add(new RecentsData("Lakkatura Tea Garden", "BANGLADESH", "From $200", R.drawable.img3));
        recentsDataList.add(new RecentsData("Shitakunda Hills & Trails", "BANGLADESH", "From $300", R.drawable.img4));

        setRecentRecycler(recentsDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Cox's Bazar Sea Beach", "Bangladesh", "$200 - $500", R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("SAINT MARTIN ISLAND", "Bangladesh", "$200 - $500", R.drawable.recentimage2));
        topPlacesDataList.add(new TopPlacesData("Sajek Valley", "Bangladesh", "$200 - $500", R.drawable.img2));
        topPlacesDataList.add(new TopPlacesData("Lakkatura Tea Garden", "Bangladesh", "$200 - $500", R.drawable.img3));
        topPlacesDataList.add(new TopPlacesData("Shitakunda Hills & Trails", "Bangladesh", "$200 - $500", R.drawable.img4));

        setTopPlacesRecycler(topPlacesDataList);
    }

    private void setRecentRecycler(List<RecentsData> recentsDataList) {

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsController = new RecentsController(this, recentsDataList);
        recentRecycler.setAdapter(recentsController);

    }

    private void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList) {

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesController = new TopPlacesController(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesController);


    }
    /*holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {context.startActivity(new Intent(context, DetailsActivity.class));
        }*/
}
