package dev.sakura.Commands.HubCommands.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import dev.sakura.Commands.HubCommands.HubCommandInfo;
import dev.sakura.Commands.HubCommands.HubPluginCommand;
import dev.sakura.Hub.HubManager;

@HubCommandInfo(command="hub")
public class HubCommand extends HubPluginCommand {
	@Override
	public void onCommand(Player player, String[] args) {
		if(args.length == 0) {
			HubManager.getInstance().joinHub(player);
			return;
		}
		player.sendMessage(ChatColor.RED+"HUB> "+ChatColor.GRAY+"Please type /hub only.");
		return;
	}
}
