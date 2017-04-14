package com.company;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

public class Main {

    static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
	// write your code here

        UserObject userObject = new UserObject("Dinar", "It is first log message");

        String fileName = "filename.txt";

        FormatMessage.format(userObject, fileName);

        FormatMessage.format(userObject, fileName);

        FormatMessage.format(userObject, fileName);

        FormatMessage.format(userObject, fileName);

//        FormatMessage.close();

//        SendMailClass.sendMailTLL(message);



    }
}
