package com.activitytest.android;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SQLiteActivity extends AppCompatActivity implements View.OnClickListener {
    private MyDatabaseHelper dbHelper;
    SQLiteDatabase db = dbHelper.getReadableDatabase();
    ContentValues values = new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        Button add = (Button) findViewById(R.id.add_data);
        Button updata = (Button) findViewById(R.id.Updata_data);
        add.setOnClickListener(this);
        updata.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.create_database:
                dbHelper.getWritableDatabase();
                break;
            case R.id.add_data:
                BookPut("The Da Vinci Code", "Dan Brown", 454, 16.96);
                BookPut("The Lost Symbol", "Dan Brown", 510, 19.95);
                break;
            case R.id.Updata_data:
                ;
                break;
            default:
                break;
        }
    }

    public void BookPut(String name, String author, int pages, double price) {
        values.clear();
        values.put("name", name);
        values.put("author", author);
        values.put("pages", pages);
        values.put("price", price);
        db.insert("Book", null, values);
    }
}
