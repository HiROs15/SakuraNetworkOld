package dev.sakura.Ping.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import dev.sakura.SakuraNetwork;

public class PingEvents implements Listener {
	@EventHandler
	public void onPlayPingServer(ServerListPingEvent event) {
		if(SakuraNetwork.getInstance().getConfig().getBoolean("ping.setup")) {
			event.setMaxPlayers(SakuraNetwork.getInstance().getConfig().getInt("ping.slots"));
			event.setMotd(SakuraNetwork.getInstance().getConfig().getString("ping.motd"));
		}
	}
}
