package io.mazenmc.youmode.utils;

import java.util.concurrent.TimeUnit;

public class TimeUtil {

    public static String formatTime(long time) {
        long days = TimeUnit.SECONDS.toDays(time) % 30;
        long hours = TimeUnit.SECONDS.toHours(time) % 24;
        long minutes = TimeUnit.SECONDS.toMinutes(time) % 60;
        long seconds = TimeUnit.SECONDS.toSeconds(time) % 60;

        return (days == 0L) ? String.format("%d hours, %d minutes; and %d seconds", hours, minutes, seconds) :
                String.format("%d days, %d hours, %d minutes; and %d seconds", days, hours, minutes, seconds);
    }

    public static long valueOf(String s) {
        long time = 0L;

        for(String st : s.split(" ")) {
            if(st.endsWith("d")) {
                time += Long.valueOf(st.substring(0, st.length() - 1)) * 86400L;
                continue;
            }

            if(st.endsWith("s")) {
                time += Long.valueOf(st.substring(0, st.length() - 1));
                continue;
            }

            if(st.endsWith("m")) {
                time += Long.valueOf(st.substring(0, st.length() - 1)) * 60L;
                continue;
            }

            if(st.endsWith("h")) {
                time += Long.valueOf(st.substring(0, st.length() - 1)) * 3600L;
                continue;
            }

            throw new NumberFormatException(st + " is not a time value!");
        }

        return time;
    }
}
