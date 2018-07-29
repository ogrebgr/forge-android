package com.bolyartech.forge.android.misc;

import org.slf4j.Logger;


public class LogUtils {
    /**
     * Non-instantiable utility class
     */
    private LogUtils() {
        throw new AssertionError();
    }


    /**
     * Used to log large messages (above 4k). Will split the message. Will use debug level of logging
     *
     * @param logger
     * @param content
     */
    public static void largeLogDebug(Logger logger, String content) {
        if (content.length() > 4000) {
            logger.debug(content.substring(0, 4000));
            largeLogDebug(logger, content.substring(4000));
        } else {
            logger.debug(content);
        }
    }
}
