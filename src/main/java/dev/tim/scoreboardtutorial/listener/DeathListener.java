package dev.tim.scoreboardtutorial.listener;

import dev.tim.scoreboardtutorial.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player player = e.getEntity();

        int amount = Main.getDeaths().get(player.getUniqueId());
        amount++;

        Main.getDeaths().put(player.getUniqueId(), amount);
        player.getScoreboard().getTeam("deaths").setSuffix(ChatColor.GREEN.toString() + amount);

    }
}
