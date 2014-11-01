package dev.sakura.Ranks;

import org.bukkit.entity.Player;

import dev.sakura.SakuraNetwork;
import dev.sakura.Ranks.Config.RankConfig;

public class Ranks {
	private static Ranks inst = new Ranks();
	private Ranks() {}
	
	public static Ranks getInstance() {
		return inst;
	}
	
	public void setupPlayerRankConfig(Player player) {
		RankConfig rankconfig = new RankConfig();
		if(!rankconfig.getConfig(player).getBoolean("data.ranksetup")) {
			rankconfig.getConfig(player).set("data.rank", "normal");
			rankconfig.getConfig(player).set("data.ranksetup", true);
			rankconfig.saveConfig(player);
			
			SakuraNetwork.getInstance().getLogger().info(player.getUniqueId().toString()+".yml file has been created.");
		}
	}
	
	public String getRank(Player player) {
		RankConfig rankconfig = new RankConfig();
		return rankconfig.getConfig(player).getString("data.rank");
	}
	
	public void setRank(Player player, String rank) {
		RankConfig rankconfig = new RankConfig();
		
		rankconfig.getConfig(player).set("data.rank",rank);
		rankconfig.saveConfig(player);
	}
	
}
