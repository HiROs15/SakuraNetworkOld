package dev.sakura.Commands.RanksCommands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.sakura.SakuraNetwork;
import dev.sakura.Commands.RanksCommands.Commands.RanksCommand;
import dev.sakura.Commands.RanksCommands.Commands.RanksSetRankCommand;

public class RanksCommandManager implements CommandExecutor {
	public ArrayList<RanksPluginCommand> cmds = new ArrayList<RanksPluginCommand>();
	
	public RanksCommandManager() {
		cmds.add(new RanksSetRankCommand());
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			SakuraNetwork.getInstance().getLogger().warning("Please do not use any commands through the console.");
			return true;
		}
		
		Player player = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("rank")) {
			if(args.length == 0) {
				RanksCommand rankscommand = new RanksCommand();
				rankscommand.onCommand(player, args);
				return true;
			}
			for(RanksPluginCommand command : cmds) {
				RanksCommandInfo info = command.getClass().getAnnotation(RanksCommandInfo.class);
				if(info.command().equalsIgnoreCase(args[0])) {
					command.onCommand(player, args);
					return true;
				}
			}
			player.sendMessage(ChatColor.AQUA+"SYSTEM> "+ChatColor.GRAY+"That is not an existing command.");
			return true;
		}
		return true;
	}
}
