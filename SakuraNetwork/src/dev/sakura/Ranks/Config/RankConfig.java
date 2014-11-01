package dev.sakura.Ranks.Config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import dev.sakura.SakuraNetwork;

public class RankConfig {
	
	public RankConfig() {
	}
	
	private FileConfiguration config = null;
	private File file = null;
	private String path = SakuraNetwork.getInstance().getDataFolder() + File.separator + "users";
	
	public void reloadConfig(Player player) {
		//Try to create the folder
		
		
		if(file == null) {
			file = new File(path, player.getUniqueId().toString()+".data");
		}
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	public FileConfiguration getConfig(Player player) {
		if(config == null) {
			reloadConfig(player);
		}
		return config;
	}
	
	public void saveConfig(Player player) {
		if(file == null) {
			reloadConfig(player);
		}
		try {
			config.save(file);
		} catch(Exception e) {}
	}
}
