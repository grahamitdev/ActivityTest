package com.activitytest.android;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.BatchUpdateException;

import static com.activitytest.android.R.id.line;

public class SQLiteActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "database";
    private MyDatabaseHelper dbHelper;
    SQLiteDatabase db = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        db = dbHelper.getWritableDatabase();//开db

        Button create = (Button) findViewById(R.id.create_database);
        Button add = (Button) findViewById(R.id.add_data);
        Button updata = (Button) findViewById(R.id.Updata_data);
        Button delete = (Button) findViewById(R.id.delete_data);
        Button query = (Button) findViewById(R.id.query_data);
        Button clear = (Button) findViewById(R.id.clear);
        Button addsql = (Button) findViewById(R.id.add_sql);
        Button updatasql = (Button) findViewById(R.id.Updata_sql);
        Button deletesql = (Button) findViewById(R.id.delete_sql);
        deletesql.setOnClickListener(this);
        create.setOnClickListener(this);
        add.setOnClickListener(this);
        updata.setOnClickListener(this);
        delete.setOnClickListener(this);
        query.setOnClickListener(this);
        clear.setOnClickListener(this);
        addsql.setOnClickListener(this);
        updatasql.setOnClickListener(this);
        TextView line = (TextView) findViewById(R.id.line);
        line.setText("记录打印:\n");
    }

    @Override
    public void onClick(View v) {
        db = dbHelper.getWritableDatabase();//开db
        ContentValues values = new ContentValues();
        Cursor cursor = db.query("Book", null, null, null, null, null, null);

        switch (v.getId()) {
            case R.id.create_database:
                dbHelper.getWritableDatabase();
                break;
            case R.id.add_data:
                values.clear();
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.insert("Book", null, values);

                values.clear();
                values.put("name", "The Lost Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 16.95);
                db.insert("Book", null, values);
                //db.close();//关db

                break;
            case R.id.add_sql:
                Log.d(TAG, "onClick: add_sql");
                db.execSQL("insert into Book (name,author,pages,price) values(?,?,?,?)", new String[]{"第一行代码", "郭霖", "570", "79.00"});
                break;
            case R.id.Updata_data:
                values.clear();
                values.put("price", 10.99);
                db.update("Book", values, "name=?", new String[]{"The Da Vinci Code"});
                break;
            case R.id.Updata_sql:
                db.execSQL("update Book set price=? where author=?", new String[]{"10.99", "郭霖"});
                break;
            case R.id.delete_data:
                db.delete("Book", "pages>?", new String[]{"500"});
                break;
            case R.id.delete_sql:
                db.execSQL("delete from Book where author=?", new String[]{"Dan Brown"});
                break;
            case R.id.query_data:
                Log.d(TAG, "onClick: hello");
                if (cursor.moveToFirst()) {
                    do {
                        int id = cursor.getInt(cursor.getColumnIndex("id"));
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        TextView line = (TextView) findViewById(R.id.line);
                        line.append(id + name + author + pages + " " + price + "\n");
                    } while (cursor.moveToNext());
                    Log.d(TAG, "onClick: 10");
                }
                cursor.close();
                Log.d(TAG, "onClick: 11");
                break;
            case R.id.clear:
                TextView line = (TextView) findViewById(R.id.line);
                line.setText("");
                Log.d(TAG, "onClick: clear");
                break;
            default:
                break;
        }
    }
}
