package me.virustotal.factionsreloaded.objects;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FPlayer {
	
	private UUID uuid;
	private int power;
	private String faction;
	private static ArrayList<FPlayer> fPlayers = new ArrayList<FPlayer>();
	
	public FPlayer(UUID uuid, int power, String faction)
	{
		this.uuid = uuid;
		this.power = power;
		this.faction = faction;
	}
	
	public UUID getUUID()
	{
		return this.uuid;
	}
	
	public int getPower()
	{
		return this.power;
	}
	
	public String getFaction()
	{
		return this.faction;
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
		Player p = Bukkit.getPlayer(player);
		if(p == null)
			return null;
		for(FPlayer fPlayer : fPlayers)
		{
			if(fPlayer.getUUID().equals(p.getUniqueId()))
				return fPlayer;
		}
		return null;
	}
	
	public static ArrayList<FPlayer> getFPlayers()
	{
		return fPlayers;
	}
}
