package me.virustotal.FactionsReloaded.Commands;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.FactionsReloaded;

import org.bukkit.entity.Player;

public class FSpy {
	
	public static boolean doCommand(Player player)
	{
		if(player.hasPermission("factions.spy"))
		{
			FactionsReloaded plugin = FactionsReloaded.get();
			if(plugin.spyPlayers.contains(player.getName()))
			{
				player.sendMessage(ConfigHandler.fSpyOff);
				plugin.spyPlayers.remove(player.getName());
				return true;
			}
			else
			{
			player.sendMessage(ConfigHandler.fSpyOn);
			plugin.spyPlayers.add(player.getName());
			return true;
				
			}
			//faction chat implementation to chat listener will need to be added later
		}
		else
		{
			player.sendMessage(ConfigHandler.fSpyNoPermission);
			return true;
		}
	}

}
