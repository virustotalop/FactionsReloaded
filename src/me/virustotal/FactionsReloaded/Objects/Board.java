package me.virustotal.FactionsReloaded.Objects;

public class Board {
	
	private int x;
	private int z;
	private String world;
	private String faction;
	
	public Board(int x, int z,String world, String faction)
	{
		this.x = x;
		this.z = z;
		this.world = world;
		this.faction = faction;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getZ()
	{
		return this.z;
	}
	
	public String getWorld()
	{
		return this.world;
	}
	
	public String getFaction()
	{
		return this.faction;
	}

}
