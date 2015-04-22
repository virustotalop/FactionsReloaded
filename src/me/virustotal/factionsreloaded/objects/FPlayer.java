package me.virustotal.factionsreloaded.objects;

import java.util.UUID;

import me.virustotal.factionsreloaded.FactionsReloaded;

import org.bukkit.entity.Player;

public class FPlayer {
	
	private UUID uuid;
	private int power;
	private String faction;
	
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
		String pName = player.getName();
		FactionsReloaded plugin = FactionsReloaded.get();
		return plugin.fPlayerCache.get(pName);
	}
	
}
