package me.virustotal.factionsreloaded.commands;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.utils.FPlayerUtil;

import org.bukkit.entity.Player;

public class FDisband {

	public static boolean doCommand(Player player)
	{
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		if(fPlayer.getFaction().equals("none"))
		{
			player.sendMessage(ConfigHandler.fDisbandNoFaction);
			return true;
		}
		//disband faction, send message, check to see if user is faction admin
		player.sendMessage(ConfigHandler.fDisbandYourFaction);
		return true;
	}
	
	public static boolean doCommandWithArgs(Player player, String arg)
	{
		//to be implemented, used be server administrators
		player.sendMessage(ConfigHandler.fDisbandOtherFaction);
		return true;
	}

}
