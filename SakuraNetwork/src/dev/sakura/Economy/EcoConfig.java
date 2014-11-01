package dev.sakura.Economy;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import dev.sakura.SakuraNetwork;

public class EcoConfig {
	private static EcoConfig inst;
	private static Player player;
	
	private EcoConfig() {}
	
	public static EcoConfig getInstance(Player player) {
		EcoConfig.player = player;
		EcoConfig.inst = new EcoConfig();
		return EcoConfig.inst;
	}
	
	private FileConfiguration config = null;
	private File file = null;
	private String path = SakuraNetwork.getInstance().getDataFolder() + File.separator + "users";
	private String filename = EcoConfig.player.getUniqueId().toString()+".yml";
	
	public void reloadConfig() {
		if(file == null) {
			file = new File(path, filename);
		}
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	public FileConfiguration getConfig() {
		if(config == null) {
			reloadConfig();
		}
		return config;
	}
	
	public void saveConfig() {
		if(file == null) {
			reloadConfig();
		}
		try {
			config.save(file);
		} catch(Exception e) {}
	}
}
