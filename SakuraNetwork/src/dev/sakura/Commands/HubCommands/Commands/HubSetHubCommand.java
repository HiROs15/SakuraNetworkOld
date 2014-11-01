package dev.sakura.Commands.HubCommands.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import dev.sakura.SakuraNetwork;
import dev.sakura.Commands.HubCommands.HubCommandInfo;
import dev.sakura.Commands.HubCommands.HubPluginCommand;
import dev.sakura.Ranks.Ranks;

@HubCommandInfo(command="sethub")
public class HubSetHubCommand extends HubPluginCommand {
	@Override
	public void onCommand(Player player, String[] args) {
		String rank = Ranks.getInstance().getRank(player);
		if(rank.equals("normal") || rank.equals("buildteam") || rank.equals("mod")) {
			player.sendMessage(ChatColor.RED+"SYSTEM> "+ChatColor.GRAY+"You do not have permission to do this.");
			return;
		}
		
		Location loc = player.getLocation();
		FileConfiguration config = SakuraNetwork.getInstance().getConfig();
		
		config.set("hub.spawn.world", loc.getWorld().getName());
		config.set("hub.spawn.x", loc.getX());
		config.set("hub.spawn.y", loc.getY());
		config.set("hub.spawn.z", loc.getZ());
		config.set("hub.spawn.yaw", loc.getYaw());
		config.set("hub.spawn.pitch", loc.getPitch());
		SakuraNetwork.getInstance().saveConfig();

		player.sendMessage(ChatColor.RED+"HUB> "+ChatColor.GRAY+"Hub spawn location has been set.");
		return;
	}
}
