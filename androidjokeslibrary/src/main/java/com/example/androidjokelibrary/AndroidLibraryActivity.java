package com.example.androidjokelibrary;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidLibraryActivity extends AppCompatActivity {

    private static final String INTENT_JOKE_EXTRA = "extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_library);

        TextView jokeTextView = (TextView) findViewById(R.id.joke_text_view);

        Intent intent = getIntent();
        if(intent.hasExtra(INTENT_JOKE_EXTRA)){
            String joke = intent.getStringExtra(INTENT_JOKE_EXTRA);
            jokeTextView.setText(joke);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        super.onBackPressed();
    }

}
