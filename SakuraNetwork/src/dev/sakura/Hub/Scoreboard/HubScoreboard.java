package dev.sakura.Hub.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import dev.sakura.Economy.Eco;

public class HubScoreboard {
	private static HubScoreboard inst = new HubScoreboard();
	private HubScoreboard() {}
	
	public static HubScoreboard getInstance() {
		return inst;
	}
	
	private ScoreboardManager manager = Bukkit.getScoreboardManager();
	private Scoreboard board = manager.getNewScoreboard();
	private Objective obj = board.registerNewObjective("test", "dummy");
	
	public void showHubScoreboard(Player player) {
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"Welcome to Sakura Network");
		createRow(ChatColor.WHITE+""+Eco.getInstance().getBucks(player),0);
		createRow(ChatColor.GREEN+""+ChatColor.BOLD+"Sakura Bucks",2);
		createRow(" ",3);
		createRow(ChatColor.WHITE+""+Eco.getInstance().getCoins(player), 4);
		createRow(ChatColor.GOLD+""+ChatColor.BOLD+"Coins", 5);
		createRow("  ",6);
		createRow(ChatColor.WHITE+""+Eco.getInstance().getPoints(player), 7);
		createRow(ChatColor.AQUA+""+ChatColor.BOLD+"Points", 8);
		
		player.setScoreboard(board);
	}
	
	//Utils
	public void createRow(String txt, int score) {
		Score s = obj.getScore(txt);
		s.setScore(score);
	}
}
