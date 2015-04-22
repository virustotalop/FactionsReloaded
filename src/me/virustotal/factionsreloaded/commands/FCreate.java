package me.virustotal.factionsreloaded.commands;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.Faction;

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
		FPlayer fPlayer = FPlayer.getFPlayer(player);
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
