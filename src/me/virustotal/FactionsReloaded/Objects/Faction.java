package me.virustotal.FactionsReloaded.Objects;

import java.util.ArrayList;

public class Faction {

	private String name;
	private String tag;
	private int power;
	private int land;
	private ArrayList<String> members;

	public Faction(String name, String tag, int power, int land, ArrayList<String> members)
	{
		this.name = name;
		this.tag = tag;
		this.power = power;
		this.land = land;
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
	
	public ArrayList<String> getMembers()
	{
		return this.members;
	}
	
}
