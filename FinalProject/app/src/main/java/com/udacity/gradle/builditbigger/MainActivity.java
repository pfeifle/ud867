package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lib_androidjokes.MainActivity_AndroidJokeLib;





public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

//    public void tellJoke(View view)
//    {
//        //Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
//        Jokes myJokes = new Jokes();
//        Toast.makeText(this, myJokes.getJoke(), Toast.LENGTH_SHORT).show();
//
//        Intent intent = new Intent(this, MainActivity_AndroidJokeLib.class);
//        intent.putExtra("JOKE", myJokes.getJoke());
//        startActivity(intent);
//    }


    public void tellJoke(View view) {
        new EndpointsAsyncTask(this, new EndpointsAsyncTask.TaskHandler() {

            @Override
            public void onTaskFinished(String result) {
                Intent intent = new Intent(MainActivity.this, MainActivity_AndroidJokeLib.class);
                intent.putExtra("JOKE", result);
                startActivity(intent);
            }
        }).execute();
    }

}
