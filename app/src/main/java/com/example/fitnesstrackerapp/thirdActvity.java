package com.example.fitnesstrackerapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class thirdActvity extends AppCompatActivity {

    String buttonValue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftInMills;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_actvity);

        Intent intent = getIntent();
        buttonValue = intent.getStringExtra("value");

        int intValue = Integer.parseInt(buttonValue);
        switch(intValue){
            case 1:
                setContentView(R.layout.activity_bow);
                break;
            case 2:
                setContentView(R.layout.activity_bridge);
                break;
            case 3:
                setContentView(R.layout.activity_chair);
                break;
            case 4:
                setContentView(R.layout.activity_child);
                break;
            case 5:
                setContentView(R.layout.activity_cobbler);
                break;
            case 6:
                setContentView(R.layout.activity_cow);
                break;
            case 7:
                setContentView(R.layout.activity_playji);
                break;
            case 8:
                setContentView(R.layout.activity_pauseji);
                break;
            case 9:
                setContentView(R.layout.activity_plank);
                break;
            case 10:
                setContentView(R.layout.activity_crunches);
                break;
            case 11:
                setContentView(R.layout.activity_situp);
                break;
            case 12:
                setContentView(R.layout.activity_rotation);
                break;
            case 13:
                setContentView(R.layout.activity_twist);
                break;
            case 14:
                setContentView(R.layout.activity_windmill);
                break;
            case 15:
                setContentView(R.layout.activity_legup);
                break;
        }

        startBtn = findViewById(R.id.startBtn);
        mtextview = findViewById(R.id.time);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MTimeRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });

    }

    private  void pauseTimer(){
        countDownTimer.cancel();
        MTimeRunning = false;
        startBtn.setText("Start");
    }
    private void startTimer() {
        String timerText = mtextview.getText().toString(); // Get the timer text
        String[] timeParts = timerText.split(":"); // Split into minutes and seconds
        int minutes = Integer.parseInt(timeParts[0]);
        int seconds = Integer.parseInt(timeParts[1]);

        int totalSeconds = minutes * 60 + seconds; // Calculate total seconds
        MTimeLeftInMills = totalSeconds * 1000; // Convert to milliseconds

        countDownTimer = new CountDownTimer(MTimeLeftInMills, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                MTimeLeftInMills = millisUntilFinished; // Update time left
                updateTimer(); // Update the UI
            }

            @Override
            public void onFinish() {
                // Handle transition to the next activity
                int newValue = Integer.parseInt(buttonValue) + 1;
                if (newValue <= 7) {
                    Intent intent = new Intent(thirdActvity.this, thirdActvity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newValue));
                    startActivity(intent);
                } else {
                    newValue = 1;
                    Intent intent = new Intent(thirdActvity.this, thirdActvity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newValue));
                    startActivity(intent);
                }
            }
        }.start();

        startBtn.setText("Pause");
        MTimeRunning = true;
    }

    private void updateTimer(){
        int minutes = (int) MTimeLeftInMills/60000;
        int seconds = (int) MTimeLeftInMills%60000/1000;
        String timeLeftText ="";
        if(minutes<10){
            timeLeftText+="0";
        }
        timeLeftText+=minutes+":";
        if(seconds<10){
            timeLeftText+="0";
        }
        timeLeftText+=seconds;
        mtextview.setText(timeLeftText);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}