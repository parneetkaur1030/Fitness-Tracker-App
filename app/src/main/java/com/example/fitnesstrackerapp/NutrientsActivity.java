package com.example.fitnesstrackerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NutrientsActivity extends AppCompatActivity {


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrients);

        String[] str = getResources().getStringArray(R.array.nutrients);
        final String[] strDetails = getResources().getStringArray(R.array.nutrients_details);

        listView = findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.row,R.id.textView,str);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = strDetails[position];
                Intent intent = new Intent(NutrientsActivity.this,NutrientsDetailsActivity.class);
                intent.putExtra("details",t);
                startActivity(intent);
            }
        });

    }

    public void nutrientsGoBack(View view) {
        Intent intent = new Intent(NutrientsActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NutrientsActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
