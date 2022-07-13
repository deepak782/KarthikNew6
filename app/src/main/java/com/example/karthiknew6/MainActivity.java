package com.example.karthiknew6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickFun {

    RecyclerView recyclerView_h;
    CountryModel countryModel;
    CountryAdapter countryAdapter;
    List<CountryModel> countryModelList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_h=findViewById(R.id.h_recycler);

        recyclerView_h.setHasFixedSize(true);
        //vertical
       //recyclerView_h.setLayoutManager(new LinearLayoutManager(this));
        //horizontal
        recyclerView_h.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //type3
        countryAdapter=new CountryAdapter(this,countryModelList,this);
        recyclerView_h.setAdapter(countryAdapter);

        loadData();

    }

    private void loadData() {

        countryModel=new CountryModel(R.mipmap.ic_launcher,"INDIA");
        countryModelList.add(countryModel);
        countryModel=new CountryModel(R.mipmap.ic_launcher,"CHINA");
        countryModelList.add(countryModel);
        countryModel=new CountryModel(R.mipmap.ic_launcher,"SRI LANKA");
        countryModelList.add(countryModel);
        countryModel=new CountryModel(R.mipmap.ic_launcher,"PAKISTAN");
        countryModelList.add(countryModel);


        countryAdapter.notifyDataSetChanged();

    }

    //type3

    @Override
    public void onItemClick(int i) {

    }




}