package dev.sakura.Ping;

import org.bukkit.ChatColor;

import dev.sakura.SakuraNetwork;

public class Ping {
	private static Ping inst = new Ping();
	private Ping() {}
	
	public static Ping getInstance() {
		return inst;
	}
	
	public void setupPingConfig() {
		//Check if ping file has been created.
		if(SakuraNetwork.getInstance().getConfig().getBoolean("ping.setup")) {
			
			String motd = ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"SakuraNetwork "+ChatColor.RESET+""+ChatColor.GOLD+": "+ChatColor.AQUA+"Minigames, Survival, Maps, RPG";
			
			SakuraNetwork.getInstance().getConfig().set("ping.setup", true);
			SakuraNetwork.getInstance().getConfig().set("ping.slots", 2000);
			SakuraNetwork.getInstance().getConfig().set("ping.motd", motd);
			SakuraNetwork.getInstance().saveConfig();
		}
	}
}
