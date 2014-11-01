package dev.sakura.Commands.RanksCommands.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import dev.sakura.Commands.RanksCommands.RanksCommandInfo;
import dev.sakura.Commands.RanksCommands.RanksPluginCommand;
import dev.sakura.Ranks.Ranks;

@RanksCommandInfo(command="rank")
public class RanksCommand extends RanksPluginCommand {
	@Override
	public void onCommand(Player player, String[] args) {
		if(Ranks.getInstance().getRank(player).equals("normal") || Ranks.getInstance().getRank(player).equals("buildteam") || Ranks.getInstance().getRank(player).equals("mod")) {
			player.sendMessage(ChatColor.RED+"SYSTEM> "+ChatColor.GRAY+"You do not have permission to do this.");
			return;
		}
		//Send the menu
		
		player.sendMessage(ChatColor.YELLOW+"----------"+ChatColor.GOLD+""+ChatColor.BOLD+"Rank Commands"+ChatColor.RESET+""+ChatColor.YELLOW+"----------");
		player.sendMessage(ChatColor.BLUE+"/rank setrank <Player> <String rank>");
		player.sendMessage(ChatColor.BLUE+"/rank reload");
		return;
	}
}
