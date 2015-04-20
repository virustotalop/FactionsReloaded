package me.virustotal.FactionsReloaded.Utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;

import me.virustotal.FactionsReloaded.FactionsReloaded;
import me.virustotal.FactionsReloaded.Objects.FPlayer;
import me.virustotal.FactionsReloaded.Objects.Faction;

public class FactionUtil {

	public static boolean canClaim(Faction claimingFaction, String world,int x, int z)
	{	
		String string = BoardUtil.getFaction(world, x, z);
	
		if(string.equals("none"))
		{
			if(claimingFaction.getPower() > claimingFaction.getLand())
				return true;
		}
		else
		{
			Faction fac = FactionUtil.getFactionByName(string);
			return (fac.getPower() < fac.getLand() && claimingFaction.getPower() > claimingFaction.getLand());
		}
		return false;
		
	}
	
	public static Faction getFactionByName(String name)
	{
		ArrayList<Faction> facs = FactionsReloaded.get().factions;
		for(Faction fac : facs)
		{
			if(fac.getName().equals(name))
			return fac;
		}
		return null;
	}
	
	public static void claim(Faction claimingFaction,Chunk chunk)
	{
		if(FactionUtil.canClaim(claimingFaction,chunk.getWorld().getName(), chunk.getX(), chunk.getZ()))
		{
			//do stuff with board
		}
		else
		{
			//sendMessage
		}
	}
	
	public static boolean canBuild(FPlayer fPlayer,int x,int z)
	{
		String world = Bukkit.getPlayer(fPlayer.getUUID()).getLocation().getWorld().getName();
		return BoardUtil.getFaction(world, x, z).equals(fPlayer.getFaction()) || BoardUtil.getFaction(world, x, z).equals("none");
	}
	
}
