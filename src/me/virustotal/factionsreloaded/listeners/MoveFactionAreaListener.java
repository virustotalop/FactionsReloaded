package me.virustotal.factionsreloaded.listeners;

import me.virustotal.factionsreloaded.FactionsReloaded;
import me.virustotal.factionsreloaded.objects.Board;

import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveFactionAreaListener implements Listener {
	
	private FactionsReloaded plugin;
	public MoveFactionAreaListener(FactionsReloaded plugin)
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
			String from = Board.getFaction(fromChunk.getWorld().getName(), fromChunk.getX(), fromChunk.getZ());
			String to = Board.getFaction(toChunk.getWorld().getName(),toChunk.getX(),toChunk.getZ());
			
			if(!from.equals("none") && to.equals("none"))
			{
				e.getPlayer().sendMessage(plugin.config.fWildernessEnter);
			}
			else if(from.equals("none") && !to.equals("none"))
			{
				e.getPlayer().sendMessage(plugin.config.fFactionEnter.replace("{faction}", to));
			}
		}
	}

}
