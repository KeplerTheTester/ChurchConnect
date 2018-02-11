package com.one.johnsmith.churchconnect;

/**
 * Created by John Smith on 2/11/2018.
 */

public class UserServer {
    String name;
    String phoneNumber;
    String emailAccount;

    public UserServer(String name, String phoneNumber, String emailAccount) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAccount = emailAccount;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAccount() {
        return emailAccount;
    }
}
