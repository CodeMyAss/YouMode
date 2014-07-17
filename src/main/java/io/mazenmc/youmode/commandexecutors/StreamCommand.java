package io.mazenmc.youmode.commandexecutors;

import io.mazenmc.youmode.enums.PlayerStatus;
import io.mazenmc.youmode.managers.PlayerManager;
import io.mazenmc.youmode.utils.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static io.mazenmc.youmode.managers.StreamManager.getInstance;


public class StreamCommand implements CommandExecutor{

    private final String INVALID_SYNTAX = Lang.toColour("&4Syntax error: /stream {link}");

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if(cs instanceof Player) {
            Player p = (Player) cs;

            if(PlayerManager.getInstance().isRecording(p.getUniqueId())) {
                p.sendMessage(Lang.generateError("Cannot start a stream whilst recording! Do /record to get out of record mode!"));
                return true;
            }

            if(getInstance().isStreaming(p.getUniqueId())) {
                getInstance().removeStreamer(p.getUniqueId());
                PlayerManager.getInstance().setPlayer(p.getUniqueId(), PlayerStatus.NONE);
            }else if(args.length >= 1) {
                getInstance().addStreamer(p.getUniqueId(), args[0]);
            }else{
                cs.sendMessage(INVALID_SYNTAX);
            }

        }else{
            cs.sendMessage(Lang.ONLY_PLAYER);
        }

        return false;
    }
}
