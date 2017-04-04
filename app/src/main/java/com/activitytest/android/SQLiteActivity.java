package com.activitytest.android;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class SQLiteActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG="database";
    private MyDatabaseHelper dbHelper;
        


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);

        Button create = (Button) findViewById(R.id.create_database);
        Button add = (Button) findViewById(R.id.add_data);
        Button updata = (Button) findViewById(R.id.Updata_data);
        Button delete=(Button)findViewById(R.id.delete_data);
        create.setOnClickListener(this);
        add.setOnClickListener(this);
        updata.setOnClickListener(this);
        delete.setOnClickListener(this);
        TextView line=(TextView)findViewById(R.id.line);
        line.setText("记录打印");
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values =new ContentValues();
        switch (v.getId()) {
            case R.id.create_database:
                dbHelper.getWritableDatabase();
                break;
            case R.id.add_data:
                values.clear();
                values.put("name","The Da Vinci Code");
                values.put("author","Dan Brown");
                values.put("pages",454);
                values.put("price",16.96);
                db.insert("Book",null,values);
                Log.d("database","line1");

                values.clear();
                values.put("name","The Lost Symbol");
                values.put("author","Dan Brown");
                values.put("pages",510);
                values.put("price",16.95);
                db.insert("Book",null,values);
                Log.d("database","line2");

                break;
            case R.id.Updata_data:
                values.clear();
                values.put("price",10.99);
                db.update("Book",values,"name=?",new String[]{"The Da Vinci Code"});
                Log.d(TAG, "onClick: updata");
                break;
            case R.id.delete_data:
                db.delete("Book","pages>?",new String[]{"500"});
                Log.d(TAG, "onClick: delete");
            default:
                break;
        }
    }
}
