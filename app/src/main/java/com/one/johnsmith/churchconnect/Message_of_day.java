package com.one.johnsmith.churchconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Message_of_day extends AppCompatActivity
{
    TextView titleOfMessage_textView;
    TextView bodyOfMessage_textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_of_day);
        //This will use server to get message of the day. Which has a body and a title
        //for now we will set it up that it shows something.
        String titleOfMessage = "Title: test";
        String TextofMessage = "Body: test";
        titleOfMessage_textView = (TextView) findViewById(R.id.title_TextView);
        bodyOfMessage_textView = (TextView) findViewById(R.id.body_TextView);
        titleOfMessage_textView.setText(titleOfMessage);
        bodyOfMessage_textView.setText(TextofMessage);

    }

    //This method will be used to set the text using server or might create a class
    private void setTitleOfMessage_textView()
    {
        //
    }

    //same as the thing right before it
    private void setBodyOfMessage_textView()
    {

    }
}
