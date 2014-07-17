package io.mazenmc.youmode;

import io.mazenmc.youmode.managers.SCManager;
import io.mazenmc.youmode.models.SubCommand;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

public class YouModePlugin extends JavaPlugin{

    private static YouModePlugin instance;

    @Override
    public void onEnable() {
        //Define plugin instances
        instance = this;

        //Save the configuration as stored if does not exist
        saveDefaultConfig();

        //Register all commands
        registerCommands();
    }


    private void registerCommands() {
        getCommand("ym").setExecutor(SCManager.getInstance());

        for(Class<?> cls : new Reflections("io.mazenmc.youmode.subcommands").getSubTypesOf(SubCommand.class)) {
            try{
                SCManager.getInstance().addSubCommand(cls.getSimpleName(), (SubCommand) cls.newInstance());
            }catch(Exception ex) {ex.printStackTrace();}
        }

        for(Class<?> cls : new Reflections("io.mazenmc.youmode.commandexecutors").getSubTypesOf(CommandExecutor.class)) {
            try{
                String command = cls.getSimpleName().replaceAll("Command", "").toLowerCase();

                getCommand(command).setExecutor((CommandExecutor) cls.newInstance());
            }catch(Exception ex) {ex.printStackTrace();}
        }

        for(Class<?> cls : new Reflections("io.mazenmc.youmode.listeners").getSubTypesOf(Listener.class)) {
            try{
                getServer().getPluginManager().registerEvents((Listener) cls.newInstance(), this);
            }catch(Exception ex) {ex.printStackTrace();}
        }
    }

    public static YouModePlugin getInstance() {
        return instance;
    }
}
