package dev.tim.scoreboardtutorial.listener;

import dev.tim.scoreboardtutorial.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Main.createScoreboard(e.getPlayer());
        Main.getDeaths().put(e.getPlayer().getUniqueId(), 0);
    }

}
