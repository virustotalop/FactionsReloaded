package me.virustotal.factionsreloaded.customevents;

import me.virustotal.factionsreloaded.objects.Faction;

import org.bukkit.Chunk;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class FactionLandClaimEvent extends Event {

	private Faction faction;
	private Chunk chunk;
	public FactionLandClaimEvent(Faction claimingFaction, Chunk chunk) 
	{
		this.faction = claimingFaction;
		this.chunk = chunk;
	}
	
	public Faction getFaction()
	{
		return this.faction;
	}
	
	public Chunk getChunk()
	{
		return this.chunk;
	}

	@Override
	public HandlerList getHandlers() 
	{
		return null;
	}

}
