package me.virustotal.factionsreloaded.objects;

import java.util.ArrayList;

import me.virustotal.factionsreloaded.FactionsReloaded;

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
	
	public static String getFaction(String world, int x, int z)
	{
		ArrayList<Board> boards = FactionsReloaded.get().boards;
		for(Board board : boards)
		{
			if(board.getX() == x && board.getZ() == z && board.getWorld().equals(world))
				return board.getFaction();
		}
		return "none";
	}

}
