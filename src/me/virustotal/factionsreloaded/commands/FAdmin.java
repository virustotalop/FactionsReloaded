package me.virustotal.factionsreloaded.commands;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.Faction;
import me.virustotal.factionsreloaded.utils.FactionUtil;

import org.bukkit.entity.Player;

public class FAdmin {
	
	public static boolean doCommand(Player player)
	{
		FPlayer fPlayer = FPlayer.getFPlayer(player);
		if(fPlayer.getFaction().equals("none"))
		{
			player.sendMessage(ConfigHandler.fAdminNoFaction);
			return true;
		}
		player.sendMessage(ConfigHandler.fAdminNoArgs);
		return true;
	}
	
	public static boolean doCommandWithArgs(Player player, String arg)
	{
		FPlayer fPlayer = FPlayer.getFPlayer(player);
		Faction fac = FactionUtil.getFactionByName(fPlayer.getFaction());
		
		if(fac.getMembers().contains(player.getName()))
		{
			
		}
		return true;
	}

}
