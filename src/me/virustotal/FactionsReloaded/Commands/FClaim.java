package me.virustotal.FactionsReloaded.Commands;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.Objects.Faction;
import me.virustotal.FactionsReloaded.Utils.FPlayerUtil;
import me.virustotal.FactionsReloaded.Utils.FactionUtil;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;

public class FClaim {
	
	public static boolean doCommand(Player player)
	{
		Faction fac = FactionUtil.getFactionByName(FPlayerUtil.getFPlayer(player).getFaction());
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
			FactionUtil.claim(fac, chunk);
			return true;
		}
		return true;
	}

}
