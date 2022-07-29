package com.example.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderingapp.Adapters.MainAdapter;
import com.example.foodorderingapp.Models.MainModel;
import com.example.foodorderingapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.dosa,"Paper Dosa","5","Super soft and crispy Paper Dosa with authentic taste"));
        list.add(new MainModel(R.drawable.chicken,"Chicken","15","Crispy and delicious Chicken at a minimal price"));
        list.add(new MainModel(R.drawable.chickenplatter,"Chicken Platter","20","Wholesome and mouthwatering Chicken Platter as a meal"));
        list.add(new MainModel(R.drawable.chickensandwitch,"Chicken Sandwitch","10","Sandwitch stuffed with chicken is a real treat to tongue"));
        list.add(new MainModel(R.drawable.chowmin,"Chowmin","5","Soft and delicious Chowmin with perfect combination of sausages"));
        list.add(new MainModel(R.drawable.manchurian,"Manchurian","10","Manchurian with authentic taste and mouthwatering flavours"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}