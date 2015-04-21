package me.virustotal.factionsreloaded.commands;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.FactionsReloaded;

import org.bukkit.entity.Player;

public class FBypass {
	
	public static boolean doCommand(Player player)
	{
		if(player.hasPermission("factions.bypass"))
		{
			FactionsReloaded plugin = FactionsReloaded.get();
			if(plugin.bypassedPlayers.contains(player.getName()))
			{
				player.sendMessage(ConfigHandler.fBypassOff);
				plugin.bypassedPlayers.remove(player.getName());
			}
			else
			{
				player.sendMessage(ConfigHandler.fBypassOn);
				plugin.bypassedPlayers.add(player.getName());
			}
			return true;
		}
		
		player.sendMessage(ConfigHandler.fBypassNoPermission);
		return true;
	}
	
}
