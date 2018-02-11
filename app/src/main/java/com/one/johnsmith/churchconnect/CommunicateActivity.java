package com.one.johnsmith.churchconnect;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class CommunicateActivity extends AppCompatActivity {

    private static boolean ShouldSendEmail = false;
    //these are static variables that will check user to see
    //if they want to send things and how
    EditText message_editText;
    private int Permission;
    private static boolean ShouldSendText = false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commucate_acitivity);
        final Button send = (Button) findViewById(R.id.send_button);
        Switch email = findViewById(R.id.email_switch);
        Switch text = findViewById(R.id.Text_switch);
        message_editText= (EditText) findViewById(R.id.message_EditText);

        //Checks if switch is true, and if true tells the program that it should send an Email
        email.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean wantsIt)
            {
                if(wantsIt == true)
                {
                    Toast.makeText(getBaseContext(), "Selected Email", Toast.LENGTH_SHORT).show();
                    ShouldSendEmail = true;
                }
            }
        });

        //check if switch is true, and if true tells the program it should send a Text.
        text.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean wantsIt)
            {
                if(wantsIt == true)
                {
                    Toast.makeText(getBaseContext(), "Selected Text", Toast.LENGTH_SHORT).show();
                    ShouldSendText = true;
                }
            }
        });

        //This serves multiple functions. Sees what user checked. And sends text and/or email depending on their choice
        //Also has some Toast to make sure that everything works
        //Also if User put nothing it will toast and prompt them to
        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String messagePrompted;
                String errorMessage = "You did not write anything. Cannot send empty message.";
                if(ShouldSendEmail== true && ShouldSendText == true)
                {
                    messagePrompted = "Email and Text will be sent";
                    if(isEmpty(message_editText)==false)
                    {
                        sendEmail(messageToSend(message_editText));
                        sendText(messageToSend(message_editText));

                        Toast.makeText(getApplicationContext(), messagePrompted, Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
                    }
                }
                if(ShouldSendEmail == true && ShouldSendText == false)
                {
                    //only send email
                    messagePrompted = "Only an Email will be sent";
                    if(isEmpty(message_editText)==false)
                    {
                        sendEmail(messageToSend(message_editText));
                        Toast.makeText(getApplicationContext(), messagePrompted, Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
                    }
                }
                if(ShouldSendText == true && ShouldSendEmail == false)
                {
                    //only send text message
                    messagePrompted = "Only a Text will be sent";
                    if(isEmpty(message_editText)==false)
                    {
                        //sendText(messageToSend(message_editText));
                        sendText(messageToSend(message_editText));
                        Toast.makeText(getApplicationContext(), messagePrompted, Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
                    }
                }
                if(ShouldSendEmail == false && ShouldSendText == false)
                {
                    if(isEmpty(message_editText)== false)
                    {
                        Toast.makeText(getApplicationContext(), "You did not select any delivery method", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //Email Function. Everything else is already assigned except the message. That is decided by user
    private void sendEmail(String s) {
        Toast.makeText(getBaseContext(), "sending email    "  +ShouldSendEmail, Toast.LENGTH_LONG).show();
        //sendMail("this is a test", "from kepler");
        Intent sendingMail = new Intent(Intent.ACTION_SENDTO);
        sendingMail.setData(Uri.parse("mailto: example@gmail.com"));
        //mail to is the user you are sending it to.
        sendingMail.putExtra(Intent.EXTRA_EMAIL, "YourEmail@gmail.com");
        sendingMail.putExtra(Intent.EXTRA_CC, "amandaspoop@gmail.com");
        sendingMail.putExtra(Intent.EXTRA_SUBJECT, s);
        sendingMail.putExtra(Intent.EXTRA_TEXT, "this is to find all that works");
        if (sendingMail.resolveActivity(getPackageManager()) != null)
        {
            startActivity(sendingMail);
        }
    }

    //Function below is to get user to give permission to allow access to sms
    //need to test out on a phone with text
    //This function does not work. Need to find out how to fix it. 
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        if (ContextCompat.checkSelfPermission(CommunicateActivity.this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(CommunicateActivity.this,
                    Manifest.permission.SEND_SMS)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(CommunicateActivity.this,
                        new String[]{Manifest.permission.SEND_SMS},
                        Permission);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    //Just the SMS sender function. Input phone number and message
    //Need to test this method out on a phone with text
    private void sendText(String message)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("7862706830", null, message, null, null);
    }

    //Just to check that the user has written something in the editText
    private boolean isEmpty(EditText editText)
    {
        boolean answer = true;
        if(editText.getText().toString() != null)
            answer = false;
        return answer;
    }

    //Message written in EditText
    private String messageToSend(EditText editText)
    {
        String answer = "";
        if(isEmpty(editText) == false)
            answer = editText.getText().toString();
        return answer;
    }

    //This will be taken by finding userPhone Number
    //create user class and
    private String getUserPhone()
    {
        String answer ="";



        return answer;
    }


}
