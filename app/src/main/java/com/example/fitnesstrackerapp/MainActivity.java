package com.example.fitnesstrackerapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button button1, button2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UnderAgeActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OverAgeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.id_privacy){

//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//            startActivity(intent);
            return true;
        }
        if(id==R.id.id_term){
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//            startActivity(intent);
            return true;
        }
        if(id==R.id.rate){

//            try{
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
//
//            }catch (Exception e){
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
//            }

            return true;
        }
        if(id==R.id.more){
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
//            startActivity(intent);
            return true;
        }
        if(id==R.id.share){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String shareStr= "This is the best yoga app for You \n By this app you can exercise daily and be fit \n This is Free Download now \n" + "https://play.google.com/store/apps/details?id=in.idealcoder.yogademoapp&hl=en";
            String shareBody = "Yoga App";
            intent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
            intent.putExtra(Intent.EXTRA_TEXT, shareStr);
            startActivity(Intent.createChooser(intent, "share using"));
            return true;
        }
        if(id==R.id.logout){
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear(); // Clear all saved data
            editor.apply();

            Toast.makeText(getApplicationContext(), "Logged out successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish(); // Close MainActivity
            return true;
        }

        return true;
    }

    public void under18(View view) {
        Intent intent = new Intent(this, UnderAgeActivity.class);
        startActivity(intent);
    }

    public void over18(View view) {
        Intent intent = new Intent(this, OverAgeActivity.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent = new Intent(this,NutrientsActivity.class);
        startActivity(intent);
    }
}