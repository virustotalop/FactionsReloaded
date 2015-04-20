package me.virustotal.FactionsReloaded.Objects;

import java.util.UUID;

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
	
}
