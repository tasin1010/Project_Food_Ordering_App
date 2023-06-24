package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    //backend after 1
    ActivityDetailBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type", 0) == 1) {


            //backend
            final int image = getIntent().getIntExtra("image", 0); //aikhane parameter name gula same as ja amra MainAdapter.java te use korsi
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", price));
            binding.nameBox.setText(name);
            binding.detailDescription.setText(description);

//        DBHelper helper = new DBHelper(this);

            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );

                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Data Success.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error.", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }//ending of if
        else {
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
            binding.detailImage.setImageResource(cursor.getInt(3));
            binding.priceLbl.setText(String.format("%d", cursor.getInt(3)));
            binding.nameBox.setText(cursor.getString(6));
            binding.detailDescription.setText(cursor.getString(5));
        }

    }





}