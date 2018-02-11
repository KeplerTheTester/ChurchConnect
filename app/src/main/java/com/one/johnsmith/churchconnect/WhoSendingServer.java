package com.one.johnsmith.churchconnect;

/**
 * Created by John Smith on 2/11/2018.
 */


//This is to know who the text should send. Kinda like the UserClass but has a name String
public class WhoSendingServer {
    String name;
    String phoneNumber;
    String Email;

    public WhoSendingServer(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        Email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return Email;
    }
}
