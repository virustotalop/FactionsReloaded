package me.virustotal.factionsreloaded.customevents;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class FactionCreateEvent extends Event implements Cancellable {
	
	private Player player;
	private boolean cancelled = false;
	
	public FactionCreateEvent(Player player)
	{
		this.player = player;	
	}
	
	public Player getPlayer()
	{
		return this.player;
	}

	@Override
	public boolean isCancelled() 
	{
		return this.cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) 
	{
		this.cancelled = cancelled;
	}

	@Override
	public HandlerList getHandlers() {
		return null;
	}

}
