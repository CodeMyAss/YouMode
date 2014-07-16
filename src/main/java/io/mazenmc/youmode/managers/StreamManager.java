package io.mazenmc.youmode.managers;

import io.mazenmc.youmode.enums.PlayerStatus;
import io.mazenmc.youmode.utils.Lang;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.UUID;

public class StreamManager {

    private static final StreamManager INSTANCE = new StreamManager();

    private HashMap<UUID, String> streamData = new HashMap<UUID, String>();

    public String getLink(UUID id) {
        return streamData.get(id);
    }

    public void addStreamer(UUID id, String link) {
        streamData.put(id, link);
        PlayerManager.getInstance().setPlayer(id, PlayerStatus.STREAMING);

        Bukkit.broadcastMessage(String.format(Lang.STARTSTREAM, id, link));
    }

    public void removeStreamer(UUID id) {
        streamData.remove(id);
    }

    public boolean isStreaming(UUID id) {
        return streamData.containsKey(id);
    }

    public static StreamManager getInstance() {
        return INSTANCE;
    }
}
