package com.example.studentassistantapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyCourses extends AppCompatActivity {

    ClassDatabaseHelper myDb;


    ArrayList<String> listItem;
    ArrayAdapter adapter;

    Button addCourse;
    EditText addProf, addDays;

    ListView userlist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_courses);

        myDb = new ClassDatabaseHelper(this);


        listItem = new ArrayList<>();

        addCourse = findViewById(R.id.add_course);
        addProf = findViewById(R.id.professor);
        addDays = findViewById(R.id.days);
        userlist = (ListView)findViewById(R.id.courseList);

        viewData();


        // Makes the listview that displayed the courses names clickable, then sends the user to
        // a new activity that displayed all the info of the item that has been clicked.
        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String Templistview = userlist.getItemAtPosition(position).toString();

                Intent intent = new Intent(MyCourses.this, ClassInfo.class);

                intent.putExtra("courseName", Templistview);
                startActivity(intent);

            }
        });
    }


    // Pulls all the class names that are in the database to be listed
    private void viewData()
    {
        Cursor cursor = myDb.viewData();

        if(cursor.getCount() == 0)
        {
            Toast.makeText(this, "No data to show", Toast.LENGTH_LONG).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                listItem.add(cursor.getString(0)); // index 0 is course name
            }

            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, listItem);
            userlist.setAdapter(adapter);

        }
    }
}

