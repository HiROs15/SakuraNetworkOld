package dev.sakura.Hub.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import dev.sakura.Hub.HubChat;
import dev.sakura.Hub.HubManager;

public class HubEvents implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		HubManager.getInstance().joinHub(player);
	}
	
	@EventHandler
	public void onPlayerBreakBock(BlockBreakEvent event) {
		if(HubManager.getInstance().isPlayerInHub(event.getPlayer())) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerPlaceBlock(BlockPlaceEvent event) {
		if(HubManager.getInstance().isPlayerInHub(event.getPlayer())) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent event) {
		if(HubManager.getInstance().isPlayerInHub(event.getPlayer())) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerMessWithInv(InventoryInteractEvent event) {
		if(HubManager.getInstance().isPlayerInHub((Player) event.getWhoClicked())) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		HubChat.getInstance().sendHubMessage(event.getPlayer(), event.getMessage());
		event.setCancelled(true);
	}
}
