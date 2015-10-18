package me.virustotal.factionsreloaded.objects;

import java.util.ArrayList;

public class Board {
	
	private int x;
	private int z;
	private String world;
	private String faction;
	public static ArrayList<Board> boards = new ArrayList<Board>();
	
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
	
	public Faction getFaction()
	{
		return Faction.getFactionByName(this.faction);
	}
	
	public static Faction getFaction(String world, int x, int z)
	{
		ArrayList<Board> boards = Board.boards;
		for(Board board : boards)
		{
			if(board.getX() == x && board.getZ() == z && board.getWorld().equals(world))
				return board.getFaction();
		}
		return null;
	}

}
