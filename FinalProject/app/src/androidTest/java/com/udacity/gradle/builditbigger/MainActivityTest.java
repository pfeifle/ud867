package com.udacity.gradle.builditbigger;


import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
//    @Test
//    public void FirstTest(){
//        Assert.assertTrue(false);
//    }

    @Test
    public void tellJoke() throws InterruptedException, ExecutionException {

       String result = new EndpointsAsyncTask (ApplicationProvider.getApplicationContext() , new EndpointsAsyncTask.TaskHandler() {
            @Override
            public void onTaskFinished(String result) {
                Assert.assertTrue(true);
                Assert.assertTrue(result != null && result.length() > 0);
            }
        }).execute().get();

        Assert.assertTrue(result != null && result.length() > 0 && !result.contains("failed to connect to"));

    }
}