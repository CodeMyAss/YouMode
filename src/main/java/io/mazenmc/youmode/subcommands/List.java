package io.mazenmc.youmode.subcommands;

import io.mazenmc.youmode.managers.PlayerManager;
import io.mazenmc.youmode.managers.StreamManager;
import io.mazenmc.youmode.models.SubCommand;
import io.mazenmc.youmode.utils.Lang;
import org.bukkit.entity.Player;

public class List implements SubCommand{

    @Override
    public void execute(Player p, String[] args) {
        if(!p.hasPermission("youtube.list")) {
            p.sendMessage(Lang.generateError("You do not have permission for this command!"));
            return;
        }

        java.util.List<Player> recorders = PlayerManager.getInstance().getRecorders();
        java.util.List<Player> streamers = PlayerManager.getInstance().getStreamers();

        p.sendMessage(Lang.HEAD + "\n");
        p.sendMessage(Lang.toColour("&6Current recorders/streamers:"));

        for(int i = 0; i < Math.max(recorders.size(), streamers.size()); i++) {
            Player recorder = null;
            Player streamer = null;

            try{
                recorder = recorders.get(i);
            }catch(IndexOutOfBoundsException ignored) {}

            try{
                streamer = streamers.get(i);
            }catch(IndexOutOfBoundsException ignored) {}

            if(recorder != null) {
                p.sendMessage(Lang.build("&6", recorder.getName()));
            }

            if(streamer != null) {
                p.sendMessage(Lang.build("&6", streamer.getName(), " - &b", StreamManager.getInstance().getLink(streamer.getUniqueId())));
            }
        }

        p.sendMessage("\n" + Lang.HEAD);
    }
}
