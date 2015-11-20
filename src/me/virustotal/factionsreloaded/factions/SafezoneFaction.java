package me.virustotal.factionsreloaded.factions;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.ChatColor;

import me.virustotal.factionsreloaded.objects.Faction;

public class SafezoneFaction extends Faction {

	public SafezoneFaction() 
	{
		//To be configurable
		super("safezone", ChatColor.GOLD + "[Safezone]" , ChatColor.GOLD + "Safezone", 0, 0, false, UUID.randomUUID(), new ArrayList<UUID>(), new ArrayList<UUID>(), true);
	}

}
