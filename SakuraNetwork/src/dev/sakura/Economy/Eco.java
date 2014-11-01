package dev.sakura.Economy;

import org.bukkit.entity.Player;

public class Eco {
	private static Eco inst = new Eco();
	private Eco() {}
	
	public static Eco getInstance() {
		return inst;
	}
	
	public void setupPlayerEco(Player player) {
		if(!EcoConfig.getInstance(player).getConfig().getBoolean("data.ecosetup")) {
			EcoConfig.getInstance(player).getConfig().set("data.ecosetup", true);
			EcoConfig.getInstance(player).getConfig().set("data.points", 500);
			EcoConfig.getInstance(player).getConfig().set("data.coins", 0);
			EcoConfig.getInstance(player).getConfig().set("data.bucks", 0);
			EcoConfig.getInstance(player).saveConfig();
		}
	}
	
	public int getPoints(Player player) {
		return EcoConfig.getInstance(player).getConfig().getInt("data.points");
	}
	
	public int getCoins(Player player) {
		return EcoConfig.getInstance(player).getConfig().getInt("data.coins");
	}
	
	public int getBucks(Player player) {
		return EcoConfig.getInstance(player).getConfig().getInt("data.bucks");
	}
}
