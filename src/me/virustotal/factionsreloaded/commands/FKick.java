package me.virustotal.factionsreloaded.commands;

import me.virustotal.factionsreloaded.objects.FPlayer;

import org.bukkit.entity.Player;

public class FKick {
	
	public static boolean doCommand(Player player)
	{
		FPlayer fPlayer = FPlayer.getFPlayer(player);
		if(fPlayer.getFaction().equals("none"))
		{
			//send message no faction
			return true;
		}
		//send correct args message
		
		return true;
	}

}
