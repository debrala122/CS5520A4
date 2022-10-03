package com.example.MyFirstApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListOfUsers extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> user_name,user_url;
    CustomerAdapter customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_users);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        add_button = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListOfUsers.this,MainActivity3.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(ListOfUsers.this);
        user_name = new ArrayList<>();
        user_url = new ArrayList<>();

        storeDataInArray();
        customerAdapter = new CustomerAdapter(ListOfUsers.this,user_name,user_url);
        recyclerView.setAdapter(customerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListOfUsers.this));
    }

    void storeDataInArray(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No entry yet", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                user_name.add(cursor.getString(0));
                user_url.add(cursor.getString(1));
            }
        }
    }
}