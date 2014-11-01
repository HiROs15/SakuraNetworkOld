package dev.sakura.Hub;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dev.sakura.SakuraNetwork;
import dev.sakura.Hub.Scoreboard.HubScoreboard;
import dev.sakura.Ranks.Ranks;

public class HubManager {
	private static HubManager inst = new HubManager();
	
	private Hub hub;
	
	private HubManager() {
	}
	
	public static HubManager getInstance() {
		return inst;
	}
	
	
	public boolean isHubSetup() {
		String world = SakuraNetwork.getInstance().getConfig().getString("hub.spawn.world");
		if(world == null || world.length() == 0) {
			return false;
		}
		return true;
	}
	
	public Location getHubLocation() {
		Location loc = new Location(
				SakuraNetwork.getInstance().getServer().getWorld(SakuraNetwork.getInstance().getConfig().getString("hub.spawn.world")),
				SakuraNetwork.getInstance().getConfig().getDouble("hub.spawn.x"),
				SakuraNetwork.getInstance().getConfig().getDouble("hub.spawn.y"),
				SakuraNetwork.getInstance().getConfig().getDouble("hub.spawn.z"),
				(float) SakuraNetwork.getInstance().getConfig().getDouble("hub.spawn.yaw"),
				(float) SakuraNetwork.getInstance().getConfig().getDouble("hub.spawn.pitch")
				);
		return loc;
	}
	
	public void setupHub() {
		if(isHubSetup()) {
		this.hub = new Hub(getHubLocation());
		//Log in the console
		SakuraNetwork.getInstance().getLogger().info("Hub has been setup correctly.");
		} else {
			SakuraNetwork.getInstance().getLogger().warning("Hub needs to be setup. Use /hub sethub to set the location.");
		}
	}
	
	public Hub getHub() {
		return this.hub;
	}
	
	public void joinHub(Player player) {
		//Add player to hub players
		getHub().addPlayer(player);
		
		//Setup player inventory
		setupHubInv(player);
		
		//Teleport player to hub
		teleportPlayerToHub(player);
		
		//Set the player prefix
		setupHubPrefix(player);
		
		//Update visible players
		updateVisiblePlayers(player);
		
		//Show hub scoreboard
		HubScoreboard.getInstance().cacheData(player);
		HubScoreboard.getInstance().showHubScoreboard(player, "Loading...");
	}
	
	public void teleportPlayerToHub(Player player) {
		player.teleport(getHubLocation());
	}
	
	public void setupHubInv(Player player) {
		player.getInventory().clear();
		
		//Set the items
		player.getInventory().setItem(0, createItem(ChatColor.AQUA+""+ChatColor.BOLD+"Quick Navigate", Material.SLIME_BALL, ChatColor.YELLOW+"--------------------", ChatColor.GRAY+"Shortcut to your favorite games.", ChatColor.YELLOW+"--------------------"));
		player.getInventory().setItem(2, createItem(ChatColor.GREEN+""+ChatColor.BOLD+"Hub Shop", Material.DIAMOND, ChatColor.YELLOW+"--------------------", ChatColor.GRAY+"Buy some awesome stuff today!", ChatColor.YELLOW+"--------------------"));
		player.getInventory().setItem(4, createItem(ChatColor.GOLD+""+ChatColor.BOLD+"Hub Settings", Material.REDSTONE_COMPARATOR, ChatColor.YELLOW+"--------------------", ChatColor.GRAY+"Configure the hub settings.", ChatColor.YELLOW+"--------------------"));
	}
	
	public void setupHubPrefix(Player player) {
		String rank = Ranks.getInstance().getRank(player);
		String t = "";
		
		switch(rank) {
			case "normal":
				t = player.getName();
			break;
			case "buildteam":
				t = ChatColor.YELLOW+""+ChatColor.BOLD+""+player.getName();
			break;
			case "mod":
				t = ChatColor.BLUE+""+ChatColor.BOLD+""+player.getName();
			break;
			case "admin":
				t = ChatColor.RED+""+ChatColor.BOLD+""+player.getName();
			break;
			case "sakuramember":
				t = ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+""+player.getName();
			break;
			default:
				t = player.getName();
			break;
		}
		player.setPlayerListName(t);
	}
	
	public boolean isPlayerInHub(Player player) {
		if(getHub().getPlayer(player) != null) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public void updateVisiblePlayers(Player player) {
		//Loop to hide hub players for others
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(!isPlayerInHub(p)) {
				p.hidePlayer(player);
			}
		}
		
		//Loop
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(isPlayerInHub(p)) {
				player.hidePlayer(p);
			}
		}
	}
	
	public ItemStack createItem(String name, Material m, String... lore) {
		ItemStack i = new ItemStack(m);
		ItemMeta im = i.getItemMeta();
		
		im.setDisplayName(name);
		
		//Lore
		List<String> l = new ArrayList<String>();
				
		for(String lr: lore) {
			l.add(lr);
		}
		
		im.setLore(l);
		
		//Set item Meta
		i.setItemMeta(im);
		
		return i;
	}
}
