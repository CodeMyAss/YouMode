package io.mazenmc.youmode.managers;

public class ConfigManager {

    private static final ConfigManager instance = new ConfigManager();
    
    public static ConfigManager getInstance() {
        return instance;
    }
}
