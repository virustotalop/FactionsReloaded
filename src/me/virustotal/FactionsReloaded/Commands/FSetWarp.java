package me.virustotal.FactionsReloaded.Commands;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;

import org.bukkit.entity.Player;

public class FSetWarp {

	public static boolean doCommand(Player player)
	{
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		if(fPlayer.getFaction().equals("none"))
		{
			player.sendMessage(ConfigHandler.fSetWarpNoFaction);
			return true;
		}
		
		player.sendMessage(ConfigHandler.fSetwarpNoArgs);
		return true;
	}
	
	public static boolean doCommandWithArgs(Player player, String arg)
	{
		
		return true;
	}
	
}
