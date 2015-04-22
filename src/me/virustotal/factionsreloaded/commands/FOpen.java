package me.virustotal.factionsreloaded.commands;

import org.bukkit.entity.Player;

import me.virustotal.factionsreloaded.objects.FPlayer;

public class FOpen {
	
	public static boolean doCommand(Player player)
	{
		
		FPlayer fPlayer = FPlayer.getFPlayer(player);
		if(fPlayer.getFaction().equals("none"))
		{
			//no faction
			return true;
		}
		//f open, send message
		return true;
		
	}

}
