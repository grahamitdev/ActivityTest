package com.activitytest.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.activitytest.android.R.id.line;

public class JsonActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "debug";
    private TextView textView = null;
    private Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.sentRequest);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sentRequest:
                sendRequestWithHttpurlConnect();

        }
    }

    private void sendRequestWithHttpurlConnect() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://192.168.100.108:8088/get_data.json");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();


                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    String responseData=response.toString();
                    parseJSONWithJSONObject(responseData);
                    showResponse(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.append(response);
            }
        });
    }
    private void parseJSONWithJSONObject(String jsonData){

        try{
            JSONArray jsonArray=new JSONArray(jsonData);

            for(int i=0;i<jsonArray.length();i++){
                Log.d(TAG, "parseJSONWithJSONObject: done"+i);
                JSONObject jsonobject=jsonArray.getJSONObject(i);
                String id=jsonobject.getString("id");
                String name=jsonobject.getString("name");
                String version=jsonobject.getString("version");
                showResponse(id+" "+name+" "+version+"\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
