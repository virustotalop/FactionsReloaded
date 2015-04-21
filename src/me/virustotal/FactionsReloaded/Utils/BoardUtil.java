package me.virustotal.factionsreloaded.utils;

import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.objects.Board;

import java.util.ArrayList;



public class BoardUtil {
	
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
