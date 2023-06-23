package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger , "Burger", "350", "Chiken Burger with Extra Cheese and a Coke"));
        list.add(new MainModel(R.drawable.pizza , "Pizza", "800", "The offer to download the coupons ends tomorrow"));
        list.add(new MainModel(R.drawable.por , "French Fries", "450", "Deshi french fries premium"));
        list.add(new MainModel(R.drawable.boc , "Burger ComboPack", "500", "2 pcs of burger with fired chicken and fries"));
        list.add(new MainModel(R.drawable.burger , "Burger", "350", "Chiken Burger with Extra Cheese and a Coke"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recylerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylerview.setLayoutManager(layoutManager);
    }
}