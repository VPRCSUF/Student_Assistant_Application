package com.example.studentassistantapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClassDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CourseInfo.db";
    public static final String TABLE_NAME = "Course_table";
    public static final String COL_1_COURSE_NAME = "COURSE";
    public static final String COL_2_PROFESSOR = "PROFESSOR";
    public static final String COL_3_UNITS = "UNITS";
    public static final String COL_4_START_TIME = "START TIME";
    public static final String COL_5_END_TIME = "END_TIME";
    public static final String COL_6_DAYS = "DAYS";




    public ClassDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME + " (Course text PRIMARY KEY, Professor text, Units integer, Start_time text, End_time text, Days text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
