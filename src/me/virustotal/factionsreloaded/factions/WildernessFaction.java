package me.virustotal.factionsreloaded.factions;

import java.util.ArrayList;
import java.util.UUID;

import me.virustotal.factionsreloaded.objects.Faction;

import org.bukkit.ChatColor;

public class WildernessFaction extends Faction {
	
	public WildernessFaction()
	{
		//To be configurable
		super("wilderness", ChatColor.GREEN + "[Wilderness]" , ChatColor.GREEN + "Wilderness faction", 0, 0, false, UUID.randomUUID(), new ArrayList<UUID>(), new ArrayList<UUID>(), true);
	}

}
