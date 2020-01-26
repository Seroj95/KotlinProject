package com.example.myapidownloadjavavskotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
private String futbolKulichkic="https://football.kulichki.net/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Hello",futbolKulichkic);
        DownloadTask downloadTask=new DownloadTask();
        try {
          String result=  downloadTask.execute(futbolKulichkic).get();
            Log.i("URL1" ,result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static class DownloadTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder resul = new StringBuilder();
            URL url=null;
            HttpURLConnection httpURLConnection = null;
            try {
                url=new URL(strings[0]);
                httpURLConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(inputStream);
                BufferedReader bufferedReader=new BufferedReader(reader);
                String line=bufferedReader.readLine();
                while (line !=null){
                    resul.append(line);
                    line=bufferedReader.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }

            return resul.toString();
        }
    }
}
