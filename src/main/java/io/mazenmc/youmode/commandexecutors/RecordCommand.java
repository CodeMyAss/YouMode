package io.mazenmc.youmode.commandexecutors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RecordCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        if(cs instanceof Player) {
            Player p = (Player) cs;

            //TODO Finish this command
        }
        return false;
    }
}
