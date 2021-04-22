package com.example.studentassistantapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ClassInfo extends AppCompatActivity {

    ClassDatabaseHelper myDb;
    TextView className, start, end, prof, unit, days;
   // ArrayList<String> info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_info);
        myDb = new ClassDatabaseHelper(this);
       // ArrayList<String> info = new ArrayList<String>();

        className = (TextView)findViewById(R.id.textViewClassTitle);
        prof = findViewById(R.id.professorName);
        unit = findViewById(R.id.units);
        start = findViewById(R.id.textViewStartTime);
        end = findViewById(R.id.textViewEndTime);
        days = findViewById(R.id.textViewDays);

        Bundle recdData = getIntent().getExtras();

        String Tempholder = recdData.getString("courseName");

        className.setText(Tempholder);

           displayCourse(Tempholder);

        //info = myDb.getClassInfo(className.toString());

        //Toast.makeText(this, info.size(), Toast.LENGTH_LONG).show();


       // prof.setText(info.get(0));
       // unit.setText(info.get(1));
        //start.setText(info.get(2));
        //end.setText(info.get(3));
        //days.setText(info.get(4));

    }

    //---------------------------------------------WORK IN PROGRESS BELOW THIS LINE--------------------------------------

    public void displayCourse(String course)
    {
        Cursor cursor = myDb.viewData();
       // ArrayList<String> info = new ArrayList<String>();
       // String[] info = {"1","2","3","4","5"};

        if(cursor.getCount() == 0)
        {
            Toast.makeText(this, "No data to show", Toast.LENGTH_LONG).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                if(cursor.getString(0) == course)
                {
                    //String[] info = {cursor.getString(1), cursor.getString(2), cursor.getString(3),  cursor.getString(4), cursor.getString(5) };
                /*    info[0] = cursor.getString(1);
                    info[1] = cursor.getString(2);
                    info[2] = cursor.getString(3);
                    info[3] = cursor.getString(4);
                    info[4] = cursor.getString(5);*/
                   // Toast.makeText(this, info.size(), Toast.LENGTH_LONG).show();


                           prof.setText(cursor.getString(1));
                         unit.setText(cursor.getString(2));
                     start.setText(cursor.getString(3));
                     end.setText(cursor.getString(4));
                      days.setText(cursor.getString(5));

                }
            }
        }
      // Toast.makeText(this, info.size(), Toast.LENGTH_LONG).show();
  /*      prof.setText(info[0]);
        unit.setText(info[1]);
        start.setText(info[2]);
        end.setText(info[3]);
        days.setText(info[4]); */
    }
}