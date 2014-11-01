package dev.sakura.Ranks.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dev.sakura.Ranks.Ranks;

public class RanksEvents implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		Ranks.getInstance().setupPlayerRankConfig(player);
	}
}
