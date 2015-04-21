package me.virustotal.factionsreloaded.commands;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.Faction;
import me.virustotal.factionsreloaded.utils.FPlayerUtil;
import me.virustotal.factionsreloaded.utils.FactionUtil;

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
		FactionsReloaded plugin = FactionsReloaded.get();
		
		if(fac == null)
		{
			player.sendMessage(ConfigHandler.fJoinFactionDoesNotExist.replace("{faction}", arg));
			return true;
		}
		else if(fac.getOpen())
		{
			player.sendMessage(ConfigHandler.fJoinSuccess.replace("{faction}", fac.getName()));
			for(Faction f : plugin.factions)
			{
				if(f.equals(fac))
				{
					f.getMembers().add(fPlayer.getUUID().toString());
					//save faction members to disk
				}
			}
			return true;
		}
		else if(!fac.getOpen() && FactionUtil.hasInvite(fac, fPlayer))
		{
			player.sendMessage(ConfigHandler.fJoinSuccess.replace("{faction}", fac.getName()));
			for(Faction f : plugin.factions)
			{
				if(f.equals(fac))
				{
					f.getMembers().add(fPlayer.getUUID().toString());
					//save faction members to disk
				}
			}
			return true;
		}
		
		player.sendMessage(ConfigHandler.fJoinNotSuccesfulClosed.replace("{faction}", fac.getName()));
		return true;
	}

}
