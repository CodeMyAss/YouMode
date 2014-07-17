package io.mazenmc.youmode.subcommands;

import io.mazenmc.youmode.managers.PlayerManager;
import io.mazenmc.youmode.managers.StreamManager;
import io.mazenmc.youmode.models.SubCommand;
import io.mazenmc.youmode.utils.Lang;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Unmute implements SubCommand{

    private static String INVALID_SYNTAX = Lang.toColour("&4Syntax error: /ym unmute [player/all] {player if applicable}");

    @Override
    public void execute(Player p, String[] args) {
        if(!p.hasPermission("youtube.unmute")) {
            p.sendMessage(Lang.generateError("You do not have permission for this command!"));
            return;
        }

        if(args.length >= 1) {
            switch(UnmuteType.valueOf(args[0].toUpperCase())) {
                case ALL:
                    for(Player player : PlayerManager.getInstance().getRecorders()) {
                        player.performCommand("record");
                    }

                    p.sendMessage(ChatColor.GOLD + "All streamers have been unmuted!");
                    break;
                case USER:
                    if(args.length >= 2) {
                        Player target = Bukkit.getPlayer(args[1]);

                        if(target != null) {
                            if(PlayerManager.getInstance().isRecording(target.getUniqueId())) {
                                target.performCommand("record");
                            }else if(StreamManager.getInstance().isStreaming(target.getUniqueId())) {
                                target.performCommand("stream");
                            }else{
                                p.sendMessage(Lang.generateError(args[1] + " is rather not recording or streaming!"));
                            }
                        }else{
                            p.sendMessage(Lang.generateError(args[1] + " is currently offline and can't be unmuted"));
                        }
                    }else{
                        p.sendMessage(INVALID_SYNTAX);
                    }
                    break;
                default:
                    p.sendMessage(INVALID_SYNTAX);
                    break;
            }
        }else{
            p.sendMessage(INVALID_SYNTAX);
        }
    }

    enum UnmuteType {
        ALL, USER
    }
}
