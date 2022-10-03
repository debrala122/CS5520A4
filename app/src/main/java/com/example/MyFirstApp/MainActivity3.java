package com.example.MyFirstApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity3 extends AppCompatActivity {
    EditText name_input, url_input;
    Button add_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        name_input = findViewById(R.id.editTextTextPersonName);
        url_input = findViewById(R.id.editTextTextPersonName2);
        add_button = findViewById(R.id.addBut);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity3.this);
                myDB.addUrl(name_input.getText().toString().trim(), url_input.getText().toString().trim());
            }
        });
    }

}