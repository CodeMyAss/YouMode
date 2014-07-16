package io.mazenmc.youmode.managers;

import io.mazenmc.youmode.enums.PlayerStatus;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {
    
    private static final PlayerManager instance = new PlayerManager();

    private HashMap<UUID, PlayerStatus> statusData = new HashMap<UUID, PlayerStatus>();

    public static PlayerManager getInstance() {
        return instance;
    }
}
