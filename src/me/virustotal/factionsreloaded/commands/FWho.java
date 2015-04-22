package me.virustotal.factionsreloaded.commands;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.FactionsReloaded;

import org.bukkit.entity.Player;

public class FWho {
	
	public static boolean doCommand(Player player)
	{
		FactionsReloaded plugin = FactionsReloaded.get();
		player.sendMessage(plugin.config.fWhoNoArgs);
		return true;
	}
	
	public static boolean doCommandWithArgs(Player player, String arg)
	{
		//check to see if player exists
		//if they do send info such as power, faction etc.
		return true;
	}

}
