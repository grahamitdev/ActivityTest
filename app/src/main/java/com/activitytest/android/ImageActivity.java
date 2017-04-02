package com.activitytest.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends BaseActivity implements View.OnClickListener{

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Button buttondown=(Button)findViewById(R.id.buttonImagedown);
        Button buttonup=(Button)findViewById(R.id.buttonImageupup);
        imageView=(ImageView)findViewById(R.id.img_1);
        buttondown.setOnClickListener(this);
        buttonup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonImagedown:
                imageView.setImageResource(R.drawable.img_2);
                break;
            case R.id.buttonImageupup:
                imageView.setImageResource(R.drawable.img_1);
                break;
            default:
                break;
        }
    }
}
