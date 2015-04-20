package me.virustotal.FactionsReloaded.Commands;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.Objects.Faction;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;
import me.virustotal.FactionsReloaded.Utils.FactionUtil;

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
		
		return true;
	}
	
}
