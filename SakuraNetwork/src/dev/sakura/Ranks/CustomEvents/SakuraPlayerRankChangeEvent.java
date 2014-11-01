package dev.sakura.Ranks.CustomEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SakuraPlayerRankChangeEvent extends Event implements Cancellable {
	private boolean cancelled;
	private Player target;
	private Player player;
	
	public SakuraPlayerRankChangeEvent(Player target, Player player) {
		this.cancelled = false;
		this.target = target;
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Player getTarget() {
		return this.target;
	}
	
	public boolean isCancelled() {
		return this.cancelled;
	}
	
	public void setCancelled(boolean bln) {
		this.cancelled = bln;
	}

	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
