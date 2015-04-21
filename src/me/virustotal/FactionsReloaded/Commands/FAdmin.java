package me.virustotal.FactionsReloaded.Commands;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Objects.Faction;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;
import me.virustotal.FactionsReloaded.Utils.FactionUtil;

import org.bukkit.entity.Player;

public class FAdmin {
	
	public static boolean doCommand(Player player)
	{
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
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
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		Faction fac = FactionUtil.getFactionByName(fPlayer.getFaction());
		
		if(fac.getMembers().contains(player.getName()))
		{
			
		}
		return true;
	}

}
