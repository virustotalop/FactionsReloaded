package me.virustotal.FactionsReloaded.Objects;

import java.util.ArrayList;

public class Faction {

	private String name;
	private String tag;
	private int power;
	private int land;
	private boolean open;
	private String admin;
	private ArrayList<String> mods;
	private ArrayList<String> members;

	public Faction(String name, String tag, int power, int land,boolean open, String admin, ArrayList<String> mods, ArrayList<String> members)
	{
		this.name = name;
		this.tag = tag;
		this.power = power;
		this.land = land;
		this.open = open;
		this.admin = admin;
		this.mods = mods;
		this.members = members;
	}

	public String getName()
	{
		return this.name;
	}

	public String getTag()
	{
		return this.tag;
	}

	public int getPower()
	{
		return this.power;
	}
	
	public int getLand()
	{
	    return this.land;
	}
	
	public boolean getOpen()
	{
		return this.open;
	}
	
	public String getAdmin()
	{
		return this.admin;
	}
	
	public ArrayList<String> getMods()
	{
		return this.mods;
	}
	
	public ArrayList<String> getMembers()
	{
		return this.members;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setTag(String tag)
	{
		this.tag = tag;
	}
	
}
