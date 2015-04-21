package me.virustotal.FactionsReloaded.Commands;

import me.virustotal.FactionsReloaded.ConfigHandler;

import org.bukkit.entity.Player;

public class FWho {
	
	public static boolean doCommand(Player player)
	{
		player.sendMessage(ConfigHandler.fWhoNoArgs);
		return true;
		
	}

}
