package io.mazenmc.youmode.listeners;

import io.mazenmc.youmode.managers.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener{

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        for(Player p : PlayerManager.getInstance().getRecorders())
            event.getRecipients().remove(p);
    }
}
