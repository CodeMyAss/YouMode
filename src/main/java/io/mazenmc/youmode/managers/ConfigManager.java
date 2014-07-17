package io.mazenmc.youmode.managers;

import io.mazenmc.youmode.YouModePlugin;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class ConfigManager {

    private static final ConfigManager INSTANCE = new ConfigManager();

    public FileConfiguration getConfig() {
        return YouModePlugin.getInstance().getConfig();
    }

    public List<String> getStringList(String path) {
        return getConfig().getStringList(path);
    }

    public Object get(String path) {
        return getConfig().get(path);
    }

    public String getString(String path) {
        return (String) get(path);
    }

    public void reloadConfig() {
        YouModePlugin.getInstance().reloadConfig();
    }

    public static ConfigManager getInstance() {
        return INSTANCE;
    }
}
