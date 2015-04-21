package me.virustotal.factionsreloaded.utils;

import org.bukkit.entity.Player;

import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.objects.FPlayer;

public class FPlayerUtil {
	
	public static FPlayer getFPlayer(Player player)
	{
		String pName = player.getName();
		FactionsReloaded plugin = FactionsReloaded.get();
		return plugin.fPlayerCache.get(pName);
	}

}
