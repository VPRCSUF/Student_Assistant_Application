package com.example.studentassistantapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MyCourses extends AppCompatActivity {

    ClassDatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_courses);

         myDb = new ClassDatabaseHelper(this);

         ListView courseList = findViewById(R.id.courseList);
        SimpleCursorAdapter simpleCursorAdapter = myDb.populateListViewFromDB();

        courseList.setAdapter(simpleCursorAdapter);

        courseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) simpleCursorAdapter.getItem(position);
                String name = cursor.getString(1);
                Toast.makeText(MyCourses.this, name, Toast.LENGTH_SHORT).show();
            }
        });

    }
}

