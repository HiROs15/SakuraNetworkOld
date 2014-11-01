package dev.sakura.Hub.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import dev.sakura.SakuraNetwork;
import dev.sakura.Economy.Eco;
import dev.sakura.Ranks.Ranks;

public class HubScoreboard {
	private static HubScoreboard inst = new HubScoreboard();
	private HubScoreboard() {}
	private int bucks = 0;
	private int points = 0;
	private int coins = 0;
	
	public static HubScoreboard getInstance() {
		return inst;
	}
	
	public void cacheData(Player player) {
		this.points = Eco.getInstance().getPoints(player);
		this.coins = Eco.getInstance().getCoins(player);
		this.bucks = Eco.getInstance().getBucks(player);
	}
	
	private Score onlineStaff = null;
	
	public void showHubScoreboard(Player player, String adminText) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Objective obj = board.registerNewObjective("test", "dummy");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"Welcome to Sakura Network");
		createRow(ChatColor.WHITE+""+this.bucks+"   ",0,obj);
		createRow(ChatColor.GREEN+"Sakura Bucks",2,obj);
		createRow(" ",3,obj);
		createRow(ChatColor.WHITE+""+this.coins+"  ", 4,obj);
		createRow(ChatColor.GOLD+"Coins", 5,obj);
		createRow("  ",6,obj);
		createRow(ChatColor.WHITE+""+this.points+" ", 7,obj);
		createRow(ChatColor.AQUA+"Points", 8,obj);
		createRow("   ", 9, obj);
		
		onlineStaff = obj.getScore(adminText);
		onlineStaff.setScore(10);
		
		createRow(ChatColor.RED+"Online Staff", 11,obj);
		
		player.setScoreboard(board);
		
		//scroll admins
		scrollAdmins(player, manager, board, obj);
	}
	
	//Utils
	public void createRow(String txt, int score, Objective obj) {
		Score s = obj.getScore(txt);
		s.setScore(score);
	}
	
	private String adminText = "";
	private int length = 10;
	private int i = 0;
	@SuppressWarnings("deprecation")
	public void scrollAdmins(final Player player, final ScoreboardManager manager, Scoreboard board, Objective obj) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(Ranks.getInstance().getRank(p).equals("mod") || Ranks.getInstance().getRank(p).equals("admin") || Ranks.getInstance().getRank(p).equals("sakuramember")) {
				adminText += p.getName() + ", ";
			}
		}
		
		SakuraNetwork.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(SakuraNetwork.getInstance(), new Runnable() {
			public void run() {
				String split = adminText.substring(i) + " " + adminText.substring(0, i);
				String win = split.substring(0, length);
				
				i++;
				
				if(i == adminText.length()-1) {
					i = 0;
				}
				player.setScoreboard(manager.getNewScoreboard());
				showHubScoreboard(player, win);
				
			}
		}, 10L);
	}
}
