package com.example.studentassistantapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EditCourse extends AppCompatActivity {


    ClassDatabaseHelper myDb;
    TextView className, start, end, prof, unit, days;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_course);

        myDb = new ClassDatabaseHelper(this);

        className = (TextView)findViewById(R.id.class_name);
        prof = findViewById(R.id.professor);
        unit = findViewById(R.id.unit);
        start = findViewById(R.id.start_time);
        end = findViewById(R.id.end_time);
        days = findViewById(R.id.days);

        Bundle recdData = getIntent().getExtras();

        String Tempholder = recdData.getString("courseName");

        className.setText(Tempholder);

        displayCourse(Tempholder);
    }


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

    public void goToClassInfo(View v)
    {
        Intent i = new Intent(this, ClassInfo.class);

        i.putExtra("courseName", className.getText().toString());

        startActivity(i);
    }

    public void updateInfo(View v)
    {
        boolean updated;

        updated = myDb.updateData(className.getText().toString(), prof.getText().toString(), unit.getText().toString(), start.getText().toString(), end.getText().toString(), days.getText().toString());

        Intent i = new Intent(this, ClassInfo.class);

        i.putExtra("courseName", className.getText().toString());

        startActivity(i);
    }
}