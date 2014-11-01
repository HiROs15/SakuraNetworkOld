package dev.sakura.Hub;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SakuraHubPlayer {
	private UUID uuid;
	private String name;
	private ItemStack[] armor;
	private ItemStack[] inv;
	private Location loc;
	private Player plyr;
	
	public SakuraHubPlayer(Player player) {
		this.uuid = player.getUniqueId();
		this.name = player.getName();
		this.armor = player.getInventory().getArmorContents();
		this.inv = player.getInventory().getContents();
		this.loc = player.getLocation();
		this.plyr = player;
	}
	
	public UUID getUUID() {
		return this.uuid;
	}
	
	public Player getPlayer() {
		return this.plyr;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ItemStack[] getArmor() {
		return this.armor;
	}
	
	public ItemStack[] getInventory() {
		return this.inv;
	}
	
	public Location getLocation() {
		return this.loc;
	}
}
