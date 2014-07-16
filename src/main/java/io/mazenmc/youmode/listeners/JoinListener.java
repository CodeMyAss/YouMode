package io.mazenmc.youmode.listeners;

import io.mazenmc.youmode.YouModePlugin;
import io.mazenmc.youmode.managers.PlayerManager;
import io.mazenmc.youmode.managers.StreamManager;
import io.mazenmc.youmode.utils.Lang;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class JoinListener implements Listener{

    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        PlayerManager.getInstance().addPlayer(event.getPlayer().getUniqueId());

        new BukkitRunnable() {
            @Override
            public void run() {
                List<String> streamMSGs = new ArrayList<String>();

                for(Player p : PlayerManager.getInstance().getStreamers()) {
                    streamMSGs.add(Lang.build(p.getName(), " - &b", StreamManager.getInstance().getLink(p.getUniqueId())));
                }

                if(!streamMSGs.isEmpty())
                    event.getPlayer().sendMessage(Lang.generateMessage(streamMSGs.toArray(new String[1])));
            }
        }.runTaskLater(YouModePlugin.getInstance(), 10L);
    }
}
