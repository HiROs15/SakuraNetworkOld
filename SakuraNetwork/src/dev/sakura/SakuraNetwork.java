package dev.sakura;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import dev.sakura.Commands.HubCommands.HubCommandManager;
import dev.sakura.Commands.RanksCommands.RanksCommandManager;
import dev.sakura.Hub.HubManager;
import dev.sakura.Hub.Events.HubEvents;
import dev.sakura.Ping.Ping;
import dev.sakura.Ping.Events.PingEvents;
import dev.sakura.Ranks.Events.RanksEvents;

public class SakuraNetwork extends JavaPlugin {
	public static Plugin getInstance() {
		return Bukkit.getServer().getPluginManager().getPlugin("SakuraNetwork");
	}
	
	@Override
	public void onEnable() {
		//setup Ping data
		setupPing();
		
		//Setup Events
		setupEvents();
		
		//Setup Commands
		setupCommands();
		
		//Setup ranks
		setupRanks();
		
		//Setup hub
		setupHub();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public void setupPing() {
		//Setup ping config file
		Ping.getInstance().setupPingConfig();
	}
	
	public void setupEvents() {
		//Ping Events
		getServer().getPluginManager().registerEvents(new PingEvents(), this);
		
		//Rank events
		getServer().getPluginManager().registerEvents(new RanksEvents(), this);
		
		//Hub Events
		getServer().getPluginManager().registerEvents(new HubEvents(), this);
	}
	
	public void setupCommands() {
		//Ranks Commands
		getCommand("rank").setExecutor(new RanksCommandManager());
		
		//Hub Commands
		getCommand("hub").setExecutor(new HubCommandManager());
	}
	
	public void setupRanks() {
		File path = new File(getDataFolder() + File.separator + "users");
		if(!path.exists()) {
			try {
				path.mkdir();
			} catch(Exception e) {}
		}
	}
	
	public void setupHub() {
		HubManager.getInstance().setupHub();
	}
}
