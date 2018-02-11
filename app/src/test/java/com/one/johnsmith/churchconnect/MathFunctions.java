package com.one.johnsmith.churchconnect; /**
 * Created by John Smith on 2/10/2018.
 */

import java.util.ArrayList;
import java.util.Date;


/*
    This Class will be all the Math functions needed for all my code
 */


public class MathFunctions {
    public MathFunctions() {

    }

    //Function is to change Epoch TimeStamp to milliseconds
    public long LongLiteral(long longNumber) {
        long holder = 1000L;
        return (longNumber * holder);
    }


    //This is just to sort events by their time
    public ArrayList<Main> quickSort(ArrayList<Main> list) {
        if (list.size() <= 1)
            return list; // Already sorted

        ArrayList<Main> sorted = new ArrayList<Main>();
        ArrayList<Main> lesser = new ArrayList<Main>();
        ArrayList<Main> greater = new ArrayList<Main>();
        Main pivot = list.get(list.size() - 1); // Use last Vehicle as pivot
        for (int i = 0; i < list.size() - 1; i++) {
            //int order = list.get(i).compareTo(pivot);
            if (list.get(i).getTime_milli() < pivot.getTime_milli()) {
                lesser.add(list.get(i));
            } else {
                greater.add(list.get(i));
            }
        }

        lesser = quickSort(lesser);
        greater = quickSort(greater);

        lesser.add(pivot);
        lesser.addAll(greater);
        sorted = lesser;

        return sorted;
    }

    private void DeletePassedTime() {
        long poop = this.LongLiteral(1222222);//current date
        ArrayList<Main> answer = new ArrayList<>();
        int i = 0;
        while (i <= answer.size()) {
            if (answer.get(i).getTime_milli() < poop) {
                answer.remove(i);
            }
        }
    }

    //Name of this function makes no sense the goal of this is to call itself until nothing is before the date
    ArrayList<Main> EventSpoof(ArrayList<Main> one, long Today_Date) {
        ArrayList<Main> answer = new ArrayList<Main>();
        for (int i = 0; i < one.size(); i++) {
            if (one.get(i).getTime_milli() < Today_Date) {
                answer.add(one.get(i));
            }
        }
        return answer;
    }

    public long GetCurrentTime(Date date) {
        String a = date.toString();
        Main one = new Main(a);
        one.setTime_milli(a);
        long answer = 0;
        answer = one.setTime_milli(a);

        return answer;
    }
}
