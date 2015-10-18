package me.virustotal.factionsreloaded.factions;

import java.util.ArrayList;
import java.util.UUID;

import me.virustotal.factionsreloaded.objects.Faction;

public class SafezoneFaction extends Faction {

	public SafezoneFaction(String name, String tag, int power, int land,boolean open, UUID admin,ArrayList<UUID> mods, ArrayList<UUID> members) 
	{
		super(name, tag, power, land, open, admin, mods, members);
	}

}
