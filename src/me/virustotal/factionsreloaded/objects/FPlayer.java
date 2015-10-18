package me.virustotal.factionsreloaded.objects;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FPlayer {
	
	private UUID uuid;
	private int power;
	private int maxPower;
	private Faction faction;
	private String lastKnownName;
	private boolean fSpyEnabled;
	private boolean fBypassEnabled;
	private boolean fChatEnabled;
	private static ArrayList<FPlayer> fPlayers = new ArrayList<FPlayer>();
	
	public FPlayer(UUID uuid, int power, Faction faction, String lastKnownName)
	{
		this.uuid = uuid;
		this.power = power;
		this.faction = faction;
		this.lastKnownName = lastKnownName;
		this.fBypassEnabled = false;
		this.fBypassEnabled = false;
		this.fChatEnabled = false;
	}
	
	public UUID getUUID()
	{
		return this.uuid;
	}
	
	public int getMaxPower()
	{
		return this.maxPower;
	}
	
	public void setMaxPower(int power)
	{
		this.power = power;
	}
	
	public int getPower()
	{
		return this.power;
	}
	
	public void setPower(int power)
	{
		this.power = power;
	}
	
	public Faction getFaction()
	{
		return this.faction;
	}
	
	public String getLastKnownName()
	{
		return this.lastKnownName;
	}
	
	public boolean getFSpyEnabled()
	{
		return this.fSpyEnabled;
	}
	
	public boolean getFBypassEnabled()
	{
		return this.fBypassEnabled;
	}
	
	public void setLastKnownName(String lastKnownName)
	{
		this.lastKnownName = lastKnownName;
	}
	
	public boolean getFChatEnabled()
	{
		return this.fChatEnabled;
	}
	
	public void setFChatEnabled(boolean fChatEnabled)
	{
		this.fChatEnabled = fChatEnabled;
	}
	
	public static FPlayer getFPlayer(Player player)
	{
		for(FPlayer fPlayer : fPlayers)
		{
			if(fPlayer.getUUID().equals(player.getUniqueId()))
				return fPlayer;
		}
		return null;
	}
	
	public static FPlayer getFPlayer(String player)
	{
		return FPlayer.getFPlayer(Bukkit.getPlayer(player));
	}
	
	public static boolean fBypassEnabled(String player)
	{
		return FPlayer.getFPlayer(player).getFBypassEnabled();
	}
	
	public static boolean fSpyEnabled(String player)
	{
		return FPlayer.getFPlayer(player).getFSpyEnabled();
	}
	
	public static ArrayList<FPlayer> getFPlayers()
	{
		return fPlayers;
	}
}
