package com.smaka.sqlightdatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowResult extends AppCompatActivity {
    TextView tvDisplay;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_result);

        tvDisplay=findViewById(R.id.tvDisplay);
        dbHelper=new DatabaseHelper(ShowResult.this);

        Cursor cursor=dbHelper.getAllData();
        tvDisplay.setText("Total Data"+cursor.getCount()); //getCount দেওয়াতে database এ কতটা data আছে দেখা যাবে



        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);//0 no coloum data
            String name = cursor.getString(1);//1 no coloum data
            String mobile = cursor.getString(2);//2 no coloum data
            tvDisplay.append(" \nID " + id + " Name: " + name + " Mobile: " + mobile);

//চাইলে while কে if else এর ভিতর ডুকাতে পারি if(cursor!=null && cursor.getCount()>0){  }else{ tvDisplay.setText("No Data Found"); }


        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
