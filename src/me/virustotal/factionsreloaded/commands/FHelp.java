package me.virustotal.factionsreloaded.commands;

import java.util.List;

import me.virustotal.factionsreloaded.ConfigHandler;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.entity.Player;

public class FHelp {

	public static boolean doCommand(Player player)
	{
		List<String> list = ConfigHandler.helpMenu;
		int size = list.size();
		int perPage = ConfigHandler.commandsPerPage;

		//send top of help menu
		for(String string : ConfigHandler.topOfMenu)
		{
			player.sendMessage(string);
		}
		
		if(perPage > size) //iterate through list, make sure not to go past size
		{
			for(int i = 0; i < perPage; i++)
			{
				player.sendMessage(list.get(i));
			}
		}
		else 
		{
			for(int i = 0; i < size; i++)
			{
				player.sendMessage(list.get(i));
			}

		}
		return true;
	}
	public static boolean doCommandWithArg(Player player, String arg)
	{
		
		if(!NumberUtils.isNumber(arg))
		{
			//needs to be a number, invalid args
			return true;
		}
		
		List<String> list = ConfigHandler.helpMenu;
		int size = list.size();
		int perPage = ConfigHandler.commandsPerPage;
		int page = Integer.parseInt(arg);
		
		return true;
	}
	
}
