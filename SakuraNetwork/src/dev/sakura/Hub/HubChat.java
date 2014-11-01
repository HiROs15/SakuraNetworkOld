package dev.sakura.Hub;

import java.util.ArrayList;

import dev.sakura.Ranks.Ranks;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;

public class HubChat {
	private static HubChat inst = new HubChat();
	private HubChat() {}
	
	public static HubChat getInstance() {
		return inst;
	}
	
	public void sendHubMessage(Player player, String msg) {
		String rank = Ranks.getInstance().getRank(player);
		ArrayList<SakuraHubPlayer> target = HubManager.getInstance().getHub().getPlayers();
		String prefix = "";
		switch(rank) {
		case "normal":
			prefix = ChatColor.DARK_GRAY+""+player.getName()+": "+ChatColor.WHITE;
		break;
		case "buildteam":
			prefix = ChatColor.YELLOW+""+ChatColor.BOLD+"BUILDTEAM "+ChatColor.RESET+""+ChatColor.DARK_GRAY+""+player.getName()+": "+ChatColor.WHITE;
		break;
		case "mod":
			prefix = ChatColor.BLUE+""+ChatColor.BOLD+"MOD "+ChatColor.RESET+""+ChatColor.DARK_GRAY+""+player.getName()+": "+ChatColor.WHITE;
		break;
		case "admin":
			prefix = ChatColor.RED+""+ChatColor.BOLD+"ADMIN "+ChatColor.RESET+""+ChatColor.DARK_GRAY+""+player.getName()+": "+ChatColor.WHITE;
		break;
		case "sakuramember":
			prefix = ChatColor.LIGHT_PURPLE+""+ChatColor.BOLD+"SAKURA MEMBER "+ChatColor.RESET+""+ChatColor.DARK_GRAY+""+player.getName()+": "+ChatColor.WHITE;
		break;
		}
		
		for(SakuraHubPlayer tp: target) {
			tp.getPlayer().sendMessage(prefix+msg);
		}
	}
}
