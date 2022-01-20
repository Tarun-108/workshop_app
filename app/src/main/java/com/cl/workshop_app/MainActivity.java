package com.cl.workshop_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView timeText,timeDisplay;
    Button goButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText = findViewById(R.id.editTextTime);
        goButton = findViewById(R.id.button);
        timeDisplay = findViewById(R.id.textViewTimeDisplay);



        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = 0;
                time = Integer.parseInt(timeText.getText().toString());

                if(time==0) {
                    Toast.makeText(MainActivity.this, "Enter time", Toast.LENGTH_SHORT).show();
                }else{
                    String min = String.valueOf(time/60);
                    String sec = String.valueOf(time%60);

                    String display = min+" : "+sec;

                    timeDisplay.setText(display);

                }

            }
        });






    }
}