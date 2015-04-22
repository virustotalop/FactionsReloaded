package me.virustotal.factionsreloaded.commands;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.objects.FPlayer;

import org.bukkit.entity.Player;

public class FInvite {
	
	public static boolean doCommand(Player player)
	{
		FPlayer fPlayer = FPlayer.getFPlayer(player);
		if(fPlayer.getFaction().equals("none"))
		{
			player.sendMessage(ConfigHandler.fInviteNoFaction);
			return true;
		}
		player.sendMessage(ConfigHandler.fInviteNoArgs);
		return true;
	}
	
	public static boolean doCommandWithArgs(Player player, String arg)
	{
		FPlayer fPlayer = FPlayer.getFPlayer(player);
		if(fPlayer.getFaction().equals("none"))
		{
			player.sendMessage(ConfigHandler.fInviteNoFaction);
			return true;
		}
		//implementation for faction invites
		return true;
	}

}
