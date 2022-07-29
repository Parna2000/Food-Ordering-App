package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodorderingapp.Adapters.OrdersAdapter;
import com.example.foodorderingapp.Models.OrdersModel;
import com.example.foodorderingapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {


    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DbHelper helper = new DbHelper(this);
        ArrayList<OrdersModel>list = helper.getOrders();
//        list.add(new OrdersModel(R.drawable.dosa,"Paper dosa", "5", "112233"));



        OrdersAdapter adapter = new OrdersAdapter(list, this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}