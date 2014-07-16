package io.mazenmc.youmode.managers;

import io.mazenmc.youmode.models.SubCommand;
import io.mazenmc.youmode.utils.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class SCManager implements CommandExecutor{

    private static final SCManager INSTANCE = new SCManager();
    private HashMap<String, SubCommand> subCommands = new HashMap<String, SubCommand>();

    public void addSubCommand(String identifier, SubCommand command) {
        subCommands.put(identifier, command);
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if(cs instanceof Player) {
            Player p = (Player) cs;

            if(args.length < 1) {
                p.sendMessage(Lang.CMDS);
                return true;
            }

            StringBuilder newArgs = new StringBuilder("");

            for(int i = 1; i < args.length; i++) {
                newArgs.append(args[i]);
                newArgs.append("//");
            }

            for(Map.Entry<String, SubCommand> entry : subCommands.entrySet()) {
                if(entry.getKey().equalsIgnoreCase(args[0])) {
                    entry.getValue().execute(p, newArgs.toString().split("//"));
                    return true;
                }
            }

            p.sendMessage(Lang.CMDS);
        }else{
            cs.sendMessage(Lang.generateError("Only players can run this command!"));
        }
        return false;
    }

    public static SCManager getInstance() {
        return INSTANCE;
    }
}
