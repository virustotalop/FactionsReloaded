package me.virustotal.FactionsReloaded.Listeners;

import me.virustotal.FactionsReloaded.ConfigHandler;
import me.virustotal.FactionsReloaded.Utils.BoardUtil;

import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveFactionAreaListener implements Listener {
	
	@EventHandler
	public void move(PlayerMoveEvent e)
	{
		if(!e.getFrom().getChunk().equals(e.getTo().getChunk()))
		{
			Chunk fromChunk = e.getFrom().getChunk();
			Chunk toChunk = e.getFrom().getChunk();
			String from = BoardUtil.getFaction(fromChunk.getWorld().getName(), fromChunk.getX(), fromChunk.getZ());
			String to = BoardUtil.getFaction(toChunk.getWorld().getName(),toChunk.getX(),toChunk.getZ());
			
			if(!from.equals("none") && to.equals("none"))
			{
				e.getPlayer().sendMessage(ConfigHandler.fWildernessEnter);
			}
			else if(from.equals("none") && !to.equals("none"))
			{
				e.getPlayer().sendMessage(ConfigHandler.fFactionEnter.replace("{faction}", to));
			}
		}
	}

}
