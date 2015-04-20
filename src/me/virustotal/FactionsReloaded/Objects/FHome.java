package me.virustotal.FactionsReloaded.Objects;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.potion.PotionEffect;

public class FHome {
	
	private Faction fac;
	private Location loc;
	private List<PotionEffect> effects;
	
	public FHome(Faction fac,Location loc,List<PotionEffect> effects)
	{
		this.fac = fac;
		this.loc = loc;
		this.effects = effects;
	}
	
	public Faction getFaction()
	{
		return this.fac;
	}
	
	public Location getLocation()
	{
		return this.loc;
	}
	
	public List<PotionEffect> getEffects()
	{
		return this.effects;
	}

}
