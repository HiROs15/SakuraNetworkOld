package dev.sakura.Commands.HubCommands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.sakura.SakuraNetwork;
import dev.sakura.Commands.HubCommands.Commands.HubCommand;
import dev.sakura.Commands.HubCommands.Commands.HubSetHubCommand;

public class HubCommandManager implements CommandExecutor {
	public ArrayList<HubPluginCommand> cmds = new ArrayList<HubPluginCommand>();
	
	public HubCommandManager() {
		cmds.add(new HubSetHubCommand());
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			SakuraNetwork.getInstance().getLogger().warning("Please do not use commands through the console.");
			return true;
		}
		
		Player player = (Player) sender;
		//String rank = Ranks.getInstance().getRank(player);
		
		if(cmd.getName().equalsIgnoreCase("hub")) {
			if(args.length == 0) {
				HubCommand hc = new HubCommand();
				hc.onCommand(player, args);
				return true;
			}
			
			for(HubPluginCommand command : cmds) {
				HubCommandInfo info = command.getClass().getAnnotation(HubCommandInfo.class);
				if(info.command().equalsIgnoreCase(args[0])) {
					command.onCommand(player, args);
					return true;
				}
			}
			player.sendMessage(ChatColor.RED+"SYSTEM> "+ChatColor.GRAY+"This command does not exist.");
			return true;
		}
		return true;
	}
}
