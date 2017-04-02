package com.activitytest.android;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends BaseActivity {

    private  MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new MyDatabaseHelper(this,"BookStore.db",null,2);
        //[获取NavigationBar高度]
        Resources resources = this.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height","dimen", "android");
        int NavigationHeight = resources.getDimensionPixelSize(resourceId);
        TextView editText=(TextView) findViewById(R.id.navigationbarheight);
        editText.setText("NavigationHeight="+String.valueOf(NavigationHeight));
        //[获取NavigationBar高度]
        Log.d("height", "NavigationHeight="+String.valueOf(NavigationHeight));


        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent("ImplicitStart");
                intent.addCategory("MyCategory");
                startActivity(intent);
            }
        });
        Button button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });
        Button button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
        Button button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                String data = "Hello Activity";
                Intent intent = new Intent(MainActivity.this, SixActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        });
        Button button7 = (Button) findViewById(R.id.button_7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(MainActivity.this, SixActivity.class);
                String data = "我要等你返回数据";
                intent.putExtra("extra_data", data);
                startActivityForResult(intent, 1);
            }
        });
        Button button8 = (Button) findViewById(R.id.button_8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(MainActivity.this, LifeActivity.class);
                startActivity(intent);
            }

        });
        Button button9 = (Button) findViewById(R.id.button_9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                TenActivity.actionStart(MainActivity.this, "data1", "data2");
            }

        });
        Button button10 = (Button) findViewById(R.id.button_10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(intent);
            }

        });
        Button button11 = (Button) findViewById(R.id.button_11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(MainActivity.this, EditView.class);
                startActivity(intent);
            }

        });
        Button button12 = (Button) findViewById(R.id.button_12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                startActivity(intent);
            }

        });
        Button button13 = (Button) findViewById(R.id.button_13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(MainActivity.this, Progressbar.class);
                startActivity(intent);
            }

        });
        Button button14 = (Button) findViewById(R.id.button_14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);//触摸和返回键失效
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
            }
        });
        Button button15 = (Button) findViewById(R.id.button_15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });
        Button button16 = (Button) findViewById(R.id.button_16);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(MainActivity.this, PercentFrameLayout.class);
                startActivity(intent);

            }
        });
        Button button17 = (Button) findViewById(R.id.button_17);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent = new Intent(MainActivity.this, BroadCastActivity.class);
                startActivity(intent);

            }
        });
        Button button18 = (Button) findViewById(R.id.button_18);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
               Intent intent =new Intent (MainActivity.this,SQLiteActivity.class);
                startActivity(intent);
		Toast.makeText(MainActivity.this,"进入SQLiteActivity",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = intent.getStringExtra("data_return");
                    Toast.makeText(MainActivity.this, returnedData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "you clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "you clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_item:
                Toast.makeText(this, "you clicked Settting", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
        return true;
    }


}
