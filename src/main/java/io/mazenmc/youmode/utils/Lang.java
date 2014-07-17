package io.mazenmc.youmode.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Lang {

    public static final String[] CMDS = generateMessage("&6/ym list - &bList all youtubers/streamers that are recording/streaming!",
            "&6/ym unmute [all/player] - &bForce a player to get out of record mode;", "&6/ym reload - &bReload configuration files;", "&6/record - &bGo into record mode!",
            "&6/stream - &bGo into streaming mode!", "&6/youtubers - &bDisplays all youtubers!");

    public static final String HEAD = toColour("&a----------------------- &3&l&n[&f&l&nYou&f&4&l&nMode&f&3&l&n] &a-----------------------");
    public static final String ONLY_PLAYER = generateError("Only players can run this command!");
    public static final String STREAM_FINISH = toColour("&6%d has finished streaming!");
    public static final String RECORD_FINISH = toColour("&6&d has finished recording!");
    public static final String STREAM_START = toColour("%d has started streaming at - %d");

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
