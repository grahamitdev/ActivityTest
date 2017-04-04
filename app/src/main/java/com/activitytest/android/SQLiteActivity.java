package com.activitytest.android;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.BatchUpdateException;

public class SQLiteActivity extends AppCompatActivity implements View.OnClickListener {
    private MyDatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);

        Button create = (Button) findViewById(R.id.create_database);
        Button add = (Button) findViewById(R.id.add_data);
        Button updata = (Button) findViewById(R.id.Updata_data);
        create.setOnClickListener(this);
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

                break;
            case R.id.Updata_data:

                break;
            default:
                break;
        }
    }
}
