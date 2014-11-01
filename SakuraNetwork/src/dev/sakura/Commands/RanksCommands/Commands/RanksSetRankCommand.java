package dev.sakura.Commands.RanksCommands.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import dev.sakura.SakuraNetwork;
import dev.sakura.Commands.RanksCommands.RanksCommandInfo;
import dev.sakura.Commands.RanksCommands.RanksPluginCommand;
import dev.sakura.Ranks.Ranks;

@RanksCommandInfo(command="setrank")
public class RanksSetRankCommand extends RanksPluginCommand {
	@Override
	public void onCommand(Player player, String[] args) {
		String rank = Ranks.getInstance().getRank(player);
		if(rank.equals("normal") || rank.equals("buildteam") || rank.equals("mod")) {
			player.sendMessage(ChatColor.RED+"SYSTEM> "+ChatColor.GRAY+"You do not have permission to do this.");
			return;
		}
		
		//Promote the player
		if(args.length < 3) {
			player.sendMessage(ChatColor.RED+"RANKS> "+ChatColor.GRAY+"You are missing some attributes.");
			return;
		}
		
		Ranks.getInstance().setRank(SakuraNetwork.getInstance().getServer().getPlayer(args[1]), args[2]);
		
		player.sendMessage(ChatColor.RED+"RANKS> "+ChatColor.GRAY+"Player rank has been changed.");
		
		//Call event *SakuraPlayerRankChangeEvent*
		
		//SakuraNetwork.getInstance().getServer().getPluginManager().callEvent(new SakuraPlayerRankChangeEvent(SakuraNetwork.getInstance().getServer().getPlayer(args[1]), player));
	}
}
