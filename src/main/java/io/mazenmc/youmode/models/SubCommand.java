package io.mazenmc.youmode.models;

import org.bukkit.entity.Player;

public interface SubCommand {

    public void execute(Player p, String[] args);
}
