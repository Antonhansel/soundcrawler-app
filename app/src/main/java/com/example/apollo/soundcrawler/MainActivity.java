package com.example.apollo.soundcrawler;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.AsyncTask;
import retrofit.RestAdapter;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton searchTrigger = (ImageButton)findViewById(R.id.searchButton);
        // Fucking listener for the fucking click search icon
        searchTrigger.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView searchField = (TextView)findViewById(R.id.search);
                        Log.v("Test", searchField.getText().toString());
                        new crawlUrl().execute();
                    }
                }
        );
    }

    private class crawlUrl extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... params) {
            try{
                // Fucking REST client
                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint("http://soundcrawler.io")
                        .build();
                RestActivity restActivity = restAdapter.create(RestActivity.class);

                String response = restActivity.crawlUrl("http://soundcloud.com/antoninhansel");
                Log.v("response", response);
            }catch(Exception e){
                e.printStackTrace();
                return "failure";
            }
            return "success";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

