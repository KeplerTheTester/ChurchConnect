package com.one.johnsmith.churchconnect;

import android.media.audiofx.AudioEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //This simply Describes what the point of the app is
        TextView appDescription = (TextView) findViewById(R.id.description_TextView);
        String myDescriptor = "This version was created on February 10th, 2018";
        String AppNumber = "This is the First version. Still in Beta.";
        appDescription.setText(myDescriptor +"\n"+ AppNumber);
    }
}
