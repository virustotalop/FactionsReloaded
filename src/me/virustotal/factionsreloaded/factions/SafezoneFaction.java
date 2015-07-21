package me.virustotal.factionsreloaded.factions;

import java.util.ArrayList;

import me.virustotal.factionsreloaded.objects.Faction;
import me.virustotal.factionsreloaded.objects.FactionEnum;

public class SafezoneFaction extends Faction {

	public SafezoneFaction(String name, String tag, int power, int land,boolean open, FactionEnum factionEnum, String admin,ArrayList<String> mods, ArrayList<String> members) {
		super(name, tag, power, land, open, factionEnum, admin, mods, members);
	}

}
