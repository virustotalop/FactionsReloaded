package me.virustotal.FactionsReloaded.Utils;

import me.virustotal.FactionsReloaded.FactionsReloaded;
import me.virustotal.FactionsReloaded.Objects.Board;

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
