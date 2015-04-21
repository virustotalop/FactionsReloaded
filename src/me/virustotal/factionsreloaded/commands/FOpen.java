package me.virustotal.factionsreloaded.commands;

import org.bukkit.entity.Player;

import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.utils.FPlayerUtil;

public class FOpen {
	
	public static boolean doCommand(Player player)
	{
		
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		if(fPlayer.getFaction().equals("none"))
		{
			//no faction
			return true;
		}
		//f open, send message
		return true;
		
	}

}
