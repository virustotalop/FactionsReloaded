package me.virustotal.factionsreloaded.listeners;

import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.Messages;
import me.virustotal.factionsreloaded.objects.Board;
import me.virustotal.factionsreloaded.objects.Faction;

import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FactionLandListener implements Listener {

	private FactionsReloaded plugin;
	public FactionLandListener(FactionsReloaded plugin)
	{
		this.plugin = plugin;
	}

	@EventHandler
	public void move(PlayerMoveEvent e)
	{
		if(!e.getFrom().getChunk().equals(e.getTo().getChunk()))
		{
			Chunk fromChunk = e.getFrom().getChunk();
			Chunk toChunk = e.getFrom().getChunk();
			Faction from = Board.getFaction(fromChunk.getWorld().getName(), fromChunk.getX(), fromChunk.getZ());
			Faction to = Board.getFaction(toChunk.getWorld().getName(),toChunk.getX(),toChunk.getZ());
			
			if(!from.equals(to))
			e.getPlayer().sendMessage(Messages.fFactionEnter.replace("{faction}", to.getName()));
		}
	}
}
