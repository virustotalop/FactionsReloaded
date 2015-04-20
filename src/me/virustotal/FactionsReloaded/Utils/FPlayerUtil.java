package me.virustotal.FactionsReloaded.Utils;

import org.bukkit.entity.Player;

import me.virustotal.FactionsReloaded.FactionsReloaded;
import me.virustotal.FactionsReloaded.Objects.FPlayer;

public class FPlayerUtil {
	
	public static FPlayer getFPlayer(Player player)
	{
		String pName = player.getName();
		FactionsReloaded plugin = FactionsReloaded.get();
		return plugin.fPlayerCache.get(pName);
	}

}
