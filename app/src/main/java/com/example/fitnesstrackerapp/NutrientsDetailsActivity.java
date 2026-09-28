package com.example.fitnesstrackerapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NutrientsDetailsActivity extends AppCompatActivity {


    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrients_details);

        textView = findViewById(R.id.txt);
        String strDetails = getIntent().getStringExtra("details");
        textView.setText(strDetails);



    }

    public void goBack(View view) {
        Intent intent = new Intent(NutrientsDetailsActivity.this,NutrientsActivity.class);
        startActivity(intent);
        finish();
    }
    public void onBackPressed() {
        Intent intent = new Intent(NutrientsDetailsActivity.this,NutrientsActivity.class);
        startActivity(intent);
        finish();
    }
}