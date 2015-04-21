package me.virustotal.factionsreloaded.objects;

import org.bukkit.Location;

public class FWarp {
	
	private Faction fac;
	private Location loc;
	private String name;
	private String group;
	private String password;
	
	public FWarp(Faction fac, Location loc, String name, String group, String password)
	{
		this.fac = fac;
		this.loc = loc;
		this.name = name;
		this.group = group;
		this.password = password;
	}
	
	public Faction getFaction()
	{
		return this.fac;
	}
	
	public Location getLocation()
	{
		return this.loc;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getGroup()
	{
		return this.group;
	}
	
	public String getPassword()
	{
		return this.password;
	}

}