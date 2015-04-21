package me.virustotal.FactionsReloaded.Commands;

import me.virustotal.FactionsReloaded.ConfigHandler;

import org.bukkit.entity.Player;

public class FWho {
	
	public static boolean doCommand(Player player)
	{
		player.sendMessage(ConfigHandler.fWhoNoArgs);
		return true;
	}
	
	public static boolean doCommandWithArgs(Player player, String arg)
	{
		//check to see if player exists
		//if they do send info such as power, faction etc.
		return true;
	}

}
