package me.virustotal.FactionsReloaded.Utils;

import java.util.ArrayList;

import me.virustotal.FactionsReloaded.FactionsReloaded;
import me.virustotal.FactionsReloaded.Objects.Faction;

public class FactionUtil {

	public static boolean canClaim(Faction claimingFaction, int x, int z)
	{	
		String string = BoardUtil.getFaction(x, z);
	
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
	
	public static void claim(Faction claimingFaction,int x, int z)
	{
		if(FactionUtil.canClaim(claimingFaction, x, z))
		{
			//do stuff
		}
		else
		{
			
		}
	}
	
}
