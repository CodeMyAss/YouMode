package io.mazenmc.youmode.managers;

import io.mazenmc.youmode.enums.PlayerStatus;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class PlayerManager {
    
    private static final PlayerManager INSTANCE = new PlayerManager();

    private HashMap<UUID, PlayerStatus> statusData = new HashMap<UUID, PlayerStatus>();

    public void addPlayer(UUID id) {
        statusData.put(id, PlayerStatus.NONE);
    }

    public void setPlayer(UUID id, PlayerStatus status) {
        if(statusData.containsKey(id))
            statusData.remove(id);

        statusData.put(id, status);
    }

    public List<Player> getStreamers() {
        List<Player> streamers = new ArrayList<Player>();

        for(Map.Entry<UUID, PlayerStatus> entry : statusData.entrySet()) {
            if(entry.getValue() == PlayerStatus.STREAMING)
                streamers.add(Bukkit.getPlayer(entry.getKey()));
        }

        return streamers;
    }

    public boolean isRecording(UUID id) {
        return statusData.containsKey(id) && statusData.get(id) == PlayerStatus.RECORDING;
    }

    public List<Player> getRecorders() {
        List<Player> recorders = new ArrayList<Player>();

        for(Map.Entry<UUID, PlayerStatus> entry : statusData.entrySet()) {
            if(entry.getValue() == PlayerStatus.RECORDING)
                recorders.add(Bukkit.getPlayer(entry.getKey()));
        }

        return recorders;
    }

    public void removePlayer(UUID id) {
        statusData.remove(id);
    }

    public static PlayerManager getInstance() {
        return INSTANCE;
    }
}
