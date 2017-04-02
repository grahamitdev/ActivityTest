package com.activitytest.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button btn1=(Button)findViewById(R.id.Btn1);
        Button btn2=(Button)findViewById(R.id.Btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.Btn1:
                Toast.makeText(this,"btn1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Btn2:
                Toast.makeText(this,"btn2",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
