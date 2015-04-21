package me.virustotal.FactionsReloaded.Commands;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.FactionsReloaded;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Objects.Faction;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class FCreate {
	
	public static boolean doCommand(Player player)
	{
		player.sendMessage(ConfigHandler.fCreateNoArgs);
		return true;
	}
	
	public static boolean doCommandWithArgs(Player player, String arg)
	{
		FactionsReloaded plugin = FactionsReloaded.get();
		String stripped = ChatColor.stripColor(arg);
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		if(!fPlayer.getFaction().equals("none"))
		{
			player.sendMessage(ConfigHandler.fCreateAlreadyInFaction);
			return true;
		}
		if(stripped.equalsIgnoreCase("none")) //do not want the name "none" used as it is a default faction name
		{
			player.sendMessage(ConfigHandler.fCreateInvalidName);
			return true;
		}
		for(Faction fac : plugin.factions)
		{
			if(stripped.equals(fac.getName()))
			{
				player.sendMessage(ConfigHandler.fTagInUse);
				return true;
			}
		}
		//else create faction
		
		return true;
	}

}
