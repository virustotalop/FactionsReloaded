package me.virustotal.FactionsReloaded.Commands;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Objects.Faction;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;
import me.virustotal.FactionsReloaded.Utils.FactionUtil;

import org.bukkit.entity.Player;

public class FJoin {
	
	public static boolean doCommand(Player player)
	{
		player.sendMessage(ConfigHandler.fJoinNoArgs);
		return true;
	}
	
	public static boolean doCommandWithArgs(Player player, String arg)
	{
		Faction fac = FactionUtil.getFactionByName(arg);
		FPlayer fPlayer = FPlayerUtil.getFPlayer(player);
		
		if(fac == null)
		{
			player.sendMessage(ConfigHandler.fJoinFactionDoesNotExist.replace("{faction}", arg));
			return true;
		}
		else if(fac.getOpen())
		{
			player.sendMessage(ConfigHandler.fJoinSuccess.replace("{faction}", fac.getName()));
			//join faction
			return true;
		}
		else if(!fac.getOpen() && FactionUtil.hasInvite(fac, fPlayer))
		{
			player.sendMessage(ConfigHandler.fJoinSuccess.replace("{faction}", fac.getName()));
			//join faction
			return true;
		}
		
		player.sendMessage(ConfigHandler.fJoinNotSuccesfulClosed.replace("{faction}", fac.getName()));
		return true;
	}

}
