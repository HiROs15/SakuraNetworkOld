package dev.sakura.Economy.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dev.sakura.Economy.Eco;

public class EcoEvents implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Eco.getInstance().setupPlayerEco(event.getPlayer());
	}
}
