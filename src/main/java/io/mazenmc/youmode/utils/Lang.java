package io.mazenmc.youmode.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Lang {
    public static final String HEAD = toColour("&a--------------------- &3[&fYou&f&4Mode&f&3] &a---------------------");
    public static final String ONLY_PLAYER = generateError("Only players can run this command!");
    public static final String STREAM_FINISH = toColour("&6%s has finished streaming!");
    public static final String RECORD_FINISH = toColour("&6%s has finished recording!");
    public static final String STREAM_START = toColour("&6%s has started streaming at - &b%s");

    public static final String[] CMDS = generateMessage("/ym list - &bList all youtubers/streamers that are recording/streaming!",
            "/ym unmute [all/player] - &bForce a player to get out of record mode;", "/ym reload - &bReload configuration files;", "/record - &bGo into record mode!",
            "/stream - &bGo into streaming mode!", "/youtubers - &bDisplays all youtubers!");

    public static String generateError(String error) {
        return ChatColor.DARK_RED + "ERROR: " + error;
    }

    public static String[] generateMessage(String... strings) {
        List<String> ls = new ArrayList<String>();

        ls.add(HEAD);
        ls.add(" ");

        for(String s : strings) {
            ls.add(toColour("&6" + s));
        }

        ls.add(" ");
        ls.add(HEAD);

        return ls.toArray(new String[1]);
    }

    public static String build(Object... objects) {
        StringBuilder builder = new StringBuilder("");

        for(Object o : objects) {
            builder.append(o);
        }

        return builder.toString();
    }

    public static String toColour(String otherText) {
        return ChatColor.translateAlternateColorCodes('&', otherText);
    }

}
