package me.virustotal.FactionsReloaded.Commands;

import java.util.List;

import me.virustotal.FactionsReloaded.ConfigHandler;

import org.bukkit.entity.Player;

public class FHelp {

	public static boolean doCommand(Player player)
	{
		List<String> list = ConfigHandler.helpMenu;
		int size = list.size();
		int perPage = ConfigHandler.commandsPerPage;
		
		//iterate through list, make sure not to go past size
		
		return true;
	}
	public static boolean doCommandWithArg(Player player, String arg)
	{
		return true;
	}
	
}
