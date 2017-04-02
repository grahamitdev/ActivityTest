package com.activitytest.android;

import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Progressbar extends BaseActivity implements View.OnClickListener {

    private ProgressBar progressBar;
    private ProgressBar progressBarHorizontal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        Button button =(Button)findViewById(R.id.change);
        button.setOnClickListener(this);
        Button buttonadd =(Button)findViewById(R.id.add);
        buttonadd.setOnClickListener(this);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        progressBarHorizontal=(ProgressBar)findViewById(R.id.progressbarhorizontal);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.change:
                if(progressBar.getVisibility()==View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.add:
                int progress=progressBarHorizontal.getProgress();
                progress=progress+10;
                progressBarHorizontal.setProgress(progress);

                break;
            default:
                break;
        }
    }
}
