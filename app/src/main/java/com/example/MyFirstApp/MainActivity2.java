package com.example.MyFirstApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);

        Button butA = findViewById(R.id.button2);
        Button butB = findViewById(R.id.button3);
        Button butC = findViewById(R.id.button4);
        Button butD = findViewById(R.id.button5);
        Button butE = findViewById(R.id.button6);
        Button butF = findViewById(R.id.button7);

        butA.setOnClickListener(this);
        butB.setOnClickListener(this);
        butC.setOnClickListener(this);
        butD.setOnClickListener(this);
        butE.setOnClickListener(this);
        butF.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button2:
                textView.setText(R.string.butA);
                break;
            case R.id.button3:
                textView.setText(R.string.butB);
                break;
            case R.id.button4:
                textView.setText(R.string.butC);
                break;
            case R.id.button5:
                textView.setText(R.string.butD);
                break;
            case R.id.button6:
                textView.setText(R.string.butE);
                break;
            case R.id.button7:
                textView.setText(R.string.butF);
                break;
        }
    }
}