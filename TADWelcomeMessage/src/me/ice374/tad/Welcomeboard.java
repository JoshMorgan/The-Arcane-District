package me.ice374.tad;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Welcomeboard extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		System.out.print("Enabled WelcomeBoard!");
	}

	@Override
	public void onDisable() {
		System.out.print("Disabled WelcomeBoard!");
	}
	
	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event)
	{
	    	    final Player player = event.getPlayer();
	            if (player.isOnline())
	            {

	            	final ScoreboardManager manager = Bukkit.getScoreboardManager();
	            	Scoreboard board = manager.getNewScoreboard();
	            	 
	            	Objective objective = board.registerNewObjective("1", "2");
	            	objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	            	objective.setDisplayName("" + ChatColor.GOLD + "" + ChatColor.BOLD + "Welcome to T.A.D!");
	            	 
	            	Score score = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_RED + "Online Players")); //Get a fake offline player
	            	score.setScore(Bukkit.getOnlinePlayers().length);
	            	  player.setScoreboard(board);
	            	
	            
	            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() { 
	            	public void run() {
	            		player.setScoreboard(manager.getNewScoreboard());
	            	}
	            	}, 400); //400 = 20 seconds. 1 second = 20 ticks, 20*20=400
	            
	            }
	            }
	}