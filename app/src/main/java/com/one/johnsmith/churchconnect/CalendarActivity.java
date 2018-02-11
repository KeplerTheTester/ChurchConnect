package com.one.johnsmith.churchconnect;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarActivity extends AppCompatActivity {
    TextView TesterText;
    CompactCalendarView compactCalendar;
    TextView EventDescription;
    TextView UpComingEvent;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- YYYY", Locale.getDefault());
    private SimpleDateFormat FormatDateEvents = new SimpleDateFormat("DDD, MM, ");
    SimpleDateFormat FormatTest = new SimpleDateFormat("EEE MMM dd H:mm:ss z yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        final ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(false);
        actionbar.setTitle(null);
        TesterText = (TextView) findViewById(R.id.Test_TextView);
        UpComingEvent = (TextView) findViewById(R.id.Upcoming_TextView);
        //EventDesciptionText.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);
        UpComingEvent.setBackgroundColor(Color.parseColor("#4169E1"));
        EventDescription = (TextView) findViewById(R.id.Description_TextView);
        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);
        UpComingEvent.setText("bet");

        //set an event for tomorrow

        Event ev1 = new Event(Color.BLUE,1515030513000L, "Tomorrow");
        Event ev2 = new Event(Color.BLACK,1514862498000L, "today" );
        compactCalendar.addEvent(ev1);
        compactCalendar.addEvent(ev2);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();

                if(dateClicked.toString().compareTo("Wed Jan 03 00:00:00 EST 2018") == 0)
                {
                    String can = "";
                    long millis = System.currentTimeMillis() ;
                    long millisStart = Calendar.getInstance().getTimeInMillis();
                    String testTime = FormatTest.format(millisStart);
                    if(dateClicked.toString().compareTo(testTime) == 0)
                    {
                        can = "indeed";
                    }
                    String MessageText = " there is something scheduled";
                    String Thing = "    This will say what it is";
                    EventDescription.setText("On "+ShortenTime(dateClicked.toString()) +MessageText+Thing+can);
                    TesterText.setText(   ""+dateClicked+"          "+testTime);
                    //Toast.makeText(context, "works", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Toast.makeText(context, ""+dateClicked, Toast.LENGTH_SHORT).show();
                    //EventDescription.setText(dateClicked.toString()+"There is nothing scheduled for today");
                    String MessageText = " there is nothing scheduled";
                    EventDescription.setText("On "+ShortenTime(dateClicked.toString()) + MessageText);
                }

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                actionbar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });
    }

    public String ShortenTime(String str)
    {
        return str.substring(0, 10) + str.substring(str.length()- 5 ,str.length());
    }
}
