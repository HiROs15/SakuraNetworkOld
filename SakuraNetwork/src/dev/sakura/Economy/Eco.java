package dev.sakura.Economy;

import org.bukkit.entity.Player;

import dev.sakura.SakuraNetwork;

public class Eco {
	private static Eco inst = new Eco();
	private Eco() {}
	
	public static Eco getInstance() {
		return inst;
	}
	
	public void setupPlayerEco(Player player) {
		EcoConfig ecoconfig = new EcoConfig();
		if(!ecoconfig.getConfig(player).getBoolean("data.ecosetup")) {
			ecoconfig.getConfig(player).set("data.ecosetup", true);
			ecoconfig.getConfig(player).set("data.points", 500);
			ecoconfig.getConfig(player).set("data.coins", 0);
			ecoconfig.getConfig(player).set("data.bucks", 0);
			ecoconfig.saveConfig(player);
			SakuraNetwork.getInstance().getLogger().info("Player Economy has been setup for : "+player.getUniqueId().toString());
		}
	}
	
	public int getPoints(Player player) {
		EcoConfig ecoconfig = new EcoConfig();
		return ecoconfig.getConfig(player).getInt("data.points");
	}
	
	public int getCoins(Player player) {
		EcoConfig ecoconfig = new EcoConfig();
		return ecoconfig.getConfig(player).getInt("data.coins");
	}
	
	public int getBucks(Player player) {
		EcoConfig ecoconfig = new EcoConfig();
		return ecoconfig.getConfig(player).getInt("data.bucks");
	}
}
