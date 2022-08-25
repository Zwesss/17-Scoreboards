package dev.tim.scoreboardtutorial;

import dev.tim.scoreboardtutorial.listener.DeathListener;
import dev.tim.scoreboardtutorial.listener.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin {

    public static HashMap<UUID, Integer> deaths = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
    }

    public static void createScoreboard(Player player){
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("tutorialboard", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.RED.toString() + ChatColor.BOLD + "TEST BOARD!");

        Score emptyLine = objective.getScore(" ");
        emptyLine.setScore(4);
        Score playerName = objective.getScore(ChatColor.YELLOW + "Naam: " + player.getDisplayName());
        playerName.setScore(3);
        Score welcomeText = objective.getScore(ChatColor.GRAY + "Welkom op deze server!");
        welcomeText.setScore(2);
        Score emptyLine2 = objective.getScore("  ");
        emptyLine2.setScore(1);

        Team deaths = scoreboard.registerNewTeam("deaths");
        deaths.addEntry(ChatColor.RED.toString());
        deaths.setPrefix(ChatColor.AQUA + "Deaths: ");
        deaths.setSuffix(ChatColor.GREEN + "0");
        objective.getScore(ChatColor.RED.toString()).setScore(0);

        player.setScoreboard(scoreboard);
    }

    public static HashMap<UUID, Integer> getDeaths(){
        return deaths;
    }

}
