package me.virustotal.factionsreloaded.objects;

import java.util.ArrayList;
import java.util.UUID;



import me.virustotal.factionsreloaded.customevents.FactionClaimEvent;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;

public class Faction {

	public static ArrayList<Faction> factions = new ArrayList<Faction>();
	private String name;
	private String tag;
	private String description;
	private int power;
	private int land;
	private boolean open;
	private UUID admin;
	private ArrayList<UUID> mods;
	private ArrayList<UUID> members;
	private boolean pluginFaction;
	private FHome fHome;
	private ArrayList<FWarp> fWarps = new ArrayList<FWarp>();
	
	public Faction(String name, String tag, String description, int power, int land, boolean open, UUID admin, ArrayList<UUID> mods, ArrayList<UUID> members, boolean pluginFaction)
	{
		this.name = name;
		this.tag = tag;
		this.description = description;
		this.power = power;
		this.land = land;
		this.open = open;
		this.admin = admin;
		this.mods = mods;
		this.members = members;
		this.pluginFaction = pluginFaction;
	}

	public String getName()
	{
		return this.name;
	}

	public String getTag()
	{
		return this.tag;
	}
	
	public String getDescription()
	{
		return this.description;
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
	
	public UUID getAdmin()
	{
		return this.admin;
	}
	
	public ArrayList<UUID> getMods()
	{
		return this.mods;
	}
	
	public ArrayList<UUID> getMembers()
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

	public boolean isPluginFaction()
	{
		return this.pluginFaction;
	}
	
	public FHome getFHome()
	{
		return this.fHome;
	}
	
	public void setFHome(FHome fHome)
	{
		this.fHome = fHome;
	}
	
	public ArrayList<FWarp> getFWarps()
	{
		return this.fWarps;
	}
	
	public void setFWarps(ArrayList<FWarp> fWarps)
	{
		this.fWarps = fWarps;
	}
	
	public static boolean canClaim(Faction claimingFaction, String world,int x, int z)
	{	
		Faction fac = Board.getFaction(world, x, z);
	
		if(fac.getName().equals("none"))
		{
			if(claimingFaction.getPower() > claimingFaction.getLand())
				return true;
		}
		else
		{
			return (fac.getPower() < fac.getLand() && claimingFaction.getPower() > claimingFaction.getLand());
		}
		return false;
		
	}
	
	public static Faction getFactionByName(String name)
	{
		ArrayList<Faction> facs = factions;
		for(Faction fac : facs)
		{
			if(fac.getName().equals(name))
			return fac;
		}
		return null;
	}
	
	public static void claim(Faction claimingFaction,Chunk chunk)
	{
		Bukkit.getPluginManager().callEvent(new FactionClaimEvent(claimingFaction, chunk));
	}
	
	public static boolean canBuild(FPlayer fPlayer, int x, int z)
	{
		String world = Bukkit.getPlayer(fPlayer.getUUID()).getLocation().getWorld().getName(); //or if player has bypass
		String pName = Bukkit.getPlayer(fPlayer.getUUID()).getName();
		return Board.getFaction(world, x, z).equals(fPlayer.getFaction()) || Board.getFaction(world, x, z).equals("none") || FPlayer.fBypassEnabled(pName);
	}
	
	public static void saveFactionToFile(Faction fac)
	{
		
	}
	
	public static boolean hasInvite(Faction fac, FPlayer fPlayer)
	{
		return true;
	}
	
	public static GroupEnum getFactionGroup(FPlayer fPlayer)
	{
		Faction fac = fPlayer.getFaction();
		Player player = Bukkit.getPlayer(fPlayer.getUUID());
		String name = player.getName();
		if(fac.getAdmin().equals(name))
			return GroupEnum.ADMIN;
		else if(fac.getMods().contains(name))
			return GroupEnum.MOD;
		else if(fac.getMembers().contains(name))
			return GroupEnum.MEMBER;
		
		return GroupEnum.NONE;
	}
}
