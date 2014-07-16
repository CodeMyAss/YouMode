package io.mazenmc.youmode.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Lang {

    public static final String[] CMDS = generateMessage("&6/ym list - &bList all youtubers that are recording!",
            "&6/ym unmute [all/player] - &bForce a player to get out of record mode;", "&6/ym reload - &bReload configuration files;", "&6/record - &bGo into record mode!",
            "&6/stream - &bGo into streaming mode!", "&6/youtubers - &bDisplays all youtubers!");

    public static final String HEAD = toColour("&a----------------------- &3&l&n[&f&l&nYou&f&4&l&nMode&f&3&l&n] &a-----------------------");

    public static String generateError(String error) {
        return ChatColor.DARK_RED + "ERROR: " + error;
    }

    public static String[] generateMessage(String... strings) {
        List<String> ls = new ArrayList<String>();

        ls.add(HEAD);
        ls.add(" ");

        for(String s : strings) {
            ls.add(toColour(s));
        }

        ls.add(" ");
        ls.add(HEAD);

        return ls.toArray(new String[1]);
    }

    public static String toColour(String otherText) {
        return ChatColor.translateAlternateColorCodes('&', otherText);
    }

}
