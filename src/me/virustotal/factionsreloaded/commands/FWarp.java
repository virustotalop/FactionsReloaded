package me.virustotal.factionsreloaded.commands;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.objects.Faction;
import me.virustotal.factionsreloaded.utils.FPlayerUtil;
import me.virustotal.factionsreloaded.utils.FactionUtil;

import org.bukkit.entity.Player;

public class FWarp {

	public static boolean doCommand(Player player)
	{
		player.sendMessage(ConfigHandler.fWarpNoArgs);
		return true;
	}
	
	public static boolean doCommandWithArgs(Player player, String arg)
	{
		Faction fac = FactionUtil.getFactionByName(FPlayerUtil.getFPlayer(player).getFaction());
		if(fac == null)
		{
			player.sendMessage(ConfigHandler.fWarpNoFaction);
			return true;
		}
		else if(fac.equals("none"))
		{
			player.sendMessage(ConfigHandler.fWarpNoFaction);
			return true;
		}
		//do warp handling    warp name - password if one
		return true;
	}
	
}
