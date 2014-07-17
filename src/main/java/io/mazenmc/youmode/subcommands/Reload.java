package io.mazenmc.youmode.subcommands;

import io.mazenmc.youmode.managers.ConfigManager;
import io.mazenmc.youmode.models.SubCommand;
import io.mazenmc.youmode.utils.Lang;
import org.bukkit.entity.Player;

public class Reload implements SubCommand{

    @Override
    public void execute(Player p, String[] args) {
        if(!p.hasPermission("youtube.reload")) {
            p.sendMessage(Lang.generateError("You do not have permission for this command!"));
            return;
        }

        ConfigManager.getInstance().reloadConfig();

        p.sendMessage(Lang.generateMessage("Configuration has been reloaded!"));
    }
}
