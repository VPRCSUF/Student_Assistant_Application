package com.example.studentassistantapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
//<<<<<<< HEAD
import android.widget.ArrayAdapter;
//=======
import android.view.View;
//>>>>>>> e5f0673fd5f54a8a2915cd426ee97c81a100404f
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ClassInfo extends AppCompatActivity {

    ClassDatabaseHelper myDb;
    TextView className, start, end, prof, unit, days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_info);
        myDb = new ClassDatabaseHelper(this);

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

    }

    //---------------------------------------------WORK IN PROGRESS BELOW THIS LINE--------------------------------------

    public void displayCourse(String course)
    {
        Cursor cursor = myDb.viewData();
        String comp;

        if(cursor.getCount() == 0)
        {
            Toast.makeText(this, "No data to show", Toast.LENGTH_LONG).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                comp = cursor.getString(0);
                if(comp.equals(course))
                {
                    prof.setText(cursor.getString(1));
                    unit.setText(cursor.getString(2));
                    start.setText(cursor.getString(3));
                    end.setText(cursor.getString(4));
                    days.setText(cursor.getString(5));

                }
            }
        }
    }

    public void goToEditClass(View v)
    {
        Intent i = new Intent(this, EditCourse.class);

        i.putExtra("courseName", className.getText().toString());

        startActivity(i);
    }

    public void deleteClass(View v)
    {
        int tracker;

        tracker = myDb.deleteData(className.getText().toString());

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}