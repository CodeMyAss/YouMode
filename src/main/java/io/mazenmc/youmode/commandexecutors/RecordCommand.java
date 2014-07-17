package io.mazenmc.youmode.commandexecutors;

import io.mazenmc.youmode.YouModePlugin;
import io.mazenmc.youmode.enums.PlayerStatus;
import io.mazenmc.youmode.managers.PlayerManager;
import io.mazenmc.youmode.managers.StreamManager;
import io.mazenmc.youmode.utils.Lang;
import io.mazenmc.youmode.utils.TimeUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class RecordCommand implements CommandExecutor{

    private HashMap<UUID, BukkitRunnable> runnables = new HashMap<UUID, BukkitRunnable>();

    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        if(cs instanceof Player) {
            Player p = (Player) cs;
            final UUID id = p.getUniqueId();

            if(StreamManager.getInstance().isStreaming(id)) {
                p.sendMessage(Lang.generateError("You may not record whilst streaming! Please do /stream to stop streaming"));
                return true;
            }

            if(PlayerManager.getInstance().isRecording(id)) {
                PlayerManager.getInstance().setPlayer(id, PlayerStatus.NONE);

                Bukkit.broadcastMessage(Lang.RECORD_FINISH);
            }else{
                PlayerManager.getInstance().setPlayer(id, PlayerStatus.RECORDING);

                for(String str : Lang.generateMessage(p.getName() + " has started recording; he/she will not be able to respond to messages!")) {
                    Bukkit.broadcastMessage(str);
                }

                if(runnables.containsKey(id)) {
                    runnables.get(id).cancel();
                    runnables.remove(id);
                }

                if(args.length >= 1) {
                    StringBuilder sb = new StringBuilder("");

                    for(int i = 0; i < args.length; i++) {
                        sb.append(args[i]);
                        sb.append(' ');
                    }

                    long time = TimeUtil.valueOf(sb.toString());

                    p.sendMessage(ChatColor.GOLD + "You will stop recording in " + TimeUtil.formatTime(time));

                    BukkitRunnable runnable = new BukkitRunnable() {
                        @Override
                        public void run() {
                            Player p = Bukkit.getPlayer(id);

                            if(PlayerManager.getInstance().isRecording(id) && p != null) {
                                p.performCommand("record");
                            }
                        }
                    };

                    runnable.runTaskLater(YouModePlugin.getInstance(), time);
                    runnables.put(id, runnable);
                }
            }
        }else{
            cs.sendMessage(Lang.ONLY_PLAYER);
        }
        return false;
    }
}
