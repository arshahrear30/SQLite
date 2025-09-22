package com.smaka.sqlightdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edName, edMobile;
    Button buttonInsert, buttonshow;
    DatabaseHelper dbhelper; //1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edName=findViewById(R.id.edName);
        edMobile=findViewById(R.id.edMobile);
        buttonInsert=findViewById(R.id.buttonInsert);
        buttonshow=findViewById(R.id.buttonshow);

        dbhelper=new DatabaseHelper(MainActivity.this); //2

        buttonInsert.setOnClickListener(new View.OnClickListener() { //3
            @Override
            public void onClick(View v) {
                //insert data to sqllite database
                //dbhelper.insertData(Name:"name",Mobile:"mobile");//এই কাজটা get এর মাধ্যমে করবো এখন ত
                dbhelper.insertData(edName.getText().toString(),edMobile.getText().toString()); //4
                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();

            }
        });


        buttonshow.setOnClickListener(new View.OnClickListener() { //5 আগে নতুন Activity টা খুলে নেই
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ShowResult.class));

            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
