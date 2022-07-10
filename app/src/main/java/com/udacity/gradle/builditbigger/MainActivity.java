package com.udacity.gradle.builditbigger;

import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.androidjokelibrary.AndroidLibraryActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;


import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private static final String LOG = MainActivity.class.getSimpleName();

    private static final String INTENT_JOKE_EXTRA = "extra_joke";

    private FrameLayout frameLayoutcontainer;

    private static final int CODE_REQUEST = 2;

    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayoutcontainer = (FrameLayout) findViewById(R.id.fragment_container);
        frameLayoutcontainer.setVisibility(View.VISIBLE);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        setTitle(getString(R.string.app_name));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        progressBar.setVisibility(View.VISIBLE);
        frameLayoutcontainer.setVisibility(View.GONE);
        new EndpointsAsyncTask().execute();
    }


    private class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

        private MyApi myApiService = null;

        @Override
        protected String doInBackground(Void... voids) {
            if (myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        //options for running against local devappserver
                        //- 10.0.2.2 is localhost's IP address in Android emulator
                        //- turn off compression when running against local devappserver
                        .setRootUrl(getString(R.string.local_ip_address))
                        .setApplicationName(getString(R.string.app_name))
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                // end options for devappserver

                myApiService = builder.build();
            }


            try {
                //Retrieve joke from Backend (MyEndpoint.java)
                String jokeFromBackend = myApiService.sayJoke().execute().getData();
                return jokeFromBackend;
            } catch (IOException e) {
                return e.getMessage();
            }

        }


        @Override
        protected void onPostExecute(final String result) {
            //Navigate to Android Library screen
            Intent intent = new Intent(getBaseContext(), AndroidLibraryActivity.class);
            String newJoke;
            if(BuildConfig.IS_PAID) {
                newJoke = result + "\n\n" + "You are using the PAID version of BuildItBigger";
            } else{
                newJoke = result + "\n\n" + "You are using the FREE version of BuildItBigger";
            }
            intent.putExtra(INTENT_JOKE_EXTRA, newJoke);
            startActivityForResult(intent, CODE_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE_REQUEST) {
            if (resultCode == RESULT_OK) {
                progressBar.setVisibility(View.GONE);
                frameLayoutcontainer.setVisibility(View.VISIBLE);
            }
        }
    }



}
