package com.one.johnsmith.churchconnect;

/**
 * Created by John Smith on 2/11/2018.
 */

public class MessageServer {
    String titleMessage;
    String textMessage;

    public MessageServer(String titleMessage, String textMessage) {
        this.titleMessage = titleMessage;
        this.textMessage = textMessage;
    }

    public String getTitleMessage() {
        return titleMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }
}
