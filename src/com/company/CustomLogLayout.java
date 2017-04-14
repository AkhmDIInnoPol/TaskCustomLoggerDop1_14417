package com.company;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Created by Di on 14.04.2017.
 */
public class CustomLogLayout extends PatternLayout
{

        public String format(LoggingEvent event)
        {
            UserObject user = (UserObject)event.getMessage();

            StringBuffer sb = new StringBuffer();

            String name = user.getName();
            String comment = user.getComment();

            String message = "name = " + name + "\n comment = " + comment;

            return message;
        }


}
