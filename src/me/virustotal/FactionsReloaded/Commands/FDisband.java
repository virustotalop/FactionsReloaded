package me.virustotal.FactionsReloaded.Commands;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;

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
