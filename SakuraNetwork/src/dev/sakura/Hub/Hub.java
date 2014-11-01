package dev.sakura.Hub;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Hub {
	public ArrayList<SakuraHubPlayer> hubPlayers = new ArrayList<SakuraHubPlayer>();
	
	private Location hubloc;
	
	public Hub(Location hubloc) {
		this.hubloc = hubloc;
	}
	
	public Location getLocation() {
		return this.hubloc;
	}
	
	public void addPlayer(Player player) {
		hubPlayers.add(new SakuraHubPlayer(player));
	}
	
	public void removePlayer(Player player) {
		SakuraHubPlayer shp = getPlayer(player);
		hubPlayers.remove(shp);
	}
	
	public SakuraHubPlayer getPlayer(Player player) {
		for(SakuraHubPlayer p : hubPlayers) {
			if(p.getName().equalsIgnoreCase(player.getName())) {
				return p;
			}
		}
		return null;
	}
	
	public ArrayList<SakuraHubPlayer> getPlayers() {
		return hubPlayers;
	}
}
