package com.activitytest.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button2=(Button)findViewById(R.id.button_2);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                finish();
            }
        });
    }
}
