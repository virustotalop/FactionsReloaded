package me.virustotal.factionsreloaded.objects;

import java.util.ArrayList;

import me.virustotal.factionsreloaded.FactionsReloaded;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;

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
	
	public static boolean canClaim(Faction claimingFaction, String world,int x, int z)
	{	
		String string = Board.getFaction(world, x, z);
	
		if(string.equals("none"))
		{
			if(claimingFaction.getPower() > claimingFaction.getLand())
				return true;
		}
		else
		{
			Faction fac = Faction.getFactionByName(string);
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
		if(Faction.canClaim(claimingFaction,chunk.getWorld().getName(), chunk.getX(), chunk.getZ()))
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
		String world = Bukkit.getPlayer(fPlayer.getUUID()).getLocation().getWorld().getName(); //or if player has bypass
		FactionsReloaded plugin = FactionsReloaded.get();
		String pName = Bukkit.getPlayer(fPlayer.getUUID()).getName();
		return Board.getFaction(world, x, z).equals(fPlayer.getFaction()) || Board.getFaction(world, x, z).equals("none") || plugin.bypassedPlayers.contains(pName);
	}
	
	
	
	public static void saveFactionToFile(Faction fac)
	{
		
	}
	
	public static boolean hasInvite(Faction fac, FPlayer fPlayer)
	{
		return true;
	}
	
	public static String getGroup(FPlayer fPlayer)
	{
		Faction fac = Faction.getFactionByName(fPlayer.getFaction());
		Player player = Bukkit.getPlayer(fPlayer.getUUID());
		if(fac.getAdmin().equals(player.getName()))
			return "admin";
		if(fac.getMods().contains(player.getName()))
			return "mod";
		
		return "none";
	}
	
}
