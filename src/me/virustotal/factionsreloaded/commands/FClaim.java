package me.virustotal.factionsreloaded.commands;

import me.virustotal.factionsreloaded.ConfigHandler;
import me.virustotal.factionsreloaded.objects.FPlayer;
import me.virustotal.factionsreloaded.objects.Faction;
import me.virustotal.factionsreloaded.utils.FactionUtil;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;

public class FClaim {
	
	public static boolean doCommand(Player player)
	{
		Faction fac = FactionUtil.getFactionByName(FPlayer.getFPlayer(player).getFaction());
		if(fac.getName().equals("none"))
		{
			player.sendMessage(ConfigHandler.cannotClaimNoFaction);
			return true;
		}
		
		Chunk chunk = player.getLocation().getChunk();
		int x = chunk.getX();
		int z = chunk.getZ();
		String world = chunk.getWorld().getName();
		
		if(FactionUtil.canClaim(fac, world, x, z))
		{
			player.sendMessage(ConfigHandler.landClaimed);
			FactionUtil.claim(fac, chunk);
			return true;
		}
		else
		{
			//if unable to the reason why needs to be given
			player.sendMessage("");
			return true;
		}
		
	}

}
