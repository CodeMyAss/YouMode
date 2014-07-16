package io.mazenmc.youmode.commandexecutors;

import io.mazenmc.youmode.managers.ConfigManager;
import io.mazenmc.youmode.utils.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class YoutubersCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        cs.sendMessage(Lang.generateMessage(ConfigManager.getInstance().getStringList("yt/streamer-list").toArray(new String[1])));
        return false;
    }
}
