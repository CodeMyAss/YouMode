package io.mazenmc.youmode.listeners;

import io.mazenmc.youmode.managers.PlayerManager;
import io.mazenmc.youmode.managers.StreamManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener{

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        PlayerManager.getInstance().removePlayer(event.getPlayer().getUniqueId());
        StreamManager.getInstance().removeStreamer(event.getPlayer().getUniqueId());
    }
}
