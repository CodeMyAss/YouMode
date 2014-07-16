package io.mazenmc.youmode;

import org.bukkit.plugin.java.JavaPlugin;

public class YouModePlugin extends JavaPlugin{

    private static YouModePlugin instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    public static YouModePlugin getInstance() {
        return instance;
    }
}
